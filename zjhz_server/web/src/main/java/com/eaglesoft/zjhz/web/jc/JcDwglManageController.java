package com.eaglesoft.zjhz.web.jc;


import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.common.page.QueryRequest;
import com.eaglesoft.zjhz.entity.jc.JcBmgl;
import com.eaglesoft.zjhz.entity.jc.JcDwgl;
import com.eaglesoft.zjhz.entity.vo.jcBmglTree;
import com.eaglesoft.zjhz.entity.vo.jcDwglChild;
import com.eaglesoft.zjhz.entity.vo.jcDwglTree;
import com.eaglesoft.zjhz.entity.vo.selectaddRequest;
import com.eaglesoft.zjhz.service.jc.IJcBmglService;
import com.eaglesoft.zjhz.service.jc.IJcDwglService;
import com.eaglesoft.zjhz.service.jc.impl.JcDwglServiceImpl;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eaglesoft.zjhz.web.base.BaseController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@RestController
@RequestMapping("/rest/JcDwglManage")
@Api("组织结构管理")
public class JcDwglManageController extends BaseController {
    @Autowired
    IJcBmglService iJcBmglService;

    @Autowired
    IJcDwglService jcDwglService;

    @ApiOperation(value = "单位树形列表（递归结构）")
    @ResponseBody
    @PostMapping("/findRSTree")
    @IgnoreAuth
//    public Result findRSTree(@RequestBody selectaddRequest selectaddRequest){
    public Result findRSTree() {
        List<jcDwglChild> jcDwglTrees = new ArrayList<>();
        List<JcDwgl> jcDwgls = jcDwglService.list();
        for (JcDwgl jcdw : jcDwgls) {
            if (jcdw.getSjdw() == 0) {
                jcDwglChild jcDwglTree = new jcDwglChild();
                jcDwglTree.setDwbh(jcdw.getBh());
                jcDwglTree.setDwmc(jcdw.getDwmc());
                jcDwglTree.setLft(jcdw.getLft());
                jcDwglTree.setRgt(jcdw.getRgt());
                jcDwglTree.setSjdw(jcdw.getSjdw());
                jcDwglTree.setWzh(jcdw.getWzh());
                jcDwglTree.setChildren(jcDwglService.getJcDwglTrees(jcdw.getBh()));
                jcDwglTrees.add(jcDwglTree);
            }
        }

        return Result.success(jcDwglTrees);
    }


    @ApiOperation("组织结构列表")
    @ResponseBody
    @PostMapping("/find")
    public Result<JSONArray> findChildren(@RequestParam Integer dwbh) {
        return Result.success(jcDwglService.find(dwbh));
    }


    @ApiOperation(value = "查询单位+职位树")
    @ResponseBody
    @PostMapping("/findTree")
    @IgnoreAuth
    public Result findTree() {

        List<jcDwglTree> jcDwglTrees = new ArrayList<>();
        List<JcDwgl> jcDwgls = jcDwglService.list();
        for (JcDwgl jcdw : jcDwgls) {
            if (jcdw.getSjdw() == 0) {
                jcDwglTree jcDwglTree = new jcDwglTree();
                jcDwglTree.setDwbh(jcdw.getBh());
                jcDwglTree.setDwmc(jcdw.getDwmc());
                jcDwglTree.setLft(jcdw.getLft());
                jcDwglTree.setRgt(jcdw.getRgt());
                jcDwglTree.setSjdw(jcdw.getSjdw());
                jcDwglTree.setWzh(jcdw.getWzh());

                jcDwglTree.setDwChild(jcDwglService.findChildren(jcdw.getBh()));


//                List<jcBmglTree> jcBmglTrees = new ArrayList<>();
//                List<JcBmgl> jcBmgls = iJcBmglService.selectChildById(jcdw.getBh());
//                for (JcBmgl jcbm : jcBmgls) {
//                    if (jcbm.getSjbm() == 0) {
//                        jcBmglTree jcBmglTree = new jcBmglTree();
//                        jcBmglTree.setBmbh(jcbm.getBh());
//                        jcBmglTree.setBmmc(jcbm.getBmmc());
//                        jcBmglTree.setDwbh(jcbm.getDwbh());
//                        jcBmglTree.setLft(jcbm.getLft());
//                        jcBmglTree.setRgt(jcbm.getRgt());
//                        jcBmglTree.setSjbm(jcbm.getSjbm());
//                        jcBmglTree.setWzh(jcbm.getWzh());
//                        jcBmglTree.setChild(iJcBmglService.findChildren(jcbm.getBh()));
//                        jcBmglTrees.add(jcBmglTree);
//                    }
//                }

//                jcDwglTree.setBmChild(jcBmglTrees);

                jcDwglTree.setBmChild(iJcBmglService.getJcBmglTrees(jcdw.getBh()));

                jcDwglTrees.add(jcDwglTree);


            }


        }
        return Result.success(jcDwglTrees);
    }


    @ApiOperation(value = "")
    @ResponseBody
    @PostMapping("/selectadd")
    @IgnoreAuth
    public Result selectadd(@RequestBody selectaddRequest selectaddRequest) {
//        QueryWrapper<JcBmgl> queryWrapper=new QueryWrapper();
//        queryWrapper.lambda().eq(JcBmgl::getSjbm,selectaddRequest.getSjbm());

        List<jcDwglChild> jcDwglTrees = new ArrayList<>();
        List<JcDwgl> jcDwgls = jcDwglService.list();
        for (JcDwgl jcdw : jcDwgls) {
            if (jcdw.getSjdw() == 0) {
                jcDwglChild jcDwglTree = new jcDwglChild();
                jcDwglTree.setDwbh(jcdw.getBh());
                jcDwglTree.setDwmc(jcdw.getDwmc());
                jcDwglTree.setLft(jcdw.getLft());
                jcDwglTree.setRgt(jcdw.getRgt());
                jcDwglTree.setSjdw(jcdw.getSjdw());
                jcDwglTree.setWzh(jcdw.getWzh());
                jcDwglTree.setChildren(jcDwglService.getJcDwglTrees(jcdw.getBh()));
                jcDwglTrees.add(jcDwglTree);
            }
        }

        return Result.success(jcDwglTrees);
    }


    @ApiOperation(value = "添加单位")
    @ResponseBody
    @PostMapping("/save")
    @IgnoreAuth
    public Result save(@RequestBody JcDwgl jcDwgl) {
        return Result.actionResult(jcDwglService.save(jcDwgl), Result.ACTION_ADD, jcDwgl);
    }

    @ApiOperation(value = "删除单位")
    @ResponseBody
    @PostMapping("/delete")
    @IgnoreAuth
    public Result addBm(@RequestParam Integer bh) {
        return Result.actionResult(jcDwglService.removeById(bh), Result.ACTION_DELETE, null);
    }
}

