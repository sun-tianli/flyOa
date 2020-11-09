package com.eaglesoft.zjhz.web.base;

import com.eaglesoft.zjhz.common.constant.BaseEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eaglesoft.zjhz.vo.common.PageVo;
import com.eaglesoft.zjhz.vo.common.Result;
import org.springframework.beans.factory.annotation.Value;

public class BaseController {
    @Value("${client.Login.Url}")
    protected String clientLoginUrl;

    @Value("${client.Id}")
    protected String clientId;

    @Value("${client.Secret}")
    protected String clientSecret;

    @Value("${upload.dir.dajnml}")
    String filePath;

    protected Result getDataTable(IPage<?> pageInfo) {
        if(pageInfo == null){
            return Result.result(BaseEnum.ResultCode.ErrSelect);
        }
        PageVo pageVo = new PageVo();
        pageVo.setRows(pageInfo.getRecords());
        pageVo.setTotal(pageInfo.getTotal());
        pageVo.setTotalPage(pageInfo.getPages());
        return Result.success(pageVo);
    }
}
