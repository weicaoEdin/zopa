import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class AmortizationCalculator implements LoanCalculatorInterface {

/*
    @Override
    public BigDecimal calculateTotalPayment(int principal, int numberOfPayments, BigDecimal rate) {
        MathContext mathContext = new MathContext(3, RoundingMode.CEILING);
        return calculateMonthlyPayment(principal, numberOfPayments, rate).multiply(new BigDecimal(numberOfPayments), mathContext);
    }*/
    @Override
    public BigDecimal calculateMonthlyPayment(int principal, int numberOfPayments, BigDecimal rate) {

        MathContext mathContext = new MathContext(7, RoundingMode.HALF_DOWN);

        if(rate.compareTo(BigDecimal.ZERO)==0)
            return new BigDecimal(principal).divide(new BigDecimal(numberOfPayments),mathContext);

        BigDecimal montlyRate = rate.divide(new BigDecimal(12),mathContext);

        //double singlePayment1 = principal*(effectiveRate+effectiveRate/(Math.pow(1+effectiveRate,numberOfPayments)-1));
        BigDecimal p1 = montlyRate.add(BigDecimal.ONE).pow(numberOfPayments,mathContext).subtract(BigDecimal.ONE);
        BigDecimal singlePayment = montlyRate.add(montlyRate.divide(p1,mathContext)).multiply(new BigDecimal(principal),mathContext);

        return singlePayment;



    }

    @Override
    public double calculateMonthlyPayment(int principal, int numberOfPayments, double rate) {

        MathContext mathContext = new MathContext(3, RoundingMode.HALF_UP);
        if(rate == 0) return principal/numberOfPayments;

        double effectiveRate = new BigDecimal(rate/12, mathContext).doubleValue();



        double singlePayment = principal*effectiveRate/(1-Math.pow((1+effectiveRate),-numberOfPayments));
        //double singlePayment1 = principal*(effectiveRate+effectiveRate/(Math.pow(1+effectiveRate,numberOfPayments)-1));
        //double singlePayment2 = principal*effectiveRate*Math.pow(1+effectiveRate,numberOfPayments)/(Math.pow(1+effectiveRate,numberOfPayments)-1);

        return singlePayment;

    }
}
