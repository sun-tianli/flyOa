package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.entity.jc.XtCzrz;
import com.eaglesoft.zjhz.entity.vo.XtCzrzPage;
import com.eaglesoft.zjhz.service.jc.IXtCzrzService;
import com.eaglesoft.zjhz.service.jc.impl.XtCzrzServiceImpl;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eaglesoft.zjhz.web.base.BaseController;

/**
 * <p>
 * 操作日志表 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-03
 */
@RestController
@RequestMapping("/rest/XtCzrzManage")
@Api("日志管理")
public class XtCzrzController extends BaseController {

    @Autowired
    IXtCzrzService iXtCzrzService;


    @ApiOperation(value="")
    @ResponseBody
    @PostMapping("/select")
    @IgnoreAuth
    public Result<IPage<XtCzrz>> select(@RequestBody XtCzrzPage xtCzrzPage){
        return getDataTable(iXtCzrzService.selectPage(xtCzrzPage));


    }


}

