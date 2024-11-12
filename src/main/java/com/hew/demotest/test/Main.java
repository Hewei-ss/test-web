//package com.hew.demotest.test;
//
//import com.hew.demotest.model.Testentity;
//import com.hew.demotest.util.TestUtil;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
///**
// * wait()和notify()用法
// *   1. 要使用wait和notify, 必须首先对“对象”进行synchronized加锁。
// *   2. wait()过程中是不持有锁的
// */
//public class Main {
//
//
//
//    static void test1(){
//        test2(test3());
//    }
//    static void test2(String str){
//        System.out.println(str);
//    }
//    static String test3(){
//        return "test3";
//    }
//    public static void main(String[] args) throws InterruptedException {
//        test1();
//    }
//}
