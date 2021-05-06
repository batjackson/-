package com.pp.service.impl;

import com.pp.dao.impl.BaseDao;
import com.pp.dao.impl.UserDao;
import com.pp.dao.impl.UserImpl;
import com.pp.pojo.Im;
import com.pp.pojo.Price;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserDao userDao;
    public UserService(){
        userDao=new UserImpl();
    }

    public List<Price> showType(Integer id){
        Connection connection=null;
        List<Price> price=null;

        try {
            connection= BaseDao.getConnection();
            price=userDao.getType(connection,id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return price;
    }

    public List<Im> showIm(Integer id){
        Connection connection=null;
        List<Im> im=null;

        try {
            connection= BaseDao.getConnection();
            im=userDao.getIm(connection,id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return im;
    }



    @Test
    public void test(){
        UserService userService=new UserService();
        List<Price> price=userService.showType(2);
        for(Price p:price)
            System.out.println(p.getType()+" "+p.getPrice());

    }
}


