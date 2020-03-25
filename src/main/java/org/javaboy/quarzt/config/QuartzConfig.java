package org.javaboy.quarzt.config;

import org.javaboy.quarzt.job.MySecondJob;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;
import java.util.Objects;

/**
 * 配置文件
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/25 21:41
 */
@Configuration
public class QuartzConfig {

    //----定时任务需要干什么

    /**
     * 第一种配置方式---->需要指定方法名称
     */
    @Bean
    MethodInvokingJobDetailFactoryBean factoryBean(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myFirstJob");
        bean.setTargetMethod("sayHello");
        return bean;
    }

    /**
     * 第二种配置方式---->根据规则不需要配置方法名称，固定的方法名称
     */
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        JobDataMap map = new JobDataMap();
        map.put("name", "javaboy");
        bean.setJobDataMap(map);
        bean.setJobClass(MySecondJob.class);
        return bean;
    }

    //----定时任务什么时候触发

    /**
     * 最简单的触发器
     */
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(Objects.requireNonNull(factoryBean().getObject()));
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.setRepeatInterval(2000);
        simpleTriggerFactoryBean.setRepeatCount(3);
        return simpleTriggerFactoryBean;
    }

    /**
     * 最灵活的定时器
     */
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(Objects.requireNonNull(jobDetailFactoryBean().getObject()));
        cronTriggerFactoryBean.setCronExpression("* * * * * ?");
        return cronTriggerFactoryBean;
    }

    //----启动定时任务


    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
        return bean;
    }

}
