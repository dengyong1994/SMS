package com.dengyong.projects.system.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dengyong.common.utils.StringUtils;
import com.dengyong.framework.web.controller.BaseController;
import com.dengyong.framework.web.domain.AjaxResult;
import com.dengyong.common.utils.ServletUtils;



/**
 * 
* <p>Title: LoginController</p>  
* <p>Description:登录验证 </p>  
* @author dengyong  
* @date 2019年3月30日  
* @version 1.0.0
 */
@Controller
public class LoginController extends BaseController
{
    
	/**
	 * 后台登录首页
	 */
	@GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        

        return "login";
    }
    /**
     * 登录验证
     * @param username
     * @param password
     * @param rememberMe
     */
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe)
    {
    	UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            return success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }
    
   
}
