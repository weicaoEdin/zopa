package com.weicao;

import com.weicao.DisplayDTO;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class DisplayInformationService implements DisplayInformationServiceInterface {


    private static final String REQUEST_AMOUMT = "Requested amount: ";
    private static final String RATE = "Rate: ";
    private static final String MONTHLY_REPAYMENT = "Monthly repayment: ";
    private static final String TOTAL_REPAYMENT = "Total repayment: ";

    @Override
    public void displayLoanInfor(DisplayDTO displayDTO) {

        if(displayDTO.getError() != null){
            System.out.println(displayDTO.getError());
        }else{
            System.out.println(REQUEST_AMOUMT + printRequestAmount(displayDTO));
            System.out.println(RATE + printRate(displayDTO));
            System.out.println(MONTHLY_REPAYMENT+ printMonthlyPayment(displayDTO));
            System.out.println(TOTAL_REPAYMENT + printTotalRepayment(displayDTO));
        }

    }


    private String printCurrency(BigDecimal value){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
        return format.format(value.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    private String printCurrency(int value){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
        return format.format(value);
    }


    private String printRate(DisplayDTO displayDTO){
        NumberFormat format = NumberFormat.getPercentInstance(Locale.UK);
        format.setMaximumFractionDigits(3);
        StringBuilder allRates = new StringBuilder();
        for(LenderDTO lender : displayDTO.getLenders()){
            allRates.append(format.format(lender.getRate().setScale(3,BigDecimal.ROUND_HALF_UP)))
                    .append(" of ")
                    .append(printCurrency(lender.getLentAmount())).
                    append(", ");
        }
        return allRates.toString();

    }


    private String printRequestAmount(DisplayDTO displayDTO){
        return printCurrency(displayDTO.getRequestAmount());
    }

    private String printMonthlyPayment(DisplayDTO displayDTO){
        return printCurrency(displayDTO.getMonthlyRepayment());
    }

    private String printTotalRepayment(DisplayDTO displayDTO){
        return printCurrency(displayDTO.getTotalRepayment());
    }

}
