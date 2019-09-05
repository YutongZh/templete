package com.yt.templete;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

    public T mapRow(ResultSet resultSet, int rowNum) throws SQLException;
}
