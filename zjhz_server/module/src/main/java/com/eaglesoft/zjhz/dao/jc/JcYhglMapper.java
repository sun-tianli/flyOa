package com.eaglesoft.zjhz.dao.jc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eaglesoft.zjhz.common.annotation.MyBatisDao;
import com.eaglesoft.zjhz.entity.jc.JcYhgl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eaglesoft.zjhz.entity.vo.YhglPage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-23
 */
@MyBatisDao
public interface JcYhglMapper extends BaseMapper<JcYhgl> {
//    IPage<JcYhgl> selectPage(Page page,@Param("dwbh") Integer dwbh);


}
