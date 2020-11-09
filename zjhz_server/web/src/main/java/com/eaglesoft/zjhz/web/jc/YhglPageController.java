package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eaglesoft.zjhz.entity.jc.JcYhgl;
import com.eaglesoft.zjhz.entity.vo.YhglPage;
import com.eaglesoft.zjhz.service.jc.IJcYhglService;
import com.eaglesoft.zjhz.vo.common.Result;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhPageRequest;
import com.eaglesoft.zjhz.web.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/YhglPage")
@Api("用户管理")
public class YhglPageController extends BaseController {
    @Autowired
    IJcYhglService iJcYhglService;


    @ApiOperation(value = "查询分页方式，自定义sql")
    @ResponseBody
    @PostMapping("/selectPage")
    public Result<IPage<JcYhgl>> selectPage(@RequestBody YhglPage pageRequest) {
        return getDataTable(iJcYhglService.selectPage(pageRequest));
    }

    @ApiOperation(value = "获取用户信息")
    @ResponseBody
    @PostMapping("/getYhxx")
    public Result getYhxx(@RequestParam Integer bh) {
        QueryWrapper<JcYhgl> queryWrapper=new QueryWrapper();
        queryWrapper.lambda().eq(JcYhgl::getBh,bh);
        return Result.success(iJcYhglService.list(queryWrapper));
    }




}
