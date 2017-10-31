import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class CalculateServiceImpTest {

    /*public void quote(int loanAmount);
    public String generateInfo();
    public boolean hasSufficentFund(int loanAmount);
    public boolean isValidAmount(int loanAmount);*/


    CalculateServiceInterface caculateService;

    @Before
    public void setUp(){
        LenderDTO l1 = new LenderDTO("test1", "0.5", "5000");
        LenderDTO l2 = new LenderDTO("test2", "0.4", "1000");
        LenderDTO l3 = new LenderDTO("test3", "0.3", "500");

        TreeSet dataSource = new TreeSet<LenderDTO>();
        dataSource.add(l1);
        dataSource.add(l2);
        dataSource.add(l3);

        this.caculateService = new CalculateServiceImp(new LendersDAOImpl(dataSource), new AmortizationCalculator());
    }

    @Test
    public void quoteTest(){

    }

    @Test
    public void hasSufficientFundTest(){
        assertEquals(true,caculateService.hasSufficientFund(1000));
        assertEquals(false ,caculateService.hasSufficientFund(10000));
    }

    @Test
    public void isValidAmountTest(){
        assertEquals(true,caculateService.isValidAmount(1000));
        assertEquals(false,caculateService.isValidAmount(5240));
    }

/*    @Test
    public void  getLoanTest(){

        List<LenderDTO>  lenders = caculateService.getLoan(1230);
        assertEquals(2,lenders.size());
        assertEquals(0,lenders.get(0).getAvailableFund());
        assertEquals(new BigDecimal("0.3"),lenders.get(0).getRate());
        assertEquals(270,lenders.get(1).getAvailableFund());
        assertEquals(new BigDecimal("0.4"),lenders.get(1).getRate());


    }*/



}
