package com.example.foorbar.controller;

import com.example.foorbar.entity.FooBar;
import com.example.foorbar.service.FooBarService;
import lombok.extern.slf4j.Slf4j;
import com.example.foorbar.param.FooBarPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import com.example.foorbar.vo.FooBarQueryVo;
import io.geekidea.springbootplus.framework.common.api.ApiResult;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.common.param.IdParam;
import io.geekidea.springbootplus.framework.log.annotation.Module;
import io.geekidea.springbootplus.framework.log.annotation.OperationLog;
import io.geekidea.springbootplus.framework.log.enums.OperationLogType;
import io.geekidea.springbootplus.framework.core.validator.groups.Add;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import org.springframework.validation.annotation.Validated;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * FooBar 控制器
 *
 * @author geekidea
 * @since 2021-03-11
 */
@Slf4j
@RestController
@RequestMapping("/fooBar")
@Module("foorbar")
@Api(value = "FooBarAPI", tags = {"FooBar"})
public class FooBarController extends BaseController {

    @Autowired
    private FooBarService fooBarService;

    /**
     * 添加FooBar
     */
    @PostMapping("/add")
    @RequiresPermissions("foo:bar:add")
    @OperationLog(name = "添加FooBar", type = OperationLogType.ADD)
    @ApiOperation(value = "添加FooBar", response = ApiResult.class)
    public ApiResult<Boolean> addFooBar(@Validated(Add.class) @RequestBody FooBar fooBar) throws Exception {
        boolean flag = fooBarService.saveFooBar(fooBar);
        return ApiResult.result(flag);
    }

    /**
     * 修改FooBar
     */
    @PostMapping("/update")
    @RequiresPermissions("foo:bar:update")
    @OperationLog(name = "修改FooBar", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改FooBar", response = ApiResult.class)
    public ApiResult<Boolean> updateFooBar(@Validated(Update.class) @RequestBody FooBar fooBar) throws Exception {
        boolean flag = fooBarService.updateFooBar(fooBar);
        return ApiResult.result(flag);
    }

    /**
     * 删除FooBar
     */
    @PostMapping("/delete/{id}")
    @RequiresPermissions("foo:bar:delete")
    @OperationLog(name = "删除FooBar", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除FooBar", response = ApiResult.class)
    public ApiResult<Boolean> deleteFooBar(@PathVariable("id") Long id) throws Exception {
        boolean flag = fooBarService.deleteFooBar(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取FooBar详情
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("foo:bar:info")
    @OperationLog(name = "FooBar详情", type = OperationLogType.INFO)
    @ApiOperation(value = "FooBar详情", response = FooBarQueryVo.class)
    public ApiResult<FooBarQueryVo> getFooBar(@PathVariable("id") Long id) throws Exception {
        FooBarQueryVo fooBarQueryVo = fooBarService.getFooBarById(id);
        return ApiResult.ok(fooBarQueryVo);
    }

    /**
     * FooBar分页列表
     */
    @PostMapping("/getPageList")
    @RequiresPermissions("foo:bar:page")
    @OperationLog(name = "FooBar分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "FooBar分页列表", response = FooBarQueryVo.class)
    public ApiResult<Paging<FooBarQueryVo>> getFooBarPageList(@Validated @RequestBody FooBarPageParam fooBarPageParam) throws Exception {
        Paging<FooBarQueryVo> paging = fooBarService.getFooBarPageList(fooBarPageParam);
        return ApiResult.ok(paging);
    }

}

