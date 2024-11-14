package com.hew.demotest.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hew.demotest.mapper.EmpMapper;
import com.hew.demotest.model.entity.Emp;
import com.hew.demotest.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* @author 31695
* @description 针对表【test】的数据库操作Service实现
* @createDate 2024-04-28 21:01:05
*/
@Service
@Slf4j
public class EmpServiceImpl extends ServiceImpl<EmpMapper,Emp>
    implements EmpService {

    //通过ThreadPoolExecutor构造函数自定义参数创建

    private static final int CORE_POOL_SIZE = 2;
    private static final int MAX_POOL_SIZE = 2;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy());
    class Task implements Runnable{
        private Emp emp;
        Task(Emp emp){
            this.emp=emp;
        }
        @Override
        public void run() {
            log.debug( "taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                    executor.getTaskCount(),
                    executor.getCompletedTaskCount(), executor.getActiveCount(),
                    executor.getQueue().size());
            empMapper.insert(emp);
        }
    }

    @Resource
    public EmpMapper empMapper;
    ArrayList<Emp> list;

    @PostConstruct
    private void init() {
        list = new ArrayList<>();
        Emp emp = new Emp();
        emp.setAge(2);
        emp.setName("jlc");
        Emp emp1 = new Emp();
        emp1.setAge(3);
        emp1.setName("jlc");
        list.add(emp1);
        list.add(emp);
        log.info("init data :{}",list.size());
    }


    @PreDestroy

    public void SafeSave() {

        for(Emp t:list){
            empMapper.insert(t);
        }
        log.info("安全重启 :{}",list.size());


    }

//    @Resource
//    private AsyncTaskExecutor asyncTaskExecutor;
    public String addEmp(Emp emp){
      //  executor.execute(new Task(emp));
       return "ok";
    }
}




