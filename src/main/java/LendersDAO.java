import java.util.*;

public interface LendersDAO {
	int getTotalAvailableAmount();
	int getTotalLentAmount();
	int getTotalAmount();
	int getTotalLenderNumber();
	ArrayList<LenderDTO> getAllLenderList();
	SortedSet<LenderDTO> getAllLendersSet();
	
	//public List<LenderDAO> getLenderDetailByName(String name);	
}
