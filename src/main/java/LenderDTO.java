public class LenderDTO implements Comparable{
	
	private String name;
	private float rate;
	private int availableFund;
	private int totalFund;
	
	public LenderDTO(String name, float rate, int totalFund){
		this.name = name;
		this.rate = rate;
		this.totalFund = totalFund;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getRate() { return rate; }
	public void setRate(float rate) {
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
			return name.equals(lender.getName()) && rate== lender.getRate()
					&& availableFund == lender.getAvailableFund();
		}
		 return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof LenderDTO){
			LenderDTO data = (LenderDTO) o;
			if(this.rate == data.getRate()) return 0;
			return this.rate > data.getRate()? 1:-1;
			
		}
		return 0;
	}

	public int getTotalFund() {
		return totalFund;
	}

	public void setTotalFund(int totalFund) {
		this.totalFund = totalFund;
	}

	
}
