package com.eaglesoft.zjhz.service.jc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eaglesoft.zjhz.entity.jc.JcYhgl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.entity.vo.YhglPage;

/**
 * <p>
 * 用户管理 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-23
 */
public interface IJcYhglService extends IService<JcYhgl> {

    IPage<JcYhgl> selectPage(YhglPage pageRequest);

}
