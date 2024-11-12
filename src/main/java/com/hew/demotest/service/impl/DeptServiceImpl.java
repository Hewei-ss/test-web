package com.hew.demotest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hew.demotest.service.DeptService;
import com.hew.demotest.model.entity.Dept;
import com.hew.demotest.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author 31695
* @description 针对表【dept(部门表)】的数据库操作Service实现
* @createDate 2024-04-29 11:27:01
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService {

}




