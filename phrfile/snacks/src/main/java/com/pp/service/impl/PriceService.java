package com.pp.service.impl;

import com.pp.dao.impl.*;
import com.pp.pojo.Im;
import com.pp.pojo.Price;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PriceService {

    private PriceDao priceDao;
    public PriceService(){
        priceDao=new PriceImpl();
    }

    public List<Price> showType(Integer id){
        Connection connection=null;
        List<Price> price=null;

        try {
            connection= BaseDao.getConnection();
            price=priceDao.getType(connection,id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return price;
    }



    @Test
    public void test(){
        PriceService userService=new PriceService();
        List<Price> price=userService.showType(2);
        for(Price p:price)
            System.out.println(p.getId()+" "+p.getType()+" "+p.getPrice());

    }


}


