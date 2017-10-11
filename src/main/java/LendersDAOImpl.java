import java.util.*;

public class LendersDAOImpl implements LendersDAO {

	private SortedSet<LenderDTO> LenderDataSource;
	private int totalAvailableAmount;
	private int totalLentAmount;
	private int totalAmount;

	@Override
	public ArrayList getAllLenderList() {
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

	public LendersDAOImpl() {
		this(new TreeSet<LenderDTO>());
	}

	private void setAmount(){
		for(LenderDTO d : LenderDataSource){
			this.totalAmount += d.getTotalFund();
		}
		totalAvailableAmount = totalAmount;
	}

	public void setLenderDataSource(SortedSet<LenderDTO> lenderDataSource) {
		LenderDataSource = lenderDataSource;
	}


	@Override
	public int getTotalAvailableAmount() {
		return totalAvailableAmount;
	}

	@Override
	public int getTotalLentAmount() {
		return totalLentAmount;
	}

	@Override
	public int getTotalAmount() {
		return totalAmount;
	}
}
