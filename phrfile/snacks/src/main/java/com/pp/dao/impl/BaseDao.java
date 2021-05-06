package com.pp.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import javax.management.Query;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public abstract class BaseDao {
    private static String driver;
    private static String  url ;
    private static String sql_user;
    private static String sql_pwd ;

    static {
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        sql_user=properties.getProperty("username");
        sql_pwd=properties.getProperty("password");
    }


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, sql_user, sql_pwd);
        return connection;
    }

    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        preparedStatement=connection.prepareStatement(sql);

        for (int i=0;i<params.length;++i){
            preparedStatement.setObject(i+1,params[i]);
        }

        resultSet=preparedStatement.executeQuery();

        return resultSet;
    }


    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        boolean flag=true;

        if(resultSet!=null){
            try {
                resultSet.close();
                resultSet=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }

        if(connection!=null){
            try {
                connection.close();
                connection=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }

        if(preparedStatement!=null){
            try {
                preparedStatement.close();
                preparedStatement=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag=false;
            }
        }

        return flag;
    }
}
