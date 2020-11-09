package com.eaglesoft.zjhz.service.jc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eaglesoft.zjhz.entity.jc.XtCzrz;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.entity.vo.XtCzrzPage;

/**
 * <p>
 * 操作日志表 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-03
 */
public interface IXtCzrzService extends IService<XtCzrz> {
        IPage<XtCzrz> selectPage(XtCzrzPage xtCzrzPage);
}
