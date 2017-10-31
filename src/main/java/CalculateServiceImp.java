import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

    public LendersDAO getLendersDAO() {
        return lendersDAO;
    }

    public void setLendersDAO(LendersDAO lendersDAO) {
        this.lendersDAO = lendersDAO;
    }

    @Override
    public DisplayDTO quote(int loanAmount) {

        DisplayDTO displayDTO = new DisplayDTO();
        displayDTO.setTerms(TERM);

        if(!isValidAmount(loanAmount)){
            displayDTO.setError(true);
            displayDTO.setInvalidAmountErrorCode();
        }else if(!hasSufficientFund(loanAmount)) {
            displayDTO.setError(true);
            displayDTO.setSufficientAmountErrorMessage();
        }else{
            ArrayList<LenderDTO> result = getLoan(loanAmount, displayDTO);
            displayDTO.setLenders(result);
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
        return loanAmount%INCREMENT==0 && loanAmount <= MAX_LOAN && loanAmount >= MIN_LOAN?true:false;
    }

    private ArrayList<LenderDTO> getLoan(int loanAmount, DisplayDTO displayDTO){

        int leftAmount = loanAmount;
        ArrayList<LenderDTO> lenders = new ArrayList<>();
        for(LenderDTO lender :lendersDAO.getAllLenderList()){
            if(leftAmount > 0){
                lenders.add(lender);
                if(leftAmount > lender.getAvailableFund()){
                    loanCalculator.calculateMonthlyPayment(lender.getAvailableFund(),TERM,lender.getRate());


                    leftAmount = leftAmount-lender.getAvailableFund();
                    lender.setAvailableFund(0);
                }else{
                    lender.setAvailableFund(lender.getAvailableFund()-leftAmount);
                    leftAmount = 0;
                    break;
                }
            }
        }
        return lenders;
    }

    public DisplayDTO getDisplayDTO(List<LenderDTO> lenders){
        DisplayDTO displayDTO = new DisplayDTO();

        return displayDTO;
    }

}
