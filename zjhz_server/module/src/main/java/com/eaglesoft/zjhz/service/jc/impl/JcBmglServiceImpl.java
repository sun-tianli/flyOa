package com.eaglesoft.zjhz.service.jc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.entity.vo.jcBmglTree;
import com.eaglesoft.zjhz.service.jc.IJcBmglService;
import com.eaglesoft.zjhz.entity.jc.JcBmgl;
import com.eaglesoft.zjhz.dao.jc.JcBmglMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门管理 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@Service
public class JcBmglServiceImpl extends ServiceImpl<JcBmglMapper, JcBmgl> implements IJcBmglService {
    @Override
    public List<JcBmgl> selectChildren(Integer lft, Integer rgt) {
        return baseMapper.selectChildren(lft, rgt);
    }

    @Override
    public List<JcBmgl> selectChildById(Integer bh) {
        return baseMapper.selectChildById(bh);
    }

//    @Override
//    public List<JcBmgl> selectXsbmBySjbm(Integer bh) {
//        return
//    }

    @Override
    public List<jcBmglTree> findChildren(Integer jcbmBh) {
        QueryWrapper<JcBmgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(JcBmgl::getSjbm, jcbmBh);
        List<jcBmglTree> jcBmglChildTrees = new ArrayList<>();
        List<JcBmgl> jcbmglChilds = baseMapper.selectList(queryWrapper);
        for (JcBmgl jcbmChild : jcbmglChilds) {
            jcBmglTree jcBmglChildTree = new jcBmglTree();
            jcBmglChildTree.setWzh(jcbmChild.getWzh());
            jcBmglChildTree.setSjbm(jcbmChild.getSjbm());
            jcBmglChildTree.setRgt(jcbmChild.getRgt());
            jcBmglChildTree.setLft(jcbmChild.getLft());
            jcBmglChildTree.setDwbh(jcbmChild.getDwbh());
            jcBmglChildTree.setBmmc(jcbmChild.getBmmc());
            jcBmglChildTree.setBmbh(jcbmChild.getBh());
            jcBmglChildTree.setChild(findChildren(jcbmChild.getBh()));
            jcBmglChildTrees.add(jcBmglChildTree);
        }
        return jcBmglChildTrees;
    }

    @Override
    public List<jcBmglTree> getJcBmglTrees(Integer jcdwbh){
        List<jcBmglTree> jcBmglTrees = new ArrayList<>();
        List<JcBmgl> jcBmgls = selectChildById(jcdwbh);
        for (JcBmgl jcbm : jcBmgls) {
            if (jcbm.getSjbm() == 0) {
                jcBmglTree jcBmglTree = new jcBmglTree();
                jcBmglTree.setBmbh(jcbm.getBh());
                jcBmglTree.setBmmc(jcbm.getBmmc());
                jcBmglTree.setDwbh(jcbm.getDwbh());
                jcBmglTree.setLft(jcbm.getLft());
                jcBmglTree.setRgt(jcbm.getRgt());
                jcBmglTree.setSjbm(jcbm.getSjbm());
                jcBmglTree.setWzh(jcbm.getWzh());
                jcBmglTree.setChild(findChildren(jcbm.getBh()));
                jcBmglTrees.add(jcBmglTree);
            }
        }
        return jcBmglTrees;
    }


}
