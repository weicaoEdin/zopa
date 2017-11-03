import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


public class AmortizationCalculator implements LoanCalculatorInterface {

    @Override
    public BigDecimal calculateMonthlyPayment(int principal, int numberOfPayments, BigDecimal rate) {

        MathContext mathContext = RateCalculateSystem.mathContext;

        if(rate.compareTo(BigDecimal.ZERO)==0)
            return new BigDecimal(principal).divide(new BigDecimal(numberOfPayments),mathContext);

        BigDecimal monthlyRate = rate.divide(new BigDecimal(12),mathContext);

        /*
        using following formula to calculate monthlyPayment, this fomula is from wiki :
        https://en.wikipedia.org/wiki/Amortization_calculator

        singlePayment1 = principal*(effectiveRate+effectiveRate/(Math.pow(1+effectiveRate,numberOfPayments)-1));

         */
        BigDecimal p1 = monthlyRate.add(BigDecimal.ONE).pow(numberOfPayments,mathContext).subtract(BigDecimal.ONE);
        BigDecimal singlePayment = monthlyRate.add(monthlyRate.divide(p1,mathContext)).multiply(new BigDecimal(principal),mathContext);

        return singlePayment.setScale(2,RoundingMode.HALF_UP);



    }

/*    @Override
    public double calculateMonthlyPayment(int principal, int numberOfPayments, double rate) {
;
        if(rate == 0) return principal/numberOfPayments;

        double effectiveRate = new BigDecimal(rate/12, mathContext).doubleValue();



        double singlePayment = principal*effectiveRate/(1-Math.pow((1+effectiveRate),-numberOfPayments));
        //double singlePayment1 = principal*(effectiveRate+effectiveRate/(Math.pow(1+effectiveRate,numberOfPayments)-1));
        //double singlePayment2 = principal*effectiveRate*Math.pow(1+effectiveRate,numberOfPayments)/(Math.pow(1+effectiveRate,numberOfPayments)-1);

        return singlePayment;

    }*/
}
