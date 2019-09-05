package com.yt.templete;

import com.yt.templete.dao.MemberDaoV1;

public class JDBCTempleteTestV1 {

    public static void main(String[] args) {
        MemberDaoV1 memberDao = new MemberDaoV1(null);
        memberDao.query();
    }
}
