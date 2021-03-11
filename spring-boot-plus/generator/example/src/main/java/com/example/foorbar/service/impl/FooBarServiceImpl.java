package com.example.foorbar.service.impl;

import com.example.foorbar.entity.FooBar;
import com.example.foorbar.mapper.FooBarMapper;
import com.example.foorbar.service.FooBarService;
import com.example.foorbar.param.FooBarPageParam;
import com.example.foorbar.vo.FooBarQueryVo;
import io.geekidea.springbootplus.framework.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.pagination.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FooBar 服务实现类
 *
 * @author geekidea
 * @since 2021-03-11
 */
@Slf4j
@Service
public class FooBarServiceImpl extends BaseServiceImpl<FooBarMapper, FooBar> implements FooBarService {

    @Autowired
    private FooBarMapper fooBarMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveFooBar(FooBar fooBar) throws Exception {
        return super.save(fooBar);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateFooBar(FooBar fooBar) throws Exception {
        return super.updateById(fooBar);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteFooBar(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public FooBarQueryVo getFooBarById(Serializable id) throws Exception {
    return fooBarMapper.getFooBarById(id);
    }

    @Override
    public Paging<FooBarQueryVo> getFooBarPageList(FooBarPageParam fooBarPageParam) throws Exception {
        Page<FooBarQueryVo> page = new PageInfo<>(fooBarPageParam, OrderItem.desc(getLambdaColumn(FooBar::getCreateTime)));
        IPage<FooBarQueryVo> iPage = fooBarMapper.getFooBarPageList(page, fooBarPageParam);
        return new Paging<FooBarQueryVo>(iPage);
    }

}
