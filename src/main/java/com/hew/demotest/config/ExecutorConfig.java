//package com.hew.demotest.config;
//
//import com.hew.demotest.service.pool.VisiableThreadPoolTaskExecutor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.AsyncTaskExecutor;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * 公共线程池，用于执行耗时异步任务
// */
//@Configuration
//@EnableAsync
//@Slf4j
//public class ExecutorConfig {
//
//    /**
//     * 核心线程数
//     */
//    @Value("${async.executor.thread.corePoolSize}")
//    private int corePoolSize;
//    /**
//     * 最大线程数量
//     */
//    @Value("${async.executor.thread.maxPoolSize}")
//    private int maxPoolSize;
//    /**
//     * 最大任务数量
//     */
//    @Value("${async.executor.thread.queueCapacity}")
//    private int queueCapacity;
//    /**
//     * 线程前缀
//     */
//    @Value("${async.executor.thread.keepAlive}")
//    private int keepAlive;
//    /**
//     * 线程前缀
//     */
//    @Value("${async.executor.thread.prefix}")
//    private String namePrefix;
//
//    @Bean
//    public AsyncTaskExecutor asyncTaskExecutor() {
//        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
//        // 核心线程池大小
//        executor.setCorePoolSize(corePoolSize);
//        // 最大线程数
//        executor.setMaxPoolSize(maxPoolSize);
//        // 队列容量
//        executor.setQueueCapacity(queueCapacity);
//        // 活跃时间
//        executor.setKeepAliveSeconds(keepAlive);
//        // 线程名字前缀
//        executor.setThreadNamePrefix(namePrefix);
//        //不在线程中执行，拒绝策略为调用者自己执行
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executor.initialize();
//        return executor;
//    }
//}
