import java.util.List;

public interface CaculateServiceInterface {
	
	void quote(int loanAmount);
	String generateInfo();
	boolean hasSufficientFund(int loanAmount);
	boolean isValidAmount(int loanAmount);
	List<LenderDTO> getLoan(int loanAmount);


	
}
