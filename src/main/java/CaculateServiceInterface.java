public interface CaculateServiceInterface {
	
	public void quote(int loanAmount);
	public String generateInfo();
	public boolean hasSufficientFund(int loanAmount);
	public boolean isValidAmount(int loanAmount);
	
	
}
