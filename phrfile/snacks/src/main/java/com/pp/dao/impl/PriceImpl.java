package com.pp.dao.impl;

import com.pp.pojo.Price;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceImpl implements PriceDao{
    @Override
    public List<Price> getType(Connection connection, Integer id) throws SQLException {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List<Price> price=new ArrayList<Price>();

        if (connection!=null){
            String sql="select * from price where id=?";
            Object[] params={id};

            resultSet=BaseDao.execute(connection,preparedStatement,resultSet,sql,params);

            while(resultSet.next()){
                Price price1=new Price();
                price1.setId(resultSet.getInt("id"));
                price1.setType(resultSet.getString("type"));
                price1.setPrice(resultSet.getDouble("price"));
                price.add(price1);

            }

            BaseDao.closeResource(null,preparedStatement,resultSet);
        }

        return price;
    }
}
