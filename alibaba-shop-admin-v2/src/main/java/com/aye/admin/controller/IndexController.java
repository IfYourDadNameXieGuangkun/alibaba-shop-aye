//package com.aye.admin.controller;
//
//import com.aye.admin.common.base.BaseController;
//import com.aye.admin.model.TitleVo;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//
///**
// * @ClassName IndexController
// * @Description 页面首页
// * @Author Aye
// * @Date 2020/9/9 13:59
// * @Version 1.0
// */
//@Controller
//public class IndexController extends BaseController {
//
//    @GetMapping
//    public String index(ModelMap map){
//        String str="前台";
//        setTitle(map, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
//        return "index";
//    }
//
//    /**
//     * 前台访问/index的get请求
//     * @param map
//     * @return
//     * @author fuce
//     * @Date 2019年11月20日 下午10:54:56
//     */
//    @ApiOperation(value="前台",notes="前台")
//    @GetMapping("/index")
//    public String index2(ModelMap map) {
//        String str="前台";
//        setTitle(map, new TitleVo("列表", str+"管理", true,"欢迎进入"+str+"页面", true, false));
//        return "index";
//    }
//}