package com.yt.templete.dao;

import com.yt.templete.JDBCTempleteV1;
import com.yt.templete.entry.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDaoV1 extends JDBCTempleteV1 {

    public MemberDaoV1(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> query(){
        String sql = "select * from user where t_member";
        return  super.excuteQuery(sql, null);
    }

    @Override
    public Object getResultSet(ResultSet resultSet, int rowNum) throws SQLException {
        String userName = resultSet.getString("userName");
        String passWord = resultSet.getString("passWord");
        int age = resultSet.getInt("age");
        Member member = new Member();
        member.setUserName(userName);
        member.setPassWord(passWord);
        member.setAge(age);
        return member;
    }
}
