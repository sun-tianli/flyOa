package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.entity.jc.*;
import com.eaglesoft.zjhz.entity.vo.*;
import com.eaglesoft.zjhz.service.jc.*;
import com.eaglesoft.zjhz.vo.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eaglesoft.zjhz.web.base.BaseController;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色权限 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/rest/JcYhqxManage")
@Api("权限管理")
public class JcYhqxManageController extends BaseController {
    @Autowired
    IJcJsqxService jcJsqxService;

    @Autowired
    IJcDwglService jcDwglService;

    @Autowired
    IJcBmglService jcBmglService;

    @Autowired
    IJcJsglService iJcJsglService;

    @Autowired
    IJcYhglService iJcYhglService;

    @Autowired
    IJcYhqxService iJcYhqxService;

    @ApiOperation(value = "")
    @ResponseBody
    @PostMapping("/findUser")
    @IgnoreAuth
    public Result findUser(@RequestParam Integer dwbh) {
        QueryWrapper<JcDwgl> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(JcDwgl::getBh, dwbh).select(JcDwgl::getDwmc);
        List<String> dwmcs = jcDwglService.list(queryWrapper).stream().map(JcDwgl::getDwmc).collect(Collectors.toList());
        List<findUserTree> findUserTrees = new ArrayList<>();
        for (String dwmc : dwmcs) {
            findUserTree findUserTree = new findUserTree();
            findUserTree.setDwmc(dwmc);
            QueryWrapper<JcJsgl> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.lambda().eq(JcJsgl::getDwbh, dwbh);
            List<JcJsgl> jcJsgls = iJcJsglService.list(queryWrapper1);
            List<JcJsglTree> jcJsglTrees = new ArrayList<>();
            for (JcJsgl jcJsgl : jcJsgls) {
                JcJsglTree jcJsglTree = new JcJsglTree();
                jcJsglTree.setBh(jcJsgl.getBh());
                jcJsglTree.setDwbh(jcJsgl.getDwbh());
                jcJsglTree.setJsmc(jcJsgl.getJsmc());

                QueryWrapper<JcYhgl> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.lambda().eq(JcYhgl::getJs, jcJsgl.getBh());
                List<JcYhgl> jcYhgls = iJcYhglService.list(queryWrapper2);
                List<JcYhglTree> jcYhglTrees = new ArrayList<>();
                for (JcYhgl jcYhgl : jcYhgls) {
                    JcYhglTree jcYhglTree = new JcYhglTree();
                    jcYhglTree.setBh(jcYhgl.getBh());
                    jcYhglTree.setDwbh(jcYhgl.getDwbh());
                    jcYhglTree.setXm(jcYhgl.getXm());
                    QueryWrapper<JcYhqx> queryWrapper3 = new QueryWrapper<>();
                    queryWrapper3.lambda().eq(JcYhqx::getYhbh, jcYhgl.getBh()).select(JcYhqx::getQxbh);
                    List<Integer> qxs = iJcYhqxService.list(queryWrapper3).stream().map(JcYhqx::getQxbh).collect(Collectors.toList());
                    jcYhglTree.setPower(qxs);
                    jcYhglTrees.add(jcYhglTree);
                }
                jcJsglTree.setChildren(jcYhglTrees);

                QueryWrapper<JcJsqx> queryWrapper3 = new QueryWrapper<>();
                queryWrapper3.lambda().eq(JcJsqx::getJsbh, jcJsgl.getBh()).select(JcJsqx::getBh);
                List<Integer> qxs = jcJsqxService.list(queryWrapper3).stream().map(JcJsqx::getBh).collect(Collectors.toList());
                jcJsglTree.setPower(qxs);
                jcJsglTrees.add(jcJsglTree);
            }

            findUserTree.setJcJsgls(jcJsglTrees);
            findUserTrees.add(findUserTree);
        }

        return Result.success(findUserTrees);

    }


//    private Object[] zzjggl;
//
//    public static <T> void fatherToChild(T father, T child) throws Exception {
//        if (child.getClass().getSuperclass() != father.getClass()) {
//            throw new Exception("child 不是 father 的子类");
//        }
//        Class<?> fatherClass = father.getClass();
//        Field[] declaredFields = fatherClass.getDeclaredFields();
//        for (int i = 0; i < declaredFields.length; i++) {
//            Field field = declaredFields[i];
//            Method method = fatherClass.getDeclaredMethod("get" + upperHeadChar(field.getName()));
//            Object obj = method.invoke(father);
//            field.setAccessible(true);
//            field.set(child, obj);
//        }
//    }
//
//    public static String upperHeadChar(String in) {
//        String head = in.substring(0, 1);
//        String out = head.toUpperCase() + in.substring(1, in.length());
//        return out;
//    }


//    @ApiOperation(value = "组织机构管理")
//    @ResponseBody
//    @PostMapping("/findTree")
//    @IgnoreAuth
//    public Result findTree() {


//        List<JcDwgl> jcDwgls = jcDwglService.list();
//        for (JcDwgl jcdw : jcDwgls) {
//            Integer lft = jcdw.getLft();
//            Integer rgt = jcdw.getRgt();
//            jcdw.setChlidren(jcBmglService.selectChildren(lft, rgt));
//        }
//        return Result.success(jcDwgls);

//        List<jcDwglTree> jcDwglTrees = new ArrayList<>();
//        List<JcDwgl> jcDwgls = jcDwglService.list();
//        for (JcDwgl jcdw : jcDwgls) {
//            if (jcdw.getSjdw() == 0) {
//                jcDwglTree jcDwglTree = new jcDwglTree();
//                jcDwglTree.setDwbh(jcdw.getBh());
//                jcDwglTree.setDwmc(jcdw.getDwmc());
//                jcDwglTree.setLft(jcdw.getLft());
//                jcDwglTree.setRgt(jcdw.getRgt());
//                jcDwglTree.setSjdw(jcdw.getSjdw());
//                jcDwglTree.setWzh(jcdw.getWzh());
//
//                List<jcBmglTree> jcBmglTrees = new ArrayList<>();
//                List<JcBmgl> jcBmgls = jcBmglService.selectChildById(jcdw.getBh());
//                for (JcBmgl jcbm : jcBmgls) {
//                    if (jcbm.getSjbm() == 0) {
//                        jcBmglTree jcBmglTree = new jcBmglTree();
//                        jcBmglTree.setBmbh(jcbm.getBh());
//                        jcBmglTree.setBmmc(jcbm.getBmmc());
//                        jcBmglTree.setDwbh(jcbm.getDwbh());
//                        jcBmglTree.setLft(jcbm.getLft());
//                        jcBmglTree.setRgt(jcbm.getRgt());
//                        jcBmglTree.setSjbm(jcbm.getSjbm());
//                        jcBmglTree.setWzh(jcbm.getWzh());
//
////                        QueryWrapper<JcBmgl> queryWrapper = new QueryWrapper();
////                        queryWrapper.lambda().eq(JcBmgl::getSjbm, jcbm.getBh());
//
//
////                        List<jcBmglTree> jcBmglChildTrees = new ArrayList<>();
////                        List<JcBmgl> jcbmglChilds = jcBmglService.list(queryWrapper);
////                        for (JcBmgl jcbmChild : jcbmglChilds) {
////                            jcBmglTree jcBmglChildTree = new jcBmglTree();
////                            jcBmglChildTree.setWzh(jcbmChild.getWzh());
////                            jcBmglChildTree.setSjbm(jcbmChild.getSjbm());
////                            jcBmglChildTree.setRgt(jcbmChild.getRgt());
////                            jcBmglChildTree.setLft(jcbmChild.getLft());
////                            jcBmglChildTree.setDwbh(jcbmChild.getDwbh());
////                            jcBmglChildTree.setBmmc(jcbmChild.getBmmc());
////                            jcBmglChildTree.setBmbh(jcbmChild.getBh());
////                            jcBmglChildTree.setChild();
////
////                        }
//
//                        jcBmglTree.setChild(jcBmglService.findChildren(jcbm.getBh()));
//                        jcBmglTrees.add(jcBmglTree);
//
//                    }
//                }
//
//                jcDwglTree.setChild(jcBmglTrees);
//
//                jcDwglTrees.add(jcDwglTree);
//            }
//        }
//
//        return Result.success(jcDwglTrees);
//    }


//    @ApiOperation(value = "根据权限设置用户")
//    @ResponseBody
//    @PostMapping("/save")
//    @IgnoreAuth
//    public Result saveUser(@RequestBody jsyh jsyh){
//
//    }


