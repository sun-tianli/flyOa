package com.eaglesoft.zjhz.service.jc.impl;

import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.entity.jc.JcZwgl;
import com.eaglesoft.zjhz.dao.jc.JcZwglMapper;
import com.eaglesoft.zjhz.entity.vo.jcZwglRequest;
import com.eaglesoft.zjhz.service.jc.IJcZwglService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eaglesoft.zjhz.vo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 职务管理 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
@Service
public class JcZwglServiceImpl extends ServiceImpl<JcZwglMapper, JcZwgl> implements IJcZwglService {
@Override
    public int insertForSql(JcZwgl jcZwgl){
       return baseMapper.insertForSql(jcZwgl);
}


}
