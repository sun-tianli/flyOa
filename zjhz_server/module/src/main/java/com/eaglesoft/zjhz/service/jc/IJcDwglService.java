package com.eaglesoft.zjhz.service.jc;

import com.alibaba.fastjson.JSONArray;
import com.eaglesoft.zjhz.entity.jc.JcDwgl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.entity.vo.jcDwglChild;
import com.eaglesoft.zjhz.entity.vo.jcDwglTree;
import com.eaglesoft.zjhz.entity.vo.selectDwmc;
import com.eaglesoft.zjhz.entity.vo.selectZw;

import java.util.List;

/**
 * <p>
 * 设置所有使用OA系统的单位架构信息，如果是集团版一般会有多家单位 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-20
 */
public interface IJcDwglService extends IService<JcDwgl> {
    /**
     * 模糊查询所有用户
     *
     * @return
     */

    List<selectDwmc> selectDwforsql(selectDwmc dw);

    /**
     * 根据bh部门编号查找zwmc所属职务名称
     *
     * @return
     */

    List<selectZw> selectZwByDwId(Integer bh);

    List<jcDwglTree> findChildren(Integer jcdwBh);

    List<jcDwglChild> getJcDwglTrees(Integer jcdwbh);

 /**
 *
 *@Author suntl
 *@Date 2020/11/9 10:03
 */
//    JSONArray find(Integer dwbh);

}
