package com.hew.demotest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hew.demotest.model.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 31695
* @description 针对表【dept(部门表)】的数据库操作Mapper
* @createDate 2024-04-29 11:27:01
* @Entity com.hew.demotest.model.entity.Dept
*/

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}




