package com.aorez.aop;

public class Target implements TargetInterface {
    @Override
    public void save() {
        //测试异常后的通知增强
//        int ii = 1/0;

        System.out.println("Target save");
    }
}
