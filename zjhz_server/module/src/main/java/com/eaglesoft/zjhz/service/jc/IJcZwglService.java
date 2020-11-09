package com.eaglesoft.zjhz.service.jc;

import com.eaglesoft.zjhz.entity.jc.JcZwgl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.vo.common.Result;

/**
 * <p>
 * 职务管理 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
public interface IJcZwglService extends IService<JcZwgl> {

       int insertForSql(JcZwgl jcZwgl);



}
