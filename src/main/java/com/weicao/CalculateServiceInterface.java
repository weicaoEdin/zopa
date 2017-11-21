package com.weicao;

import java.util.List;

public interface CalculateServiceInterface {

	DisplayDTO quote(int loanAmount);
	boolean hasSufficientFund(int loanAmount);
	boolean isValidAmount(int loanAmount);


	
}
