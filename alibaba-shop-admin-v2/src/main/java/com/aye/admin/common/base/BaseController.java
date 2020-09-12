package com.aye.admin.common.base;

import com.aye.admin.model.TitleVo;
import org.springframework.ui.ModelMap;

/**
 * @ClassName BaseController
 * @Description web层通用数据处理
 * @Author Aye
 * @Date 2020/9/9 14:01
 * @Version 1.0
 */
public class BaseController {




    /**
     * 设置标题通用方法
     * @param model
     */
    public void setTitle(ModelMap map, TitleVo titleVo){
        //标题
        map.put("title",titleVo.getTitle());
        map.put("parenttitle",titleVo.getParenttitle());
        //是否打开欢迎语
        map.put("isMsg",titleVo.isMsg());
        //欢迎语
        map.put("msgHTML",titleVo.getMsgHtml());
        //小控件
        map.put("isControl",titleVo.isControl());
        map.put("isribbon", titleVo.isIsribbon());
    }
}