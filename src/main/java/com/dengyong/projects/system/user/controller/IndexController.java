package com.dengyong.projects.system.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.dengyong.framework.config.SMSConfig;
import com.dengyong.framework.web.controller.BaseController;
import com.dengyong.projects.system.menu.domain.Menu;
import com.dengyong.projects.system.menu.service.IMenuService;
/*import com.dengyong.project.system.menu.domain.Menu;
import com.dengyong.projects.system.menu.service.IMenuService;*/
import com.dengyong.projects.system.user.domain.User;

/**
 * 首页 业务处理
 * 
 * @author dengyong
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private SMSConfig smsConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", smsConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", smsConfig.getVersion());
        return "main";
    }
}
