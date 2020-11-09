package com.eaglesoft.zjhz.service.jc;

import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhAddRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eaglesoft.zjhz.entity.jc.testJcYhgl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.vo.common.Result;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcYhPageResult;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhPageRequest;

import java.util.List;

/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2019-12-17
 */
public interface testIJcYhglService extends IService<testJcYhgl> {
    /**
     * 查询所有用户
     *
     * @return
     */
    List<testJcYhgl> selectAll();

    /**
     * 登录，根据账户查询用户
     *
     * @param username
     * @return
     */
    testJcYhgl selectByUsername(String username);

    /**
     * 用户查询——分页
     *
     * @param query
     * @return
     */
    IPage<testJcYhgl> selectPage(JcyhPageRequest query);


    IPage<JcYhPageResult> selectPageForSql(JcyhPageRequest query);

    Result addUser(testJcYhgl yhgl);

    Result addUserForSql(JcyhAddRequest addReq);

}
