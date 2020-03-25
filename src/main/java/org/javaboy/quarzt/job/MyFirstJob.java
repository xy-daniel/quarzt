package org.javaboy.quarzt.job;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 第一种方式
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/25 21:31
 */
@Component
public class MyFirstJob {

    public void sayHello() {
        System.out.println("first job say hello>>>" + new Date());
    }

}
