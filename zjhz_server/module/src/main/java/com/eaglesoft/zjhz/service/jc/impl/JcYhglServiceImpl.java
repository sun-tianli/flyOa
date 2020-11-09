package com.eaglesoft.zjhz.service.jc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eaglesoft.zjhz.common.constant.BaseConstant;
import com.eaglesoft.zjhz.common.utils.SortUtil;
import com.eaglesoft.zjhz.entity.jc.JcYhgl;
import com.eaglesoft.zjhz.dao.jc.JcYhglMapper;
import com.eaglesoft.zjhz.entity.vo.YhglPage;
import com.eaglesoft.zjhz.service.jc.IJcYhglService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-23
 */
@Service
public class JcYhglServiceImpl extends ServiceImpl<JcYhglMapper, JcYhgl> implements IJcYhglService {


//    @Override
//    public IPage<JcYhgl> selectPage(YhglPage pageRequest) {
//       Page<JcYhgl> page=new Page<>();
//       //给page赋值
//        SortUtil.handlePageSort(pageRequest,page,"bh", BaseConstant.ORDER_ASC,false);
//
//        return baseMapper.selectPage(page,pageRequest.getQuery());
//
//    }

    @Override
    public IPage<JcYhgl> selectPage(YhglPage pageRequest) {
       Page<JcYhgl> page=new Page<>();
       //给page赋值
        SortUtil.handlePageSort(pageRequest,page,"bh", BaseConstant.ORDER_ASC,false);
        QueryWrapper<JcYhgl> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(JcYhgl::getDwbh, pageRequest.getQuery());

        return baseMapper.selectPage(page,queryWrapper);

    }



}
