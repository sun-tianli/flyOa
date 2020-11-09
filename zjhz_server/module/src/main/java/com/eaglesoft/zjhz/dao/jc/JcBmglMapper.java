package com.eaglesoft.zjhz.dao.jc;

import com.eaglesoft.zjhz.common.annotation.MyBatisDao;
import com.eaglesoft.zjhz.entity.jc.JcBmgl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 部门管理 Mapper 接口
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@MyBatisDao
public interface JcBmglMapper extends BaseMapper<JcBmgl> {
    List<JcBmgl> selectChildren(Integer lft,Integer rgt);
    List<JcBmgl> selectChildById(Integer bh);
}
