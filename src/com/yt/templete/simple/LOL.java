package com.yt.templete.simple;

public class LOL extends Game {
    @Override
    String init() {
        System.out.println("初始化LOL");
        return null;
    }

    @Override
    String start() {
        System.out.println("开始LOL");
        return null;
    }

    @Override
    String end() {
        System.out.println("结束LOL");
        return null;
    }
}
