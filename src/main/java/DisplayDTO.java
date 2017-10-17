import java.util.ArrayList;

public class DisplayDTO {

    private ArrayList<LenderDTO> lenders;
    private int requestAmount;
    private double rate;
    private double monthlyRepayment;
    private double totalRepayment;
    private boolean error;

    private static final String REQUEST_AMOUMT = "Requested amount: £";
    private static final String RATE = "Rate: ";
    private static final String MONTHLY_REPAYMENT = "Monthly repayment: £";
    private static final String TOTAL_REPAYMENT = "Total repayment: £";
    private static final String ERROR_MESSAGE = "Sorry, the amount is not valid or we don't have enough money";


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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    public void setMonthlyRepayment(double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    public double getTotalRepayment() {
        return totalRepayment;
    }

    public void setTotalRepayment(double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void displayLoanInfor(){

        if(error){
            System.out.println(ERROR_MESSAGE);
        }else{
            System.out.println(REQUEST_AMOUMT + requestAmount);
            System.out.println(RATE + rate);
            System.out.println(MONTHLY_REPAYMENT+ monthlyRepayment);
            System.out.println(TOTAL_REPAYMENT+ totalRepayment);
        }


    }

}
