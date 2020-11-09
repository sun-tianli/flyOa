package com.eaglesoft.zjhz.dao.jc;

import com.eaglesoft.zjhz.entity.jc.JcDwgl;
import com.eaglesoft.zjhz.entity.jc.JcZwgl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 职务管理 Mapper 接口
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
public interface JcZwglMapper extends BaseMapper<JcZwgl> {
   int insertForSql(JcZwgl jcZwgl);
    
}
