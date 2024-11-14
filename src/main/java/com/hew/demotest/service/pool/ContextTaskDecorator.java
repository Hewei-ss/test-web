//package com.hew.demotest.service.pool;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.task.TaskDecorator;
//
//@Slf4j
//public class ContextTaskDecorator implements TaskDecorator {
//    @Override
//    public Runnable decorate(Runnable runnable) {
//        //这里可以使用 ThreadLocal 进行参数传递
//        return ()->{
//            try{
//                runnable.run();
//            }catch (Exception e){
//                log.error("ContextTaskDecorator run error",e);
//            }
//        };
//    }
//}
