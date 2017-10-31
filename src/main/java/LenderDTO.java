import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;

public class LenderDTO implements Comparable<LenderDTO>{
	
	private String name;
	private BigDecimal rate;
	private int availableFund;
	private int totalFund;
	private static MathContext mathContext = new MathContext(3, RoundingMode.CEILING);
	
	public LenderDTO(String name, BigDecimal rate, int totalFund){
		this.name = name;
		this.rate = rate;
		this.totalFund = totalFund;
		this.availableFund = totalFund;
	}

	public LenderDTO(String name, String rate, String totalFund){
		this(name, new BigDecimal(rate,mathContext),Integer.parseInt(totalFund));
	}
	public LenderDTO(){

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getRate() { return rate; }
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public int getAvailableFund() {
		return availableFund;
	}
	public void setAvailableFund(int availableFund) {
		this.availableFund = availableFund;
	}
	
	@Override
	public int hashCode(){
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if(o instanceof LenderDTO){
			LenderDTO lender = (LenderDTO) o;
			return name.equals(lender.getName()) && lender.getRate().equals(((LenderDTO) o).getRate())
					&& availableFund == lender.getAvailableFund();
		}
		 return false;
	}

	@Override
	public int compareTo(LenderDTO o) {
		// TODO Auto-generated method stub
		return getRate().compareTo(o.getRate());
	}

	public int getTotalFund() {
		return totalFund;
	}

	public void setTotalFund(int totalFund) {
		this.totalFund = totalFund;
	}

	public int getLentAmount(){
		return totalFund-availableFund;
	}

	
}
