package com.eaglesoft.zjhz.dao.jc;

import com.alibaba.fastjson.JSONArray;
import com.eaglesoft.zjhz.common.annotation.MyBatisDao;
import com.eaglesoft.zjhz.entity.jc.JcDwgl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eaglesoft.zjhz.entity.vo.JcDwglChildren;
import com.eaglesoft.zjhz.entity.vo.selectDwmc;
import com.eaglesoft.zjhz.entity.vo.selectZw;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 设置所有使用OA系统的单位架构信息，如果是集团版一般会有多家单位 Mapper 接口
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@MyBatisDao
public interface JcDwglMapper extends BaseMapper<JcDwgl> {
    List<selectDwmc> selectDwForSql(@Param("dw") selectDwmc dw);


    List<selectZw> selectZwByDwId(@Param("bh") Integer bh);

    JSONArray find(Integer dwbh);
}
