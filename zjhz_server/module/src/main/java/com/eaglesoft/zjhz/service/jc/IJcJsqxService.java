package com.eaglesoft.zjhz.service.jc;

import com.eaglesoft.zjhz.entity.jc.JcJsqx;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色权限 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-22
 */
public interface IJcJsqxService extends IService<JcJsqx> {

    boolean checkRoleAuthExist(Integer qxbh, Integer dwbh, Integer jsbh);

        List<Integer> check(Integer dwbh, Integer jsbh);
//    boolean check(Integer dwbh, Integer jsbh,Integer[] qsArr);

//    boolean checkJsExist(Integer dwbh,Integer qxbh,Integer jsbh);

    List<Integer> checkDb(Integer qxbh, Integer dwbh);
}
