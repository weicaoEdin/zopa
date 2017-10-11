import java.util.*;

public interface LendersDAO {

	public int getTotalAvailableAmount();
	public int getTotalLentAmount();
	public int getTotalAmount();

	public int getTotalLenderNumber();
	public ArrayList getAllLenderList();
	public SortedSet getAllLendersSet();
	
	//public List<LenderDAO> getLenderDetailByName(String name);	
}
