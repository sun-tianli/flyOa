package com.eaglesoft.zjhz.service.jc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.entity.jc.JcJsqx;
import com.eaglesoft.zjhz.entity.jc.JcYhqx;
import com.eaglesoft.zjhz.entity.jc.MhCdgl;
import com.eaglesoft.zjhz.dao.jc.MhCdglMapper;
import com.eaglesoft.zjhz.entity.vo.MhCdaglTree;
import com.eaglesoft.zjhz.service.jc.IJcJsqxService;
import com.eaglesoft.zjhz.service.jc.IJcYhqxService;
import com.eaglesoft.zjhz.service.jc.IMhCdglService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 门户-菜单管理 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-02
 */
@Service
public class MhCdglServiceImpl extends ServiceImpl<MhCdglMapper, MhCdgl> implements IMhCdglService {
    @Autowired
    IJcJsqxService iJcJsqxService;
    @Autowired
    IJcYhqxService iJcYhqxService;


    @Override
    public List<MhCdaglTree> findChild(@RequestParam Integer bh) {
        QueryWrapper<MhCdgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(MhCdgl::getSjcd, bh);
        List<MhCdgl> mhCdgls = list(queryWrapper);
        List<MhCdaglTree> mhCdaglTrees = new ArrayList<>();
        for (MhCdgl mhCdgl : mhCdgls) {
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

            mhCdaglTree.setChildren(findChild(mhCdgl.getBh()));
            mhCdaglTrees.add(mhCdaglTree);
        }
        return mhCdaglTrees;
    }


}
