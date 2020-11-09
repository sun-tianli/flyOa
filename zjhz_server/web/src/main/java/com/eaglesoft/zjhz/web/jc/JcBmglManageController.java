package com.eaglesoft.zjhz.web.jc;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.entity.jc.JcBmgl;
import com.eaglesoft.zjhz.service.jc.IJcBmglService;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/JcBmglManage")
@Api("组织结构管理")
public class JcBmglManageController {
    @Autowired
    IJcBmglService iJcBmglService;


    @ApiOperation(value = "")
    @IgnoreAuth
    @ResponseBody
    @PostMapping("/findByparentId")
    public Result findByparentId(@RequestParam Integer dwbh) {
        QueryWrapper<JcBmgl> queryWrapper=new QueryWrapper();
        queryWrapper.lambda().eq(JcBmgl::getDwbh,dwbh);
        return Result.success(iJcBmglService.list(queryWrapper));
    }


    @ApiOperation(value = "")
    @ResponseBody
    @PostMapping("/selectadd")
    @IgnoreAuth
    public Result selectadd(@RequestParam Integer dwbh){
        return Result.success(iJcBmglService.getJcBmglTrees(dwbh));
    }



    @ApiOperation(value = "添加部门")
    @ResponseBody
    @PostMapping("/save")
    public Result addBm(@RequestBody JcBmgl jcBmgl) {
        return Result.actionResult(iJcBmglService.save(jcBmgl), Result.ACTION_ADD, jcBmgl);
    }


    @ApiOperation(value = "删除部门")
    @ResponseBody
    @PostMapping("/delete")
    @IgnoreAuth
    public Result delete(@RequestParam Integer bh) {
        return Result.actionResult(iJcBmglService.removeById(bh),Result.ACTION_DELETE,null);
    }


}
