import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmortizationCalculatorTest {

    private LoanCalculatorInterface amortizationCalculator = new AmortizationCalculator();

    @Before
    public void setUp(){

    }

    @Test
    public void calculateTotalLoanTest(){
        double singlePayment = amortizationCalculator.calculateMonthlyPayment(1000,36,0.07);
        assertEquals(30.88,singlePayment,0.0001);
    }



    @Test
    public void calculateMonthlyPaymentTest(){
        double TotalPayment = amortizationCalculator.calculateTotalPayment(1000,36,0.07);
        assertEquals(1111.68,TotalPayment,0.0001);
    }




}
