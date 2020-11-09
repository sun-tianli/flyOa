package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.entity.jc.JcZwgl;
import com.eaglesoft.zjhz.entity.vo.jcZwglSaveRequest;
import com.eaglesoft.zjhz.entity.vo.selectDwmc;
import com.eaglesoft.zjhz.service.jc.IJcDwglService;
import com.eaglesoft.zjhz.service.jc.IJcZwglService;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eaglesoft.zjhz.web.base.BaseController;

/**
 * <p>
 * 设置所有使用OA系统的单位架构信息，如果是集团版一般会有多家单位 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@RestController
@RequestMapping("/rest/jcZwglManage")
@Api(value = "职务管理")
public class JcZwglManageController extends BaseController {
    @Autowired
    IJcDwglService jcDwglService;

    @Autowired
    IJcZwglService jcZwglService;


    @ApiOperation(value = "模糊查询单位名称")
    @ResponseBody
    @PostMapping("/selectDwforsql")
    @IgnoreAuth
    public Result selectDwforsql(@RequestBody selectDwmc dw) {
        return Result.success(jcDwglService.selectDwforsql(dw));
    }

    @ApiOperation(value = "根据bh部门编号查找zwmc所属职务名称")
    @ResponseBody
    @PostMapping("/selectZwByDwId")
    @IgnoreAuth
    public Result selectZwByDwId(@RequestParam Integer bh) {
        return Result.success(jcDwglService.selectZwByDwId(bh));
    }

    @ApiOperation(value = "删除职务")
    @ResponseBody
    @PostMapping("/delete")
    @IgnoreAuth
    public Result deleteZwByBh(@RequestParam Integer bh) {
//        return jcZwglService.delectZwByBh(bh);
        return Result.actionResult(jcZwglService.removeById(bh), Result.ACTION_DELETE, null);
    }

//    @ApiOperation(value = "修改职务")
//    @ResponseBody
//    @PostMapping("/updateZw")
//    public Result updateZw(@RequestBody JcZwgl zw) {
//        return Result.actionResult(jcZwglService.updateById(zw), Result.ACTION_UPDATE, zw);
//    }

    @ApiOperation(value = "")
    @ResponseBody
    @PostMapping("/save")
    @IgnoreAuth
    public Result addZw(@RequestBody jcZwglSaveRequest jcZwglSaveRequest) {

        if (jcZwglSaveRequest.getState().equals("new")) {
            return Result.actionResult(jcZwglService.save(jcZwglSaveRequest.getJcZwgl()), Result.ACTION_ADD, jcZwglSaveRequest.getJcZwgl());
        }
        if (jcZwglSaveRequest.getState().equals("edit")) {
            return Result.actionResult(jcZwglService.updateById(jcZwglSaveRequest.getJcZwgl()), Result.ACTION_UPDATE, jcZwglSaveRequest.getJcZwgl());
        } else {
            return Result.error();
        }

    }

    @ApiOperation(value = "职务list返回tree")
    @ResponseBody
    @PostMapping("/selectResultTree")
    @IgnoreAuth
    public Result selectResultTree(@RequestParam Integer dwbh) {
        QueryWrapper<JcZwgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(JcZwgl::getDwbh, dwbh);
        return Result.success(jcZwglService.list(queryWrapper));

    }


    @ApiOperation(value = "test,insert")
    @ResponseBody
    @PostMapping("/testInsert")
    @IgnoreAuth
    public int insertForSql(@RequestBody JcZwgl jcZwgl){
        return jcZwglService.insertForSql(jcZwgl);
    }




}

