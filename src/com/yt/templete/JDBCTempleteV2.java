package com.yt.templete;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 升级版模版类（SpringJDBC）
 */
public class JDBCTempleteV2 {

    private DataSource dataSource;

    public JDBCTempleteV2(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<?> excuteQuery(String sql, RowMapper<?> rowMapper, Object[] values){

        try {
            //创建连接
            Connection connection = this.getConnection();
            //创建语句集
            PreparedStatement preparedStatement = this.getPreparedStatement(sql, connection);
            //执行语句集
            ResultSet resultSet = this.excuteSelect(preparedStatement);
            //解析语句集
            List<?> resultList = parseResultSet(resultSet, rowMapper);
            //关闭结果集
            closeResultSet(resultSet);
            //关闭语句集
            closeStatement(preparedStatement);
            //关闭连接
            closeConnection(connection);
            return resultList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<?> parseResultSet(ResultSet resultSet, RowMapper rowMapper) throws SQLException {
        List resultList = new ArrayList();
        int rowNum = 1;
        while (resultSet.next()){
            resultList.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return resultList;
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    private void closeStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    private void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

    private ResultSet excuteSelect(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }

    private PreparedStatement getPreparedStatement(String sql, Connection connection) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //public abstract Object getResultSet(ResultSet resultSet, int rowNum) throws SQLException;

}
