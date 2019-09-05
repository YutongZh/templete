package com.yt.templete.simple;

/**
 * 模版类
 */
public abstract class Game {

    abstract String init();

    abstract String start();

    abstract String end();

    //模版
    public final void play(){
        init();
        start();
        end();
    }
}
