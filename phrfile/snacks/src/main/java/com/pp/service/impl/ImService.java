package com.pp.service.impl;

import com.pp.dao.impl.BaseDao;
import com.pp.dao.impl.ImDao;
import com.pp.dao.impl.ImImpl;
import com.pp.pojo.Im;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ImService {

    private ImDao imDao;
    public ImService(){
        imDao=new ImImpl();
    }


    public List<Im> showIm(Integer id){
        Connection connection=null;
        List<Im> im=null;

        try {
            connection= BaseDao.getConnection();
            im=imDao.getIm(connection,id);
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
    public void test1(){
        ImService imService = new ImService();
        List<Im> im=imService.showIm(1);
        for(Im i:im)
            System.out.println(i.getId()+" "+i.getName()+" "+i.getImfor()+" " +i.getPict1()+" "+i.getPict2()+" "+i.getPict3());

    }

}


