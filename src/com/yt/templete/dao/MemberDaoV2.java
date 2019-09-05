package com.yt.templete.dao;

import com.yt.templete.JDBCTempleteV1;
import com.yt.templete.JDBCTempleteV2;
import com.yt.templete.RowMapper;
import com.yt.templete.entry.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *  模版模式进化版SpringJDBC实现
 */
public class MemberDaoV2 {

    //这块不继承 是为了解耦
    private JDBCTempleteV2 jdbcTempleteV2 = new JDBCTempleteV2(null);

    public List<?> query(){
        String sql = "select * from user where t_member";
        List<?> result = jdbcTempleteV2.excuteQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                String userName = resultSet.getString("userName");
                String passWord = resultSet.getString("passWord");
                int age = resultSet.getInt("age");
                Member member = new Member();
                member.setUserName(userName);
                member.setPassWord(passWord);
                member.setAge(age);
                return member;
            }
        }, null);
        return result;
    }
}
