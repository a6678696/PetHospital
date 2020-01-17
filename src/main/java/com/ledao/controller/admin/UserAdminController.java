package com.ledao.controller.admin;

import com.ledao.entity.PageBean;
import com.ledao.entity.Role;
import com.ledao.entity.User;
import com.ledao.entity.UserRole;
import com.ledao.service.RoleService;
import com.ledao.service.UserRoleService;
import com.ledao.service.UserService;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RestController
@RequestMapping("/admin/user")
public class UserAdminController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    /**
     * 分页查询用户信息
     *
     * @param searchUser
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> list(User searchUser, @RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows) {
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        map.put("userName", StringUtil.formatLike(searchUser.getUserName()));
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
        return resultMap;
    }

    /**
     * 保存或修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> save(User user) {
        Map<String, Object> resultMap = new HashMap<>(16);
        int key;
        if (user.getId() == null) {
            key = userService.add(user);
        } else {
            key = userService.update(user);
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
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> resultMap = new HashMap<>(16);
        userRoleService.deleteByUserId(id);
        userService.delete(id);
        resultMap.put("success", true);
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
    @RequiresPermissions(value = "用户管理")
    public Map<String, Object> saveRoleSet(String roleIds, Integer userId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        userRoleService.deleteByUserId(userId);
        if (StringUtil.isNotEmpty(roleIds)) {
            String[] roleIdStr = roleIds.split(",");
            for (int i = 0; i < roleIdStr.length; i++) {
                Integer userId2=userService.findById(userId).getId();
                Integer roleId2=roleService.findById(Integer.parseInt(roleIdStr[i])).getId();
                userRoleService.add(roleId2,userId2);
            }
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
