package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.entity.jc.JcJsqx;
import com.eaglesoft.zjhz.entity.jc.JcYhqx;
import com.eaglesoft.zjhz.entity.jc.MhCdgl;
import com.eaglesoft.zjhz.entity.vo.MhCdaglTree;
import com.eaglesoft.zjhz.service.jc.IJcJsqxService;
import com.eaglesoft.zjhz.service.jc.IJcYhqxService;
import com.eaglesoft.zjhz.service.jc.IMhCdglService;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eaglesoft.zjhz.web.base.BaseController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 门户-菜单管理 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-02
 */
@RestController
@RequestMapping("/rest/mhCdgl")
@Api("权限管理")
public class MhCdglManageController extends BaseController {

    @Autowired
    IMhCdglService iMhCdglService;
    @Autowired
    IJcJsqxService iJcJsqxService;
    @Autowired
    IJcYhqxService iJcYhqxService;

    @ApiOperation(value = "")
    @ResponseBody
    @PostMapping("/select")
    @IgnoreAuth
    public Result select(@RequestParam Integer dwbh) {

        QueryWrapper<MhCdgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(MhCdgl::getDwbh, dwbh);
        List<MhCdgl> mhCdgls = iMhCdglService.list(queryWrapper);
        List<MhCdaglTree> mhCdglTrees = new ArrayList<>();
        for (MhCdgl mhCdgl : mhCdgls) {
            if (mhCdgl.getSjcd() == -1) {
                MhCdaglTree mhCdaglTree = new MhCdaglTree();
                mhCdaglTree.setBh(mhCdgl.getBh());
                mhCdaglTree.setCdmc(mhCdgl.getCdmc());
                mhCdaglTree.setLjdz(mhCdgl.getLjdz());
                mhCdaglTree.setTbtp(mhCdgl.getTbtp());
                mhCdaglTree.setWzh(mhCdgl.getWzh());

                QueryWrapper<JcJsqx> queryWrapper1 = new QueryWrapper();
                queryWrapper1.lambda().eq(JcJsqx::getQxbh, mhCdgl.getBh());
                List<Integer> jslist = iJcJsqxService.list(queryWrapper1).stream().map(JcJsqx::getJsbh).collect(Collectors.toList());
                mhCdaglTree.setJslist(jslist);

                QueryWrapper<JcYhqx> queryWrapper2 = new QueryWrapper();
                queryWrapper2.lambda().eq(JcYhqx::getQxbh, mhCdgl.getBh());
                List<Integer> yhlist = iJcYhqxService.list(queryWrapper2).stream().map(JcYhqx::getYhbh).collect(Collectors.toList());
                mhCdaglTree.setYhlist(yhlist);

                mhCdaglTree.setChildren(iMhCdglService.findChild(mhCdgl.getBh()));
                mhCdglTrees.add(mhCdaglTree);
            }
        }
        return Result.success(mhCdglTrees);
    }

}

