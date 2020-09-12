package com.aye.admin.controller;

import com.aye.admin.config.V2Config;
import com.aye.admin.model.BootstrapTree;
import com.aye.admin.model.domain.SysNotice;
import com.aye.admin.model.domain.SysUser;
import com.aye.admin.service.ISysPermissionService;
import com.aye.admin.service.ISysRoleService;
import com.aye.admin.service.ISysUserService;
//import com.aye.admin.shiro.ShiroUtils;
import com.aye.admin.utils.StringUtils;
import com.google.code.kaptcha.Constants;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName AdminController
 * @Description 主页登陆界面
 * @Author Aye
 * @Date 2020/9/9 14:30
 * @Version 1.0
 */

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    //系统用户
    @Autowired
    public ISysUserService sysUserService;

    //系统角色
    @Autowired
    public ISysRoleService sysRoleService;

    //权限
    @Autowired
    public ISysPermissionService sysPermissionService;
    private String prefix = "admin";
    private String prefix1 = "/login";

//    @ApiOperation(value = "首页", notes = "首页")
//    @GetMapping("/index")
//    public String index(HttpServletRequest request) {
//        String defaultBaseDir = V2Config.getDefaultBaseDir();
//        //获取菜单栏
//        BootstrapTree bootstrapTree = sysPermissionService.getBootBootstrapTreePerm(ShiroUtils.getUserId());
//        request.getSession().setAttribute("bootstrapTree", bootstrapTree);
//        request.getSession().setAttribute("sessionUserName", ShiroUtils.getUser().getNickname());
//        //获取公告信息
////        List<SysNotice> notices = sysNoticeService.getuserNoticeNotRead(ShiroUtils.getUser(), 0);
//        List<SysNotice> notices = new ArrayList<SysNotice>();
//        SysNotice sysNotice = new SysNotice();
//        sysNotice.setTitle("setTitle");
//        sysNotice.setContent("setContent");
//        sysNotice.setType(1);
//        sysNotice.setCreateUsername("setCreateUsername");
//        sysNotice.setCreateId("1");
//        sysNotice.setCreateTime(LocalDateTime.MAX);
//        notices.add(sysNotice);
//        request.getSession().setAttribute("notices", notices);
//        return prefix + "/index";
//    }

    /**
     * 请求到登陆界面
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "请求到登陆界面", notes = "请求到登陆界面")
    @GetMapping("/login")
    public String login(
//            ModelMap modelMap
    ) {
//        try {
//            if ((null != SecurityUtils.getSubject() && SecurityUtils.getSubject().isAuthenticated()) || SecurityUtils.getSubject().isRemembered()) {
//                return "redirect:/" + prefix + "/index";
//            } else {
//                System.out.println("--进行登录验证..验证开始");
//
//                modelMap.put("RollVerification", V2Config.getRollVerification());
//                System.out.println("V2Config.getRollVerification()>>>" + V2Config.getRollVerification());
//                return "login";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return prefix1 +"/login";
    }
//
//
//    /**
//     * 用户登陆验证
//     * @param user
//     * @param rcode
//     * @param redirectAttributes
//     * @param rememberMe
//     * @param model
//     * @param request
//     * @return
//     */
//    @ApiOperation(value="用户登陆验证",notes="用户登陆验证")
//    @PostMapping("/login")
//    @ResponseBody
//    public ModelAndView login(SysUser user, String code, RedirectAttributes redirectAttributes, boolean rememberMe, HttpServletRequest request) {
//        ModelAndView view =new ModelAndView();
//        Boolean yz=false;
//        if(V2Config.getRollVerification()) {//滚动验证
//            yz=true;
//        }else {//图片验证
//            String scode = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//            yz= StringUtils.isNotEmpty(scode)&&StringUtils.isNotEmpty(code)&&scode.equals(code);
//        }
//        //判断验证码
//        if(yz){
//            String userName = user.getUsername();
//            Subject currentUser = SecurityUtils.getSubject();
//            //是否验证通过
//            if(!currentUser.isAuthenticated()) {
//                UsernamePasswordToken token =new UsernamePasswordToken(userName,user.getPassword());
//                try {
//                    if(rememberMe) {
//                        token.setRememberMe(true);
//                    }
//                    //存入用户
//                    currentUser.login(token);
//                    if(StringUtils.isNotNull(ShiroUtils.getUser())) {
//                        //跳转到 get请求的登陆方法
//                        view.setViewName("redirect:/"+prefix+"/index");
//                        return  view;
//                        //return  AjaxResult.success();
//                    }else {
//                        return  view;
////                        return  AjaxResult.error(500,"未知账户");
//                    }
//                }catch (UnknownAccountException uae) {
//                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
//                    return  view;
////                    return  AjaxResult.error(500,"未知账户");
//                } catch (IncorrectCredentialsException ice) {
//                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
//                    return  view;
////                    return AjaxResult.error(500, "用户名或密码不正确");
//                } catch (LockedAccountException lae) {
//                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
//                    return  view;
////                    return AjaxResult.error(500,"账户已锁定");
//                } catch (ExcessiveAttemptsException eae) {
//                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
//                    return  view;
////                    return AjaxResult.error(500,"用户名或密码错误次数过多");
//                } catch (AuthenticationException ae) {
//                    //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
//                    log.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
//                    ae.printStackTrace();
//                    return  view;
////                    return AjaxResult.error(500,"用户名或密码不正确");
//                }
//            }else {
//                if(StringUtils.isNotNull(ShiroUtils.getUser())) {
//                    //跳转到 get请求的登陆方法
//                    view.setViewName("redirect:/"+prefix+"/index");
//                    return  view;
////                    return  AjaxResult.success();
//                }else {
//                    return  view;
////                    return  AjaxResult.error(500,"未知账户");
//                }
//            }
//        }else{
//            return  view;
////            return AjaxResult.error(500,"验证码不正确!");
//        }
//
//    }
//
//
//    /****页面测试****/
//    @ApiOperation(value="404页面",notes="404页面")
//    @GetMapping("Out404")
//    public String Out404(HttpServletRequest request, HttpServletResponse response){
//
//        return "redirect:/error/404";
//    }
//
//    @GetMapping("Out403")
//    @ApiOperation(value="403页面",notes="403页面")
//    public String Out403(HttpServletRequest request, HttpServletResponse response){
//
//        return "redirect:/error/403";
//    }
//
//    @ApiOperation(value="500页面",notes="500页面")
//    @GetMapping("Out500")
//    public String Out500(HttpServletRequest request, HttpServletResponse response){
//
//        return "redirect:/error/500";
//    }
//
//    /**
//     * 权限测试跳转页面
//     * @param request
//     * @param response
//     * @return
//     */
//    @ApiOperation(value="权限测试跳转页面",notes="权限测试跳转页面")
//    @GetMapping("Outqx")
//    @RequiresPermissions("system:user:asd")
//    public String Outqx(HttpServletRequest request, HttpServletResponse response){
//
//        return "redirect:/error/500";
//    }
    /****页面测试EDN****/
}