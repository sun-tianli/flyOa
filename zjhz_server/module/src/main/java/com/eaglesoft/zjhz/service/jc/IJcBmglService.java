package com.eaglesoft.zjhz.service.jc;

import com.eaglesoft.zjhz.entity.jc.JcBmgl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.entity.vo.jcBmglTree;

import java.util.List;

/**
 * <p>
 * 部门管理 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
public interface IJcBmglService extends IService<JcBmgl> {
    List<JcBmgl> selectChildren(Integer lft, Integer rgt);

    List<JcBmgl> selectChildById(Integer bh);

//    List<JcBmgl> selectXsbmBySjbm(Integer bh);

    List<jcBmglTree> findChildren(Integer jcbmBh);

    List<jcBmglTree> getJcBmglTrees(Integer jcdwbh);
}
