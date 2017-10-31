import java.math.BigDecimal;

public interface LoanCalculatorInterface {

    BigDecimal calculateMonthlyPayment(int loanAmount, int terms, BigDecimal rate);

    double calculateMonthlyPayment(int principal, int numberOfPayments, double rate);
}
