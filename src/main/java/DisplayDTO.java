import java.math.BigDecimal;
import java.util.ArrayList;

public class DisplayDTO {

    private ArrayList<LenderDTO> lenders;
    private int requestAmount;
    private BigDecimal rate;
    private BigDecimal monthlyRepayment;
    private boolean error;

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    private int terms;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

    private static final String REQUEST_AMOUMT = "Requested amount: £";
    private static final String RATE = "Rate: ";
    private static final String MONTHLY_REPAYMENT = "Monthly repayment: £";
    private static final String TOTAL_REPAYMENT = "Total repayment: £";
    private static final String INVALID_AMOUNT_ERROR_MESSAGE = "Sorry, the amount is not valid";
    private static final String SUFFICIENT_AMOUNT_ERROR_MESSAGE = "Sorry, we don't have enough money";


    public ArrayList<LenderDTO> getLenders() {
        return lenders;
    }

    public void setLenders(ArrayList<LenderDTO> lenders) {
        this.lenders = lenders;
    }

    public int getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(int requestAmount) {
        this.requestAmount = requestAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(BigDecimal monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void displayLoanInfor(){

        if(isError()){
            System.out.println(getErrorMessage());
        }else{
            System.out.println(REQUEST_AMOUMT + getRequestAmount());
            System.out.println(RATE + getRate());
            System.out.println(MONTHLY_REPAYMENT+ getMonthlyRepayment());
            //System.out.println(TOTAL_REPAYMENT+ getTotalPayment());
        }


    }

    public void setInvalidAmountErrorCode() {
        this.errorMessage = INVALID_AMOUNT_ERROR_MESSAGE;
    }

    public void setSufficientAmountErrorMessage() {
        this.errorMessage = SUFFICIENT_AMOUNT_ERROR_MESSAGE;
    }
}
