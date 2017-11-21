package com.weicao;

import java.util.*;

public interface LendersDAO {

	int getTotalAvailableAmount();
	int getTotalAmount();
	int getTotalLenderNumber();
	List<LenderDTO> getAllLenderList();
	SortedSet<LenderDTO> getAllLendersSet();

}
