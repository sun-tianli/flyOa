package com.eaglesoft.zjhz.service.jc.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eaglesoft.zjhz.common.utils.SortUtil;
import com.eaglesoft.zjhz.entity.jc.XtCzrz;
import com.eaglesoft.zjhz.dao.jc.XtCzrzMapper;
import com.eaglesoft.zjhz.entity.vo.XtCzrzPage;
import com.eaglesoft.zjhz.service.jc.IXtCzrzService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-03
 */
@Service
public class XtCzrzServiceImpl extends ServiceImpl<XtCzrzMapper, XtCzrz> implements IXtCzrzService {

       @Override
        public IPage<XtCzrz> selectPage(XtCzrzPage xtCzrzPage){
           Page<XtCzrz> page=new Page<>();
           //给page赋值
           SortUtil.handlePageSort(xtCzrzPage,page,"bh","asc",false);
           QueryWrapper<XtCzrz> queryWrapper=new QueryWrapper<>();
           queryWrapper.lambda().eq(XtCzrz::getDwbh,xtCzrzPage.getQuery());
            return baseMapper.selectPage(page,queryWrapper);
       }
}
