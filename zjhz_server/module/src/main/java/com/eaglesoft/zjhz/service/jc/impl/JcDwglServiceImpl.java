package com.eaglesoft.zjhz.service.jc.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.entity.jc.JcDwgl;
import com.eaglesoft.zjhz.dao.jc.JcDwglMapper;
import com.eaglesoft.zjhz.entity.vo.jcDwglChild;
import com.eaglesoft.zjhz.entity.vo.jcDwglTree;
import com.eaglesoft.zjhz.entity.vo.selectDwmc;
import com.eaglesoft.zjhz.entity.vo.selectZw;
import com.eaglesoft.zjhz.service.jc.IJcBmglService;
import com.eaglesoft.zjhz.service.jc.IJcDwglService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 设置所有使用OA系统的单位架构信息，如果是集团版一般会有多家单位 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@Service
public class JcDwglServiceImpl extends ServiceImpl<JcDwglMapper, JcDwgl> implements IJcDwglService {
//    @Autowired
//    JcDwglMapper jcDwglMapper;

    @Autowired
    IJcBmglService iJcBmglService;

    /**
    *
    *@Author suntl
    *@Date 2020/11/9 13:58
    */
//    @Override
//    public JSONArray find(Integer dwbh){
//        List<JcDwgl> dw;
//        JSONObject jsonData=new JSONObject();
//        jsonData.put("bh",0);
//        if(dwbh!=0){
//            jsonData.put("dwbh",dwbh);
//            dw=
//        }
//    }

    @Override
    public List<selectDwmc> selectDwforsql(selectDwmc dw) {
        return baseMapper.selectDwForSql(dw);
    }

    @Override
    public List<selectZw> selectZwByDwId(Integer bh) {
        return baseMapper.selectZwByDwId(bh);
    }

    @Override
    public List<jcDwglTree> findChildren(Integer jcdwBh) {
        QueryWrapper<JcDwgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(JcDwgl::getSjdw, jcdwBh);
        List<jcDwglTree> jcDwglChildTrees = new ArrayList<>();
        List<JcDwgl> jcdwglChilds = baseMapper.selectList(queryWrapper);
        for (JcDwgl jcdwChild : jcdwglChilds) {
            jcDwglTree jcDwglChildTree = new jcDwglTree();
            jcDwglChildTree.setWzh(jcdwChild.getWzh());
            jcDwglChildTree.setSjdw(jcdwChild.getSjdw());
            jcDwglChildTree.setRgt(jcdwChild.getRgt());
            jcDwglChildTree.setLft(jcdwChild.getLft());
            jcDwglChildTree.setDwmc(jcdwChild.getDwmc());
            jcDwglChildTree.setDwbh(jcdwChild.getBh());
            jcDwglChildTree.setDwChild(findChildren(jcdwChild.getBh()));
            jcDwglChildTree.setBmChild(iJcBmglService.getJcBmglTrees(jcdwChild.getBh()));
            jcDwglChildTrees.add(jcDwglChildTree);
        }
        return jcDwglChildTrees;
    }

    @Override
    public List<jcDwglChild> getJcDwglTrees(Integer jcdwbh){
        QueryWrapper<JcDwgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(JcDwgl::getSjdw, jcdwbh);
        List<jcDwglChild> jcDwglChildTrees = new ArrayList<>();
        List<JcDwgl> jcdwglChilds = baseMapper.selectList(queryWrapper);
        for (JcDwgl jcdwChild : jcdwglChilds) {
            jcDwglChild jcDwglChildTree = new jcDwglChild();
            jcDwglChildTree.setWzh(jcdwChild.getWzh());
            jcDwglChildTree.setSjdw(jcdwChild.getSjdw());
            jcDwglChildTree.setRgt(jcdwChild.getRgt());
            jcDwglChildTree.setLft(jcdwChild.getLft());
            jcDwglChildTree.setDwmc(jcdwChild.getDwmc());
            jcDwglChildTree.setDwbh(jcdwChild.getBh());
            jcDwglChildTree.setChildren(getJcDwglTrees(jcdwChild.getBh()));
            jcDwglChildTrees.add(jcDwglChildTree);
        }
        return jcDwglChildTrees;

    }
}
