package com.ledao.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ledao.entity.Log;
import com.ledao.entity.Menu;
import com.ledao.entity.Role;
import com.ledao.entity.User;
import com.ledao.service.LogService;
import com.ledao.service.MenuService;
import com.ledao.service.RoleService;
import com.ledao.service.UserService;
import com.ledao.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 20:37
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    @Resource
    private LogService logService;

    @RequestMapping("/login")
    public Map<String, Object> login(String imageCode, @Valid User user, BindingResult bindingResult, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (StringUtil.isEmpty(imageCode)) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "请输入验证码!");
            return resultMap;
        }
        if (!session.getAttribute("checkcode").equals(imageCode)) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", "验证码输入错误!");
            return resultMap;
        }
        if (bindingResult.hasErrors()) {
            resultMap.put("success", false);
            resultMap.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
            return resultMap;
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
            String userName = (String) SecurityUtils.getSubject().getPrincipal();
            User currentUser = userService.findByUserName(userName);
            session.setAttribute("currentUser", currentUser);
            List<Role> roleList = roleService.findByUserId(currentUser.getId());
            if (roleList.size() == 0) {
                resultMap.put("success", false);
                resultMap.put("errorInfo", "你登录的账号还有被管理员分配角色,请联系管理员");
                return resultMap;
            }
            resultMap.put("roleList", roleList);
            resultMap.put("roleSize", roleList.size());
            resultMap.put("success", true);
            logService.add(new Log(Log.LOGIN_ACTION, "用户登录"));
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("success", false);
            resultMap.put("errorInfo", "用户名或者密码错误!");
            return resultMap;
        }
    }

    /**
     * session保存角色信息
     *
     * @param roleId
     * @param session
     * @return
     */
    @RequestMapping("saveRole")
    public Map<String, Object> saveRole(Integer roleId, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Role currentRole = roleService.findById(roleId);
        session.setAttribute("currentRole", currentRole);
        resultMap.put("success", true);
        return resultMap;
    }

    /**
     * 加载当前用户信息
     *
     * @param session
     * @return
     */
    @GetMapping("/loadUserInfo")
    public String loadUserInfo(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        Role currentRole = (Role) session.getAttribute("currentRole");
        return "<strong>欢迎您:" + currentUser.getTrueName() + "&nbsp;[&nbsp;" + currentRole.getName() + "&nbsp;]</strong>";
    }

    /**
     * 加载权限菜单
     *
     * @param session
     * @param parentId
     * @return
     */
    @RequestMapping("/loadMenuInfo")
    public String loadMenuInfo(HttpSession session, Integer parentId) {
        Role currentRole = (Role) session.getAttribute("currentRole");
        return getAllMenuByParentId(parentId, currentRole.getId()).toString();
    }

    /**
     * 获取所有菜单信息
     *
     * @param parentId
     * @param roleId
     * @return
     */
    public JsonArray getAllMenuByParentId(Integer parentId, Integer roleId) {
        JsonArray jsonArray = this.getMenuByParentId(parentId, roleId);
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            if ("open".equals(jsonObject.get("state").getAsString())) {
                continue;
            } else {
                jsonObject.add("children", getAllMenuByParentId(jsonObject.get("id").getAsInt(), roleId));
            }
        }
        return jsonArray;
    }

    /**
     * 根据父节点和用户角色Id查询菜单
     *
     * @param parentId
     * @param roleId
     * @return
     */
    public JsonArray getMenuByParentId(Integer parentId, Integer roleId) {
        List<Menu> menuList = menuService.findByParentIdAndRoleId(parentId, roleId);
        JsonArray jsonArray = new JsonArray();
        for (Menu menu : menuList) {
            JsonObject jsonObject = new JsonObject();
            // 节点Id
            jsonObject.addProperty("id", menu.getId());
            // 节点名称
            jsonObject.addProperty("text", menu.getName());
            if (menu.getState() == 1) {
                // 根节点
                jsonObject.addProperty("state", "closed");
            } else {
                // 叶子节点
                jsonObject.addProperty("state", "open");
            }
            // 节点图标
            jsonObject.addProperty("iconCls", menu.getIcon());
            // 扩展属性
            JsonObject attributeObject = new JsonObject();
            // 菜单请求地址
            attributeObject.addProperty("url", menu.getUrl());
            jsonObject.add("attributes", attributeObject);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }
}
