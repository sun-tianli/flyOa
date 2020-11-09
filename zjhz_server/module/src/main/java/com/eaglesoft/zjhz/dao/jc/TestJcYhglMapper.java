package com.eaglesoft.zjhz.dao.jc;

import com.eaglesoft.zjhz.common.annotation.MyBatisDao;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhAddRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eaglesoft.zjhz.entity.jc.testJcYhgl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcYhPageResult;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author eaglesoft
 * @since 2019-12-17
 */
@MyBatisDao
public interface TestJcYhglMapper extends BaseMapper<testJcYhgl> {
    IPage<JcYhPageResult> selectPageForSql(Page page, @Param("username") String username);

    int insertForSql(JcyhAddRequest req);

}
