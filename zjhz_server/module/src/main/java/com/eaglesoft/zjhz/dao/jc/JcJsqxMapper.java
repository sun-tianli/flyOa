package com.eaglesoft.zjhz.dao.jc;

import com.eaglesoft.zjhz.entity.jc.JcJsqx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色权限 Mapper 接口
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-22
 */
public interface JcJsqxMapper extends BaseMapper<JcJsqx> {
    List<JcJsqx> getQx(Integer qxbh, Integer dwbh, Integer jsbh);

    List<Integer> getAllQx(Integer dwbh, Integer jsbh);

    //    List<JcJsqx> getJs(Integer dwbh, Integer qxbh, Integer jsbh);

    List<Integer> getAllJs(Integer qxbh, Integer dwbh);

}
