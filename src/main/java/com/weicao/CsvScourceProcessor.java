package com.weicao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

public class CsvScourceProcessor implements SourceProcessServiceInterface {

    @Override
	public LendersDAO readSource (String csvFile) throws InvalidSourceFileException {

        SortedSet<LenderDTO> lendersDataSet = new TreeSet<>();

       ClassLoader classLoader = getClass().getClassLoader();

        try (BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource(csvFile).getFile()))) {

        	String line;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(",");
                if(data.length != 3) throw new InvalidSourceFileException();
                
                String name = data[0];

                BigDecimal rate = new BigDecimal(data[1], RateCalculateSystem.mathContext);

                int totalFund = Integer.parseInt(data[2]);

                LenderDTO lenderData = new LenderDTO(name,rate,totalFund);
                lendersDataSet.add(lenderData);

            }

        }catch (IOException e) {
            System.out.println("data load failed. Invalid csv file");
            throw new InvalidSourceFileException();
        }catch (Exception e){
            System.out.println("data load failed. Data in csv file is invalid");
        	throw new InvalidSourceFileException();
        }

        return new LendersDAOImpl(lendersDataSet);

	}

}