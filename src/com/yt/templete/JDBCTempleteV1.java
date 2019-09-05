package com.yt.templete;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 模版类
 */
public abstract class JDBCTempleteV1 {

    private DataSource dataSource;

    public JDBCTempleteV1(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public final List<?> excuteQuery(String sql, Object[] values){

        try {
            //创建连接
            Connection connection = dataSource.getConnection();
            //创建语句集
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //执行语句集
            ResultSet resultSet = preparedStatement.executeQuery();
            //解析语句集
            List resultList = new ArrayList();
            int rowNum = 1;
            while (resultSet.next()){
                resultList.add(getResultSet(resultSet, rowNum ++));
            }
            //关闭结果集
            resultSet.close();
            //关闭语句集
            preparedStatement.close();
            //关闭连接
            connection.close();
            return resultList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public abstract Object getResultSet(ResultSet resultSet, int rowNum) throws SQLException;

}
