import java.io.File;
import java.util.List;
import java.util.SortedSet;

public interface SourceProcessServiceInterface {

	//public List<LenderDTO> readSource(String csv);
	public LendersDAO readSource(String csv);
}
