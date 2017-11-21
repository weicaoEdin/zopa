package com.weicao;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CalculateServiceImp implements CalculateServiceInterface {

    private static final int MAX_LOAN = 15000;
    private static final int MIN_LOAN = 1000;
    private static final int INCREMENT = 100;
    private static final int TERM = 36;

    private LoanCalculatorInterface loanCalculator;
    private LendersDAO lendersDAO;

    public CalculateServiceImp(LendersDAO lendersDAO, LoanCalculatorInterface loanCalculator) {
        this.lendersDAO = lendersDAO;
        this.loanCalculator = loanCalculator;
    }

    public CalculateServiceImp(LendersDAO lendersDAO) {
        this.lendersDAO = lendersDAO;
        this.loanCalculator = new AmortizationCalculator();
    }


    public LendersDAO getLendersDAO() {
        return lendersDAO;
    }


    @Override
    public DisplayDTO quote(int loanAmount) {

        DisplayDTO displayDTO = new DisplayDTO();
        displayDTO.setTerms(TERM);
        displayDTO.setRequestAmount(loanAmount);

        if(!isValidAmount(loanAmount)){
            displayDTO.setError(ERROR.INVALID_AMOUNT);
        }else if(!hasSufficientFund(loanAmount)) {
            displayDTO.setError(ERROR.INSUFFICIENT_FUND);
        }else{
            getLoan(loanAmount, displayDTO);
        }
        return displayDTO;
    }


    @Override
    public boolean hasSufficientFund(int loanAmount) {
        if(isValidAmount(loanAmount)){
            return loanAmount <= getLendersDAO().getTotalAvailableAmount();
        }
        return false;
    }

    @Override
    public boolean isValidAmount(int loanAmount) {
        return loanAmount%INCREMENT==0 && loanAmount <= MAX_LOAN && loanAmount >= MIN_LOAN;
    }

    private void getLoan(int loanAmount, DisplayDTO displayDTO){

        int leftAmount = loanAmount;
        BigDecimal monthlyPayment = BigDecimal.ZERO;

        ArrayList<LenderDTO> lenders = new ArrayList<>();
        for(LenderDTO lender :lendersDAO.getAllLenderList()){
            if(leftAmount > 0){
                lenders.add(lender);
                if(leftAmount > lender.getAvailableFund()){
                   monthlyPayment = monthlyPayment.add(
                           loanCalculator.calculateMonthlyPayment(lender.getAvailableFund(),TERM,lender.getRate())
                   );
                    leftAmount = leftAmount-lender.getAvailableFund();
                    lender.setAvailableFund(0);
                }else{
                    lender.setAvailableFund(lender.getAvailableFund()-leftAmount);
                    monthlyPayment = monthlyPayment.add(
                            loanCalculator.calculateMonthlyPayment(leftAmount,TERM,lender.getRate())
                    );
                    leftAmount = 0;
                }
            }
        }
        displayDTO.setMonthlyRepayment(monthlyPayment);
        displayDTO.setLenders(lenders);
    }

}
