package com.weicao;

import java.util.*;

public class LendersDAOImpl implements LendersDAO {

	private final SortedSet<LenderDTO> LenderDataSource;
	private int totalAvailableAmount;
	private int totalAmount;

	@Override
	public List<LenderDTO> getAllLenderList() {
		return new ArrayList(LenderDataSource);
	}

	@Override
	public SortedSet<LenderDTO> getAllLendersSet() {
		return getLenderDataSource();
	}

	@Override
	public int getTotalLenderNumber() {
		return getLenderDataSource().size();
	}

	public SortedSet<LenderDTO> getLenderDataSource() {
		return LenderDataSource;
	}

	public LendersDAOImpl(SortedSet<LenderDTO> lenderDataSource) {
		LenderDataSource = lenderDataSource;
		setAmount();
	}

	private void setAmount(){
		for(LenderDTO d : LenderDataSource){
			this.totalAmount += d.getTotalFund();
		}
		totalAvailableAmount = totalAmount;
	}

	@Override
	public int getTotalAvailableAmount() {
		return totalAvailableAmount;
	}

	@Override
	public int getTotalAmount() {
		return totalAmount;
	}
}
