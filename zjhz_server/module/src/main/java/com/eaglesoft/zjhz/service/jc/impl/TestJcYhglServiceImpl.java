package com.eaglesoft.zjhz.service.jc.impl;

import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhAddRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eaglesoft.zjhz.common.constant.BaseConstant;
import com.eaglesoft.zjhz.common.utils.SortUtil;
import com.eaglesoft.zjhz.entity.jc.testJcYhgl;
import com.eaglesoft.zjhz.dao.jc.TestJcYhglMapper;
import com.eaglesoft.zjhz.service.jc.testIJcYhglService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eaglesoft.zjhz.vo.common.Result;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcYhPageResult;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhPageRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2019-12-17
 */
@Service
public class TestJcYhglServiceImpl extends ServiceImpl<TestJcYhglMapper, testJcYhgl> implements testIJcYhglService {

    @Override
    public List<testJcYhgl> selectAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public testJcYhgl selectByUsername(String username) {
        QueryWrapper<testJcYhgl> queryWrapper = new QueryWrapper();
        queryWrapper.lambda().eq(testJcYhgl::getZh, username);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<testJcYhgl> selectPage(JcyhPageRequest query) {
        Page<testJcYhgl> page = new Page<>();
        SortUtil.handlePageSort(query, page, "bh", BaseConstant.ORDER_ASC, false);
        QueryWrapper<testJcYhgl> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(query.getQuery())) {
            queryWrapper.lambda().like(testJcYhgl::getZh, query.getQuery());
        }
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public IPage<JcYhPageResult> selectPageForSql(JcyhPageRequest query) {
        Page<testJcYhgl> page = new Page<>();
        SortUtil.handlePageSort(query, page, "bh", BaseConstant.ORDER_ASC, false);
        return baseMapper.selectPageForSql(page, query.getQuery());
    }

    @Override
    public Result addUser(testJcYhgl yhgl) {
//        int flag = baseMapper.insert(yhgl);
//        return Result.actionResult(flag > 0, Result.ACTION_ADD, yhgl.getBh());
        return Result.actionResult(save(yhgl), Result.ACTION_ADD, yhgl.getBh());
    }

    @Override
    public Result addUserForSql(JcyhAddRequest addReq) {
        int falg = baseMapper.insertForSql(addReq);
        return Result.actionResult(falg > 0, Result.ACTION_ADD, addReq.getBh());
    }





}
