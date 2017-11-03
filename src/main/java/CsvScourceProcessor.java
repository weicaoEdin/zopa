import java.io.*;
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



        BufferedReader br = null;
        try {
            File fileIn = new File(csvFile);
            br =  new BufferedReader(new FileReader(fileIn));

            String line = null;
            String Firstline = br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(",");
                if (data.length != 3) throw new Exception("invalid CSV file input, Please check file.");

                String name = data[0];
                BigDecimal rate = new BigDecimal(data[1], RateCalculateSystem.mathContext);
                if(!validateRate(rate)) throw new Exception("invalid CSV file input, Please check file.");
                int totalFund = Integer.parseInt(data[2]);


                LenderDTO lenderData = new LenderDTO(name, rate, totalFund);
                lendersDataSet.add(lenderData);

            }

        } catch (IOException e) {
            System.out.println("can not find file");
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("CSV file contains invalid number");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return lendersDataSet;
    }

	@Override
	public LendersDAO readSource(String csvFile) {
        SortedSet<LenderDTO> dataSet = processCSVSource(csvFile);
        LendersDAO lendersDataSource = new LendersDAOImpl(dataSet);
        return lendersDataSource;
	}

	public boolean validateRate(BigDecimal rate){
	    return rate.compareTo(BigDecimal.ZERO) >= 0 || rate.compareTo(BigDecimal.ONE) <= 0;
    }



}
