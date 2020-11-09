package com.eaglesoft.zjhz.service.jc.impl;

import com.eaglesoft.zjhz.entity.jc.JcJsqx;
import com.eaglesoft.zjhz.dao.jc.JcJsqxMapper;
import com.eaglesoft.zjhz.service.jc.IJcJsqxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色权限 服务实现类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-22
 */
@Service
public class JcJsqxServiceImpl extends ServiceImpl<JcJsqxMapper, JcJsqx> implements IJcJsqxService {
    //  @Autowired
//  private JcJsqxMapper jcJsqxMapper;
//
    @Override
    public boolean checkRoleAuthExist(Integer qxbh, Integer dwbh, Integer jsbh) {
//        JcJsqx query=new JcJsqx();
        List<JcJsqx> getList = baseMapper.getQx(qxbh, dwbh, jsbh);
        if (getList==null||getList.size()==0) {
            return false;
        }
        return true;
    }

    @Override
    public List<Integer> check(Integer dwbh, Integer jsbh){
       return baseMapper.getAllQx(dwbh,jsbh);
    }

//    @Override
//    public boolean checkJsExist(Integer dwbh,Integer qxbh,Integer jsbh){
//        List<JcJsqx> getList = baseMapper.getJs(dwbh, qxbh, jsbh);
//        if (getList==null||getList.size()==0) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public List<Integer> checkDb(Integer qxbh, Integer dwbh){
        return baseMapper.getAllJs(qxbh,dwbh);
    }




}
