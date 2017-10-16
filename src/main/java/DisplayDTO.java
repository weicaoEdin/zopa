public class DisplayDTO {

    private int requestAmount;
    private double rate;
    private double monthlyRepayment;
    private double totalRepayment;

    private static final String REQUEST_AMOUMT = "Requested amount: £";
    private static final String RATE = "Rate: ";
    private static final String MONTHLY_REPAYMENT = "Monthly repayment: £";
    private static final String TOTAL_REPAYMENT = "Total repayment: £";


    public void Display(){

        System.out.println(REQUEST_AMOUMT + requestAmount);
        System.out.println(RATE + rate);
        System.out.println(MONTHLY_REPAYMENT+ monthlyRepayment);
        System.out.println(TOTAL_REPAYMENT+ totalRepayment);

    }

}
