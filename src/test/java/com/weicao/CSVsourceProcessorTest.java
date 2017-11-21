package com.weicao;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CSVsourceProcessorTest {
	
	private CsvScourceProcessor reader = new CsvScourceProcessor();
	private String csvFileLocatoin = "TestCSV";
	
/*	@Test
	public void processCSVSourceTest(){
		List<LenderDTO> data = reader.readSource(csvFileLocatoin);
        assertEquals(3, data.size());
        assertEquals("test1",data.get(0).getName());
        assertEquals(0.05,data.get(0).getRate(),0.00001);
        assertEquals(1000,data.get(0).getTotalFund());
	}*/

    @Test
    public void processCSVSourceTest() throws InvalidSourceFileException {
        LendersDAO lendersDAO= reader.readSource(csvFileLocatoin);
        assertEquals(3, lendersDAO.getAllLenderList().size());
        assertEquals( new LenderDTO("test1","0.05", "1000"),lendersDAO.getAllLendersSet().first());
    }

    @Test
    public void readSourceTest() throws InvalidSourceFileException {
        LendersDAO data = reader.readSource(csvFileLocatoin);
        assertEquals(3, data.getTotalLenderNumber());
        assertEquals( new LenderDTO("test1","0.05", "1000"),data.getAllLendersSet().first());
    }
	
}
