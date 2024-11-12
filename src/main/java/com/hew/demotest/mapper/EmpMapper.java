package com.hew.demotest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hew.demotest.model.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 31695
 * @description 针对表【test】的数据库操作Mapper
 * @createDate 2024-04-28 21:01:05
 * @Entity com.hew.demotest.model.entity.Test
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    Emp testTowParams(@Param("name") String name,@Param("age") int age);

    List<Map<String, Object>> testOneParam(@Param("name") String name);

    /**
     * 关联查询
     *
     * @param id
     * @return
     */
    Emp testGuanlian(@Param("id") int id);

    int deleteMoreByArray(@Param("eids") Integer[] eids);
}




