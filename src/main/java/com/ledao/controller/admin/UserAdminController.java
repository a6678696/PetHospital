package com.ledao.controller.admin;

import com.ledao.entity.*;
import com.ledao.service.LogService;
import com.ledao.service.RoleService;
import com.ledao.service.UserRoleService;
import com.ledao.service.UserService;
import com.ledao.util.DateUtil;
import com.ledao.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户Controller层
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 23:03
 */
@Controller
@RequestMapping("/admin/user")
public class UserAdminController {

    @Value("${userImageFilePath}")
    private String userImageFilePath;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private LogService logService;

    /**
     * 下拉框模糊查询
     *
     * @param q
     * @return
     */
    @RequestMapping("/comboList")
    @ResponseBody
    @RequiresPermissions(value = "设备使用记录管理")
    public List<User> comboList(String q) {
        if (q == null) {
            q = "";
        }
        return userService.findByName(StringUtil.formatLike(q));
    }

    /**
     * 分页查询用户信息
     *
     * @param searchUser
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> list(User searchUser, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        map.put("userName", StringUtil.formatLike(searchUser.getUserName()));
        map.put("type", searchUser.getType());
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("key", 1);
        List<User> userList = userService.list(map);
        Long total = userService.getTotal(map);
        for (User user : userList) {
            List<Role> roleList = roleService.findByUserId(user.getId());
            StringBuffer sb = new StringBuffer();
            for (Role r : roleList) {
                sb.append("," + r.getName());
            }
            user.setRoles(sb.toString().replaceFirst(",", ""));
        }
        resultMap.put("rows", userList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询用户信息"));
        return resultMap;
    }

    /**
     * 保存或修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> save(User user, @RequestParam("userImage") MultipartFile file) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        if (!file.isEmpty()) {
            // 获取上传的文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr2() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(userImageFilePath + newFileName));
            if (user.getId() != null) {
                FileUtils.deleteQuietly(new File(userImageFilePath + userService.findById(user.getId()).getImageName()));
            }
            user.setImageName(newFileName);
        }
        int key;
        if (user.getId() == null) {
            key = userService.add(user);
            logService.add(new Log(Log.ADD_ACTION, "添加用户信息" + user));
        } else {
            key = userService.update(user);
            logService.add(new Log(Log.UPDATE_ACTION, "修改用户信息" + user));
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        userService.delete(id);
        userRoleService.deleteByUserId(id);
        resultMap.put("success", true);
        logService.add(new Log(Log.DELETE_ACTION, "删除用户信息" + userService.findById(id)));
        return resultMap;
    }

    /**
     * 保存用户角色设置
     *
     * @param roleIds
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveRoleSet")
    @ResponseBody
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> saveRoleSet(String roleIds, Integer userId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        userRoleService.deleteByUserId(userId);
        if (StringUtil.isNotEmpty(roleIds)) {
            String[] roleIdStr = roleIds.split(",");
            for (int i = 0; i < roleIdStr.length; i++) {
                Integer userId2 = userService.findById(userId).getId();
                Integer roleId2 = roleService.findById(Integer.parseInt(roleIdStr[i])).getId();
                userRoleService.add(roleId2, userId2);
            }
        }
        resultMap.put("success", true);
        logService.add(new Log(Log.UPDATE_ACTION, "保存用户角色设置"));
        return resultMap;
    }

    /**
     * 修改密码
     *
     * @param newPassword
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/modifyPassword")
    @ResponseBody
    @RequiresPermissions(value = "修改密码")
    public Map<String, Object> modifyPassword(String newPassword, HttpSession session) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        User currentUser = (User) session.getAttribute("currentUser");
        User user = userService.findById(currentUser.getId());
        user.setPassword(newPassword);
        userService.update(user);
        resultMap.put("success", true);
        logService.add(new Log(Log.UPDATE_ACTION, "修改密码"));
        return resultMap;
    }

    /**
     * 安全退出
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/logout")
    @RequiresPermissions(value = "安全退出")
    public String logout() {
        logService.add(new Log(Log.LOGOUT_ACTION, "用户注销"));
        SecurityUtils.getSubject().logout();
        return "redirect:/login.html";
    }
}
