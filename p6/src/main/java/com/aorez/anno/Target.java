package com.aorez.anno;

import org.springframework.stereotype.Component;

//注解配置目标对象bean
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        //测试异常后的通知增强
//        int ii = 1/0;

        System.out.println("Target save");
    }
}
