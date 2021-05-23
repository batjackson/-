package com.pp.dao.impl;

import com.pp.pojo.Im;
import com.pp.pojo.Price;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ImDao {
    public List<Im> getIm(Connection connection, Integer id) throws SQLException;
}
