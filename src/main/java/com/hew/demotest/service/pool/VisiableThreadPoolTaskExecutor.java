package com.hew.demotest.service.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class VisiableThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    public VisiableThreadPoolTaskExecutor() {
        setTaskDecorator(new ContextTaskDecorator());
    }
    private void showThreadPoolInfo(String prefix){
        ThreadPoolExecutor threadPoolExecutor = getThreadPoolExecutor();
        log.debug( "{}, {},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                this.getThreadNamePrefix(), prefix, threadPoolExecutor.getTaskCount(),
                threadPoolExecutor.getCompletedTaskCount(), threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getQueue().size());
    }

    @Override
    public void execute(Runnable task) {
        showThreadPoolInfo("async execute Runnable");
        super.execute(task);
    }

    @Override
    public Future<?> submit(Runnable task) {
        showThreadPoolInfo("async submit Runnable");
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        showThreadPoolInfo("async submit callable");
        return super.submit(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(Runnable task) {
        showThreadPoolInfo("async submitListenable Runnable");
        return super.submitListenable(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        showThreadPoolInfo("async submitListenable Callable");
        return super.submitListenable(task);
    }

    @Override
    protected void cancelRemainingTask(Runnable task) {
        showThreadPoolInfo("async submitListenable Runnable");
        super.cancelRemainingTask(task);
    }
}