    @ApiOperation(value = "权限管理")
    @ResponseBody
    @PostMapping("/save")
    @IgnoreAuth
    public Result save(@RequestBody qxglRequest qxglRequest) {
//        Integer dwbh = qxglRequest.getDwbh();
        powers powers = qxglRequest.getPowers();

        power[] power = powers.getPower();

        for (power pJs : power) {
            Integer[] currentPowers = pJs.getCurrentPower();
            Integer[] oldPower = pJs.getOldPower();
            Integer[] addarray = pJs.getAddarray();
            Integer[] nonearray = pJs.getNonearray();
            Integer jsbh = pJs.getJsbh();
            if (nonearray != null && nonearray.length > 0) {
                QueryWrapper<JcJsqx> queryWrapper = new QueryWrapper<>();
                for (Integer qxbh : nonearray) {
                    queryWrapper.lambda().eq(JcJsqx::getQxbh, qxbh)
//                            .eq(JcJsqx::getDwbh, dwbh)
                            .eq(JcJsqx::getJsbh, jsbh);
                    jcJsqxService.remove(queryWrapper);
                }

            }

            if (addarray != null && addarray.length > 0) {

                for (Integer qxbh : addarray) {
                    JcJsqx jcJsqx = new JcJsqx();
//                    jcJsqx.setDwbh(dwbh);
                    jcJsqx.setJsbh(jsbh);
                    jcJsqx.setQxbh(qxbh);
                    jcJsqxService.save(jcJsqx);
                }

            }
        }


        return Result.actionResult(true, Result.ACTION_UPDATE, null);
    }


