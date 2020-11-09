package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.entity.jc.JcJsgl;
import com.eaglesoft.zjhz.entity.jc.JcYhgl;
import com.eaglesoft.zjhz.service.jc.IJcJsglService;
import com.eaglesoft.zjhz.service.jc.IJcYhglService;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eaglesoft.zjhz.web.base.BaseController;

/**
 * <p>
 * 角色管理 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/rest/JcJsglManage")
@Api(value = "角色管理")
public class JcJsglManageController extends BaseController {
    @Autowired
    IJcJsglService iJcJsglService;
    @Autowired
    IJcYhglService iJcYhglService;

    @ApiOperation(value = "")
    @IgnoreAuth
    @ResponseBody
    @PostMapping("/selectResultTree")
    public Result selectResultTree(@RequestParam Integer dwbh) {
        QueryWrapper<JcJsgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(JcJsgl::getDwbh, dwbh).select(JcJsgl::getBh, JcJsgl::getJsmc, JcJsgl::getWzh);
        return Result.success(iJcJsglService.list(queryWrapper));
    }

    @ApiOperation(value = "")
    @IgnoreAuth
    @ResponseBody
    @PostMapping("/save")
    public Result save(@RequestParam Integer dwbh) {
        QueryWrapper<JcJsgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(JcJsgl::getDwbh, dwbh).select(JcJsgl::getBh, JcJsgl::getJsmc, JcJsgl::getWzh);
        return Result.success(iJcJsglService.list(queryWrapper));
    }



    @ApiOperation(value = "")
    @IgnoreAuth
    @ResponseBody
    @PostMapping("/selectByBm")
    public Result selectByBm(@RequestParam Integer dwbh, @RequestParam Integer bh) {
        QueryWrapper<JcYhgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(JcYhgl::getBm,bh).eq(JcYhgl::getDwbh,dwbh);
        return Result.success(iJcYhglService.list(queryWrapper));
    }


}

