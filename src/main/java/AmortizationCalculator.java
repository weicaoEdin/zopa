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

        MathContext mathContext = new MathContext(3, RoundingMode.HALF_UP);

        if(rate.compareTo(BigDecimal.ZERO)==0)
            return new BigDecimal(principal).divide(new BigDecimal(numberOfPayments),mathContext);

        BigDecimal effectiveRate = rate.divide(new BigDecimal(12),mathContext);
        double effectiveRate1 = rate.divide(new BigDecimal(numberOfPayments)).doubleValue();

        BigDecimal p1 = effectiveRate.add(BigDecimal.ONE).pow(numberOfPayments,mathContext).subtract(BigDecimal.ONE);
        //return singlePayment = effectiveRate.divide(p1,mathContext).add(effectiveRate).multiply(new BigDecimal(principal),mathContext);

        double singlePayment = principal*effectiveRate1/(1-Math.pow((1+effectiveRate1),-numberOfPayments));
        return new BigDecimal(singlePayment,mathContext).setScale(2);
        //double singlePayment = principal*effectiveRate/(1-Math.pow((1+effectiveRate),-numberOfPayments))
        //double singlePayment1 = principal*(effectiveRate+effectiveRate/(Math.pow(1+effectiveRate,numberOfPayments)-1));
        //double singlePayment2 = principal*effectiveRate*Math.pow(1+effectiveRate,numberOfPayments)/(Math.pow(1+effectiveRate,numberOfPayments)-1)

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
