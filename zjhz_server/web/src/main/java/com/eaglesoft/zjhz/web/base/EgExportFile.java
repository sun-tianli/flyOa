package com.eaglesoft.zjhz.web.base;

import com.eaglesoft.zjhz.common.annotation.IgnoreAuth;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zsb on 2017/7/25.
 */
//@Controller
//@Api("文件导出")
public class EgExportFile {

    @Value("${upload.dir.excelExport}")
    private String excelPath;

    @ResponseBody
    @RequestMapping(value = "/rest/export/exportExcel", method = RequestMethod.GET)
    @IgnoreAuth
    public void exportExcel(@RequestParam String url, @RequestParam String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String ctime = formatter.format(new Date());

        String exportFileName = filename + ctime + ".xls";
        String path = excelPath + "/" + url + ".xls";

        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(exportFileName, "UTF-8"));

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(path);
            int len = 0;
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
