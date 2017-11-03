import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.Locale;

public class DisplayInformationService {


    private static final String REQUEST_AMOUMT = "Requested amount: ";
    private static final String RATE = "Rate: ";
    private static final String MONTHLY_REPAYMENT = "Monthly repayment: ";
    private static final String TOTAL_REPAYMENT = "Total repayment: ";
    private static final String INVALID_AMOUNT_ERROR_MESSAGE = "Sorry, the amount is not valid. It has to be multiple of 100," +
            "and between 1000 and 15000";
    private static final String SUFFICIENT_AMOUNT_ERROR_MESSAGE = "Sorry, we don't have enough money";


    public void displayLoanInfor(DisplayDTO displayDTO) {

        if(displayDTO.isError()){
            System.out.println(getErrorMessage(displayDTO));
        }else{
            System.out.println(REQUEST_AMOUMT + printRequestAmount(displayDTO));
            System.out.println(RATE + printRate(displayDTO));
            System.out.println(MONTHLY_REPAYMENT+ printMonthlyPayment(displayDTO));
            System.out.println(TOTAL_REPAYMENT + printTotalRepayment(displayDTO));
        }

    }


    private String getErrorMessage(DisplayDTO displayDTO){
        String errorMessage = "";
        if(displayDTO.isInValidAmount()){
            errorMessage = INVALID_AMOUNT_ERROR_MESSAGE;
        }else if(displayDTO.isSufficientAmount()){
            errorMessage = SUFFICIENT_AMOUNT_ERROR_MESSAGE;
        }else{
            errorMessage = "there is something wrong with a amount";
        }
        return errorMessage;
    }


    private String printCurrency(BigDecimal value){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
        return format.format(value.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    private String printCurrency(int value){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
        return format.format(value);
    }


    public String printRate(DisplayDTO displayDTO){
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

    public String printRequestAmount(DisplayDTO displayDTO){
        return printCurrency(displayDTO.getRequestAmount());
    }

    public String printMonthlyPayment(DisplayDTO displayDTO){
        return printCurrency(displayDTO.getMonthlyRepayment());
    }

    public String printTotalRepayment(DisplayDTO displayDTO){
        return printCurrency(displayDTO.getTotalRepayment());
    }

}
