import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class CalculateServiceImpTest {

    /*public void quote(int loanAmount);
    public String generateInfo();
    public boolean hasSufficentFund(int loanAmount);
    public boolean isValidAmount(int loanAmount);*/


    CaculateServiceInterface caculateService;

    @Before
    public void setUp(){
        LenderDTO l1 = new LenderDTO("test1", 0.05f, 1000);
        LenderDTO l2 = new LenderDTO("test2", 0.01f, 5000);
        LenderDTO l3 = new LenderDTO("test3", 0.1f, 500);

        TreeSet dataSource = new TreeSet<LenderDTO>();
        dataSource.add(l1);
        dataSource.add(l2);
        dataSource.add(l3);

        this.caculateService = new CalculateServiceImp(new LendersDAOImpl(dataSource));
    }

    @Test
    public void quoteTest(){

    }

    @Test public void hasSufficientFundTest(){
        assertEquals(true,caculateService.hasSufficientFund(1000));
        assertEquals(false ,caculateService.hasSufficientFund(10000));
    }

    @Test public void isValidAmountTest(){
        assertEquals(true,caculateService.isValidAmount(1000));
        assertEquals(false,caculateService.isValidAmount(5240));
    }


}
