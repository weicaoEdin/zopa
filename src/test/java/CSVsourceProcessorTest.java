import org.junit.Test;
import java.util.List;
import java.util.SortedSet;

import static org.junit.Assert.assertEquals;


public class CSVsourceProcessorTest {
	
	CsvScourceProcessor reader = new CsvScourceProcessor();
	String csvFileLocatoin = "src/main/resources/TestCSV";
	
/*	@Test
	public void processCSVSourceTest(){
		List<LenderDTO> data = reader.readSource(csvFileLocatoin);
        assertEquals(3, data.size());
        assertEquals("test1",data.get(0).getName());
        assertEquals(0.05,data.get(0).getRate(),0.00001);
        assertEquals(1000,data.get(0).getTotalFund());
	}*/

    @Test
    public void processCSVSourceTest(){
        SortedSet<LenderDTO> data = reader.processCSVSource(csvFileLocatoin);
        assertEquals(3, data.size());
        assertEquals( new LenderDTO("test1","0.05", "1000"),data.first());
    }

    @Test
    public void readSourceTest(){
        LendersDAO data = reader.readSource(csvFileLocatoin);
        assertEquals(3, data.getTotalLenderNumber());
        assertEquals( new LenderDTO("test1","0.05", "1000"),data.getAllLendersSet().first());
    }
	
}
