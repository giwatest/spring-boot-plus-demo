package com.example.foorbar.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.foorbar.entity.FooBar;
import com.example.foorbar.param.FooBarPageParam;
import com.example.foorbar.vo.FooBarQueryVo;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * FooBar Mapper 接口
 *
 * @author geekidea
 * @since 2021-03-11
 */
@Repository
public interface FooBarMapper extends BaseMapper<FooBar> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    FooBarQueryVo getFooBarById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param fooBarQueryParam
     * @return
     */
    IPage<FooBarQueryVo> getFooBarPageList(@Param("page") Page page, @Param("param") FooBarPageParam fooBarPageParam);

}
