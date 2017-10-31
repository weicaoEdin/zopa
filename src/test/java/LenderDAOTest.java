import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class LenderDAOTest {

/*
	public boolean hasSufficientFund(int loanAmount);
	public int getTotalAvailableAmount();
	public int getTotalLentAmount();
	public int getTotalAmount();

	public int getTotalLenderNumber();
	public ArrayList getAllLenderList();
	public SortedSet getAllLendersSet();

	*/
    LendersDAO lendersDAO;


    @Before
    public void setUp(){
        LenderDTO l1 = new LenderDTO("test1", "0.05", "1000");
        LenderDTO l2 = new LenderDTO("test2", "0.01", "5000");
        LenderDTO l3 = new LenderDTO("test3", "0.1", "500");

        TreeSet dataSource = new TreeSet<LenderDTO>();
        dataSource.add(l1);
        dataSource.add(l2);
        dataSource.add(l3);
        lendersDAO = new LendersDAOImpl(dataSource);

    }

    @Test
    public void getTotalLenderNumberTest(){
        assertEquals(3,lendersDAO.getTotalLenderNumber());
    }

    @Test
    public void getTotalAmountTest(){
        LendersDAO localLenderDao = new LendersDAOImpl();
        assertEquals(0,localLenderDao.getTotalAmount());
        assertEquals(6500,lendersDAO.getTotalAmount());
    }


    @Test
    public void getTotalAvailableAmountTest(){
        LendersDAO localLenderDao = new LendersDAOImpl();
        assertEquals(0,localLenderDao.getTotalAvailableAmount());
        assertEquals(6500,lendersDAO.getTotalAvailableAmount());
    }




}
