package com.weicao;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class LenderDAOTest {

    private LendersDAO lendersDAO;


    @Before
    public void setUp(){
        LenderDTO l1 = new LenderDTO("test1", "0.05", "1000");
        LenderDTO l2 = new LenderDTO("test2", "0.01", "5000");
        LenderDTO l3 = new LenderDTO("test3", "0.1", "500");

        TreeSet<LenderDTO> dataSource = new TreeSet<>();
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
        assertEquals(6500,lendersDAO.getTotalAmount());
    }


    @Test
    public void getTotalAvailableAmountTest(){
        assertEquals(6500,lendersDAO.getTotalAvailableAmount());
    }




}
