public class AmortizationCalculator implements LoanCalculatorInterface {


    @Override
    public double calculateTotalPayment(int principal, int numberOfPayments, double rate) {
        return numberOfPayments * calculateMonthlyPayment(principal,numberOfPayments,rate);
    }

    @Override
    public double calculateMonthlyPayment(int principal, int numberOfPayments, double rate) {

        if(principal <= 0 || numberOfPayments <= 0 || rate < 0 ) return 0;
        if(rate == 0) return principal/numberOfPayments;

        double effectiveRate = rate/12;


        double singlePayment = principal*effectiveRate/(1-Math.pow((1+effectiveRate),-numberOfPayments));
        //double singlePayment1 = principal*(effectiveRate+effectiveRate/(Math.pow(1+effectiveRate,numberOfPayments)-1));
        //double singlePayment2 = principal*effectiveRate*Math.pow(1+effectiveRate,numberOfPayments)/(Math.pow(1+effectiveRate,numberOfPayments)-1);

        return roundTwoDecimal(singlePayment);

    }



    private double roundTwoDecimal(double number){
        return Math.round(number*100)/100d;
    }
}
