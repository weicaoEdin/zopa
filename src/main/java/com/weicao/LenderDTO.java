package com.weicao;

import java.math.BigDecimal;

public class LenderDTO implements Comparable<LenderDTO>{
	
	private final String name;
	private final BigDecimal rate;
	private final int totalFund;
	private int availableFund;
	
	public LenderDTO(String name, BigDecimal rate, int totalFund){
		this.name = name;
		this.rate = rate;
		this.totalFund = totalFund;
		this.availableFund = totalFund;
	}

	public LenderDTO(String name, String rate, String totalFund){
		this(name, new BigDecimal(rate, RateCalculateSystem.mathContext),Integer.parseInt(totalFund));
	}

	public String getName() {
		return name;
	}
	public BigDecimal getRate() { return rate; }
	public int getAvailableFund() {
		return availableFund;
	}
	public int getTotalFund() {
		return totalFund;
	}

	public void setAvailableFund(int availableFund) {
		this.availableFund = availableFund;
	}
	public int getLentAmount(){
		return totalFund-availableFund;
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
	
}
