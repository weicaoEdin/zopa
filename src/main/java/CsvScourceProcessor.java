import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.SortedSet;
import java.util.TreeSet;

public class CsvScourceProcessor implements SourceProcessServiceInterface{

	/*
	Use SortedSet to keep rate in ascending order
	 */
	public SortedSet<LenderDTO> processCSVSource(String csvFile) {

        SortedSet<LenderDTO> lendersDataSet = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
 
        	String line;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(",");
                if(data.length != 3) throw new Exception("invalid CSV file input, Please check file.");
                
                String name = data[0];
                BigDecimal rate = new BigDecimal(data[1],RateCalculateSystem.mathContext);
                int totalFund = Integer.parseInt(data[2]);
                
                
                LenderDTO lenderData = new LenderDTO(name,rate,totalFund);
                lendersDataSet.add(lenderData);

            }

        } catch (IOException e) {
            System.out.println("data load failed.");
            e.printStackTrace();
        }catch (Exception e){
        	e.printStackTrace();
        }


		return lendersDataSet;
	}

	@Override
	public LendersDAO readSource(String csvFile) {
        SortedSet<LenderDTO> dataSet = processCSVSource(csvFile);
        LendersDAO lendersDataSource = new LendersDAOImpl(dataSet);
        return lendersDataSource;
	}

}
