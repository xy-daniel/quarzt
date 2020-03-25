package org.javaboy.quarzt.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * 第二种方式
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/25 21:34
 */
public class MySecondJob extends QuartzJobBean {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("second job say hello>>>" + name + ":" + new Date());
    }
}
