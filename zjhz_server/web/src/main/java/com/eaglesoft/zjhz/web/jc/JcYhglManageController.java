package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.entity.jc.JcYhgl;
import com.eaglesoft.zjhz.entity.vo.YhXm;
import com.eaglesoft.zjhz.service.jc.IJcYhglService;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eaglesoft.zjhz.web.base.BaseController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-23
 */
@RestController
@RequestMapping("/rest/JcYhglManage")
@Api("用户排序")
public class JcYhglManageController extends BaseController {
    @Autowired
    IJcYhglService iJcYhglService;


    @ApiOperation(value = "")
    @ResponseBody
    @PostMapping("/selectTree")
    @IgnoreAuth
    public Result selectTree(@RequestParam Integer dwbh) {
        QueryWrapper<JcYhgl> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(JcYhgl::getWzh).eq(JcYhgl::getDwbh, dwbh).select(JcYhgl::getXm,JcYhgl::getBh,JcYhgl::getWzh);
        return Result.success(iJcYhglService.list(queryWrapper));
    }

    ;


    @ApiOperation(value = "用户排序")
    @ResponseBody
    @PostMapping("/userOrder")
    @IgnoreAuth
    public Result UserOrder(@RequestParam Integer dwbh) {
        QueryWrapper<JcYhgl> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(JcYhgl::getWzh).eq(JcYhgl::getDwbh, dwbh).select(JcYhgl::getXm);

//        Function<JcYhgl, String>function =new Function<JcYhgl, String>() {
//    @Override
//    public String apply(JcYhgl jcYhgl) {
//
//        return jcYhgl.getXm();
//    }
//};iJcYhglService.listObjs(queryWrapper,function);

        List<JcYhgl> jcYhgls = iJcYhglService.list(queryWrapper);
//        List<String> a=jcYhgls.toArray();


        List<String> xms = jcYhgls.stream().map(JcYhgl::getXm).collect(Collectors.toList());
        return Result.success(xms);
    }

}

