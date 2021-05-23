package com.pp.dao.impl;

import com.pp.pojo.Im;
import com.pp.pojo.Price;
import com.pp.test.testpicture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImImpl implements ImDao {

    public List<Im> getIm(Connection connection, Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Im> im = new ArrayList<Im>();

        if (connection != null) {
            String sql = "select * from Im where id=?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

            while (resultSet.next()) {
                Im im1 = new Im();
                im1.setId(resultSet.getInt("id"));
                im1.setName(resultSet.getString("name"));
                im1.setImfor(resultSet.getString("imfor"));
//                im1.setPict1(resultSet.getString("pict1"));
//                im1.setPict2(resultSet.getString("pict2"));
//                im1.setPict3(resultSet.getString("pict3"));

                String i1=resultSet.getString("pict1");
                i1=testpicture.class.getResource("../../../")+i1;
                i1=i1.substring(6);
                im1.setPict1(i1);

                String i2=resultSet.getString("pict2");
                i2=testpicture.class.getResource("../../../")+i2;
                i2=i2.substring(6);
                im1.setPict2(i2);

                String i3=resultSet.getString("pict3");
                i3=testpicture.class.getResource("../../../")+i3;
                i3=i3.substring(6);
                im1.setPict3(i3);
                im.add(im1);
            }

            BaseDao.closeResource(null, preparedStatement, resultSet);
        }

        return im;
    }

}
