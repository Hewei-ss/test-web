package com.hew.demotest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hew.demotest.model.entity.Emp;

/**
* @author 31695
* @description 针对表【test】的数据库操作Service
* @createDate 2024-04-28 21:01:05
*/
public interface EmpService extends IService<Emp> {
    public String addEmp(Emp emp);

}
