package com.weicao;

import org.junit.Test;

import java.util.List;
import java.util.SortedSet;

import static org.junit.Assert.assertEquals;


public class CSVsourceProcessorTest {
	
	CsvScourceProcessor reader = new CsvScourceProcessor();
	//String csvFileLocatoin = "src/main/resources/TestCSV";
	String csvFileLocatoin = "src/test/resources/TestCSV";


    @Test
    public void processCSVSourceTest() throws InvalidSourceFileException {
        LendersDAO data = reader.readSource(csvFileLocatoin);
        assertEquals(3, data.getAllLenderList().size());
        assertEquals( new LenderDTO("test1","0.05", "1000"),data.getAllLendersSet().first());
    }

    @Test
    public void readSourceTest() throws InvalidSourceFileException {
        LendersDAO data = reader.readSource(csvFileLocatoin);
        assertEquals(3, data.getTotalLenderNumber());
        assertEquals( new LenderDTO("test1","0.05", "1000"),data.getAllLendersSet().first());
    }
	
}
