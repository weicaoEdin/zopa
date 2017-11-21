package com.weicao;

import java.math.BigDecimal;

public interface LoanCalculatorInterface {

    BigDecimal calculateMonthlyPayment(int loanAmount, int terms, BigDecimal rate);

}
