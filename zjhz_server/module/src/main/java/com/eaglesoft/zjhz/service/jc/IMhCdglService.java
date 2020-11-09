package com.eaglesoft.zjhz.service.jc;

import com.eaglesoft.zjhz.entity.jc.MhCdgl;
import com.baomidou.mybatisplus.extension.service.IService;
import com.eaglesoft.zjhz.entity.vo.MhCdaglTree;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 门户-菜单管理 服务类
 * </p>
 *
 * @author eaglesoft
 * @since 2020-11-02
 */
public interface IMhCdglService extends IService<MhCdgl> {

    List<MhCdaglTree> findChild(@RequestParam Integer bh);


}
