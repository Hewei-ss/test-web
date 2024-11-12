package com.hew.demotest.controller;


import com.hew.demotest.model.dto.AddEmpRequest;
import com.hew.demotest.model.dto.TestRequest;
import com.hew.demotest.model.entity.Emp;
import com.hew.demotest.service.EmpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class testController {

    @Resource
    private EmpService empService;

    int a=0;

    @GetMapping("/test")
    private String test() {
        return "ok";
    }


    @GetMapping("/test1")
    private String test1(@RequestParam(name = "name") String str, HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute("name", "hew");
        System.out.println(httpServletRequest.getQueryString());
        return httpServletRequest.getQueryString();
    }

    @PostMapping("/test2")
    private String test2(@RequestBody TestRequest testRequest, HttpServletRequest httpServletRequest) {
        String name = (String) httpServletRequest.getSession().getAttribute("name");
        System.out.println(httpServletRequest.getParameter("name") + " " + httpServletRequest.getParameter("age"));
        return httpServletRequest.getQueryString();
    }


    @GetMapping("/test3")
    private String test2(HttpServletRequest httpServletRequest) {
        String name = (String) httpServletRequest.getSession().getAttribute("name");
        return name;
    }
//
//    @RequestMapping("/test4")
//    public void test(@RequestParam(name = "threadId") int threadId){
//        while(true){
//            System.out.println("线程"+threadId+"打印"+a);
//            a++;
//        }
//    }

    @RequestMapping("/test5")
    public String test5(@RequestBody AddEmpRequest addEmpRequest){

        Emp emp=new Emp();
        emp.setName(addEmpRequest.getName());
        emp.setAge(addEmpRequest.getAge());
        return empService.addEmp(emp);
    }
}
