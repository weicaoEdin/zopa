public interface LoanCalculorInterface {

    double calculateTotalPayment(int loanAmount, int terms, double rate);
    double calculateMonthlyPayment(int loanAmount, int terms, double rate);
}
