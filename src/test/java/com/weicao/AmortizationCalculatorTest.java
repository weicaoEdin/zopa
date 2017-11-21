package com.weicao;

import com.weicao.AmortizationCalculator;
import com.weicao.LoanCalculatorInterface;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AmortizationCalculatorTest {

    private LoanCalculatorInterface amortizationCalculator = new AmortizationCalculator();

    @Before
    public void setUp(){

    }

    @Test
    public void calculateTotalLoanTest(){
        BigDecimal singlePayment = amortizationCalculator.calculateMonthlyPayment(1000,36, new BigDecimal("0.07").setScale(3));
        assertEquals(new BigDecimal("30.78").setScale(2),singlePayment);
    }



/*

    @Test
    public void calculateMonthlyPaymentTest(){
        BigDecimal monthlyPayment = amortizationCalculator.calculateTotalPayment(1000,36,"0.07");
        assertEquals(1111.68,monthlyPayment,0.0001);
    }
*/




}
