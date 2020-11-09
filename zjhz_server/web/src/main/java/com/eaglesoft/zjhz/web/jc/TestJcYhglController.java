package com.eaglesoft.zjhz.web.jc;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import com.eaglesoft.zjhz.common.annotation.LoginUser;
import com.eaglesoft.zjhz.common.constant.BaseEnum;
import com.eaglesoft.zjhz.common.token.JwtToken;
import com.eaglesoft.zjhz.common.token.TokenService;
import com.eaglesoft.zjhz.dao.jc.TestJcYhglMapper;
import com.eaglesoft.zjhz.entity.jc.testJcYhgl;
import com.eaglesoft.zjhz.service.jc.testIJcYhglService;
import com.eaglesoft.zjhz.vo.common.Result;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcYhPageResult;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhAddRequest;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.JcyhPageRequest;
import com.eaglesoft.zjhz.vo.common.jc.yhgl.LoginResult;
import com.eaglesoft.zjhz.web.base.BaseController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author eaglesoft
 * @since 2019-12-17
 */
//@RestController
//@RequestMapping("/rest/jcYhgl")
//@Api("基础用户管理")
public class TestJcYhglController extends BaseController {
    @Autowired
    testIJcYhglService jcYhglService;


    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "获取全部用户")
    @ResponseBody
    @PostMapping("/getYhList")
    @IgnoreAuth
    public Result getYhList() {
        return Result.success(jcYhglService.selectAll());
    }


    @ApiOperation(value = "登录")
    @ResponseBody
    @GetMapping("/login")
    @IgnoreAuth
//    @Log(value = "登录", operationName = "登录", operationType = 0)
//    @Limit(limitType = BaseEnum.LimitType.IP, key = "login", period = 120, count = 10, name = "登录接口", prefix = "limit")
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result login(@RequestParam("登录用户名") String username, @RequestParam("密码") String password) {
        testJcYhgl user = jcYhglService.selectByUsername(username);
        if (user == null) {
            return Result.result(BaseEnum.ResultCode.ErrUserPwd.getCode(), BaseEnum.ResultCode.ErrUserPwd.getMsg());
        }
        //判断当前登陆用户是否与数据库中密码一致
        String another = user.getMm();
        if (!another.equalsIgnoreCase(password)) {
            return Result.result(BaseEnum.ResultCode.ErrUserPwd.getCode(), BaseEnum.ResultCode.ErrUserPwd.getMsg());
        }
        //利用jwt生成token
        JwtToken jwtToken = null;
        try {
            jwtToken = tokenService.getJwtToken(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //构建返回参数
        LoginResult loginResult = new LoginResult();
        loginResult.setToken(jwtToken.getToken());
        loginResult.setUsername(username);
        return Result.success(loginResult);
    }

    @ApiOperation(value = "获取用户_分页方式")
    @ResponseBody
    @PostMapping("/getYhPage")
    @IgnoreAuth
    public Result<IPage<testJcYhgl>> getYhPage(@RequestBody JcyhPageRequest pageRequest, @LoginUser @ApiIgnore testJcYhgl jcYhgl) {
        return getDataTable(jcYhglService.selectPage(pageRequest));
    }


    @ApiOperation(value = "获取用户_分页方式，自定义sql")
    @ResponseBody
    @PostMapping("/getYhPage_sql")
    @IgnoreAuth
    public Result<IPage<JcYhPageResult>> getYhPage_sql(@RequestBody JcyhPageRequest pageRequest) {
        return getDataTable(jcYhglService.selectPageForSql(pageRequest));
    }


    @ApiOperation(value = "新增用户")
    @ResponseBody
    @PostMapping("/addUser")
    @IgnoreAuth
    public Result addUser(@RequestBody testJcYhgl yhgl) {
        return jcYhglService.addUser(yhgl);
    }


    @ApiOperation(value = "新增用户，自定义sql")
    @ResponseBody
    @PostMapping("/addUserForSql")
    @IgnoreAuth
    public Result addUserForSql(@RequestBody JcyhAddRequest yhgl) {
        return jcYhglService.addUserForSql(yhgl);
    }


    @ApiOperation(value = "修改用户")
    @ResponseBody
    @PostMapping("/updateUser")
    @IgnoreAuth
    public Result updateUser(@RequestBody testJcYhgl yhgl) {
        return Result.actionResult(jcYhglService.updateById(yhgl), Result.ACTION_UPDATE, yhgl.getBh());
    }

    @ApiOperation(value = "删除用户")
    @ResponseBody
    @PostMapping("/deleteUser")
    @IgnoreAuth
    public Result deleteUser(@RequestParam("用户编号") @NotNull Integer yhBh) {
        return Result.actionResult(jcYhglService.removeById(yhBh), Result.ACTION_DELETE, yhBh);
    }
}

