import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class DisplayInformationService {


    private static final String REQUEST_AMOUMT = "Requested amount: ";
    private static final String RATE = "Rate: ";
    private static final String MONTHLY_REPAYMENT = "Monthly repayment: ";
    private static final String TOTAL_REPAYMENT = "Total repayment: ";
    private static final String INVALID_AMOUNT_ERROR_MESSAGE = "Sorry, the amount is not valid";
    private static final String SUFFICIENT_AMOUNT_ERROR_MESSAGE = "Sorry, we don't have enough money";


    public void displayLoanInfor(DisplayDTO displayDTO) {

        if(displayDTO.isError()){
            System.out.println(getErrorMessage(displayDTO));
        }else{
            System.out.println(REQUEST_AMOUMT + printCurrency(displayDTO.getRequestAmount()));
            //System.out.println(RATE + printRate(rate));
            System.out.println(MONTHLY_REPAYMENT+ printCurrency(displayDTO.getMonthlyRepayment()));
            System.out.println(TOTAL_REPAYMENT + printCurrency(displayDTO.getTotalRepayment()));
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


    public String printCurrency(BigDecimal value){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
        return format.format(value.setScale(2).toString());
    }

    public String printCurrency(int value){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.UK);
        return format.format(value);
    }

/*    public String printRate(LenderDTO lenderDTO){
        NumberFormat format = NumberFormat.getPercentInstance(Locale.UK);
        StringBuffer rates = new StringBuffer();
        for(LenderDTO lender : lenders){
            rates.append(format.format(rate.setScale(3).toString())).append("@").append(lender.getLentAmount());
        }
        return rates.toString();

    }*/

}