    @ApiOperation(value = "根据权限设置用户")
    @ResponseBody
    @PostMapping("/setQx")
    @IgnoreAuth
    public Result saveYhByQx(@RequestBody setRequestByQx setRequestByQx) {
        Integer dwbh = setRequestByQx.getDwbh();
        Integer qxbh = setRequestByQx.getQxbh();
        Integer[] jsArr = setRequestByQx.getJsArr();

        List<Integer> datebase = jcJsqxService.checkDb(qxbh, dwbh);
        QueryWrapper<JcJsqx> queryWrapper = new QueryWrapper<>();
        if (datebase.size() > jsArr.length) {

            for (Integer jsdb : datebase) {
                boolean pdcz = false;
                for (Integer jsbh : jsArr) {
                    if (jsbh.equals(jsdb)) {
                        pdcz = true;
                        break;
                    }
                }
                if (pdcz == false) {
                    queryWrapper.lambda().eq(JcJsqx::getJsbh, jsdb);
                    jcJsqxService.remove(queryWrapper);
                }
            }
        } else {
            if (jsArr != null && jsArr.length > 0) {
                for (Integer jsbh : jsArr) {
                    JcJsqx jcJsqx = new JcJsqx();
                    if (jcJsqxService.checkRoleAuthExist(qxbh, dwbh, jsbh)) {
                        continue;
                    }
                    jcJsqx.setDwbh(dwbh);
                    jcJsqx.setJsbh(jsbh);
                    jcJsqx.setQxbh(qxbh);
                    jcJsqxService.save(jcJsqx);

                }
            }
        }
        return Result.actionResult(true, Result.ACTION_UPDATE, setRequestByQx);

    }


    @ApiOperation(value = "根据用户设置权限")
    @ResponseBody
    @PostMapping("/getQx")
    @IgnoreAuth
    public Result save(@RequestBody saveRequest saveRequest) {

        Integer dwbh = saveRequest.getDwbh();
        Integer jsbh = saveRequest.getBh();
        Integer[] qsArr = saveRequest.getArr();


        List<Integer> datebase = jcJsqxService.check(dwbh, jsbh);
        QueryWrapper<JcJsqx> queryWrapper = new QueryWrapper<>();
        if (datebase.size() > qsArr.length) {

            for (Integer qxdb : datebase) {
                boolean pdcz = false;
                for (Integer qxbh : qsArr) {
                    if (qxbh.equals(qxdb)) {
                        pdcz = true;
                        break;
                    }
                }
                if (pdcz == false) {
                    queryWrapper.lambda().eq(JcJsqx::getQxbh, qxdb);
                    jcJsqxService.remove(queryWrapper);
                }
            }
        } else {

            //为0或空就肯定不会是增了
            if (qsArr != null && qsArr.length > 0) {
                for (Integer qxbh : qsArr) {
                    JcJsqx jcJsqx = new JcJsqx();
                    if (jcJsqxService.checkRoleAuthExist(qxbh, dwbh, jsbh)) {
                        continue;
                    }
                    jcJsqx.setDwbh(dwbh);
                    jcJsqx.setJsbh(jsbh);
                    jcJsqx.setQxbh(qxbh);
                    jcJsqxService.save(jcJsqx);

                }
            }


        }
        return Result.actionResult(true, Result.ACTION_UPDATE, saveRequest);
    }


}

