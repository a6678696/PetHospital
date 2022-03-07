package com.ledao.controller.admin;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ledao.entity.*;
import com.ledao.service.*;
import com.ledao.util.StringUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 后台管理角色Controller
 *
 * @author LeDao
 * @company
 * @create 2020-01-17 11:16
 */
@RestController
@RequestMapping("/admin/role")
public class RoleAdminController {

    @Resource
    private RoleService roleService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private MenuService menuService;

    @Resource
    private RoleMenuService roleMenuService;

    @Resource
    private LogService logService;

    /**
     * 下拉框模糊查询
     *
     * @return
     */
    @RequestMapping("/comboList")
    @RequiresPermissions(value = "设备使用记录管理")
    public List<Role> comboList() {
        List<Role> roleList = roleService.list(null);
        ListIterator<Role> listIterator = roleList.listIterator();
        while (listIterator.hasNext()) {
            Role role = listIterator.next();
            if (role.getId() == 1) {
                listIterator.remove();
            }
        }
        return roleList;
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @RequestMapping("/listAll")
    @RequiresPermissions(value = {"用户管理", "角色管理"}, logical = Logical.OR)
    public Map<String, Object> listAll() {
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("rows", roleService.listAll());
        logService.add(new Log(Log.SEARCH_ACTION, "查询所有角色信息"));
        return resultMap;
    }

    /**
     * 分页查询角色信息
     *
     * @param role
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    @RequestMapping("/list")
    @RequiresPermissions(value = "角色管理")
    public Map<String, Object> list(Role role, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows) {
        PageBean pageBean = new PageBean(page, rows);
        Map<String, Object> resultMap = new HashMap<>(16);
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", StringUtil.formatLike(role.getName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Role> roleList = roleService.list(map);
        Long total = roleService.getCount(map);
        resultMap.put("rows", roleList);
        resultMap.put("total", total);
        logService.add(new Log(Log.SEARCH_ACTION, "查询角色信息"));
        return resultMap;
    }

    /**
     * 添加或者修改角色信息
     *
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = "角色管理")
    public Map<String, Object> save(Role role) {
        int key;
        Map<String, Object> resultMap = new HashMap<>(16);
        if (role.getId() == null) {
            if (roleService.findByRoleName(role.getName()) != null) {
                resultMap.put("success", false);
                resultMap.put("errorInfo", "角色名已经存在！");
                return resultMap;
            }
            key = roleService.add(role);
            logService.add(new Log(Log.ADD_ACTION, "添加角色信息" + role));
        } else {
            key = roleService.update(role);
            logService.add(new Log(Log.UPDATE_ACTION, "修改角色信息" + role));
        }
        if (key > 0) {
            resultMap.put("success", true);
        } else {
            resultMap.put("success", false);
        }
        return resultMap;
    }

    /**
     * 删除角色信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    @RequiresPermissions(value = "角色管理")
    public Map<String, Object> delete(Integer id) {
        logService.add(new Log(Log.DELETE_ACTION, "删除角色信息" + roleService.findById(id)));
        Map<String, Object> resultMap = new HashMap<>(16);
        roleMenuService.deleteByRoleId(id);
        userRoleService.deleteByRoleId(id);
        roleService.delete(id);
        resultMap.put("success", true);
        return resultMap;
    }


    /**
     * 根据父节点获取所有复选框权限菜单
     *
     * @param parentId
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/loadCheckMenuInfo")
    @RequiresPermissions(value = "角色管理")
    public String loadCheckMenuInfo(Integer parentId, Integer roleId) {
        List<Menu> menuList = menuService.findByRoleId(roleId);
        List<Integer> menuIdList = new LinkedList<>();
        for (Menu menu : menuList) {
            menuIdList.add(menu.getId());
        }
        return getAllCheckMenuByParentId(parentId, menuIdList).toString();
    }

    /**
     * 根据父节点id和权限菜单id集合获取所有复选框菜单集合
     *
     * @param parentId
     * @param menuIdList
     * @return
     */
    public JsonArray getAllCheckMenuByParentId(Integer parentId, List<Integer> menuIdList) {
        JsonArray jsonArray = this.getCheckMenuByParentId(parentId, menuIdList);
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            if ("open".equals(jsonObject.get("state").getAsString())) {
                continue;
            } else {
                jsonObject.add("children", getAllCheckMenuByParentId(jsonObject.get("id").getAsInt(), menuIdList));
            }
        }
        return jsonArray;
    }

    /**
     * 根据父节点id和权限菜单id集合获取一层复选框菜单集合
     *
     * @param parentId
     * @param menuIdList
     * @return
     */
    public JsonArray getCheckMenuByParentId(Integer parentId, List<Integer> menuIdList) {
        List<Menu> menuList = menuService.findByParentId(parentId);
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
            if (menuIdList.contains(menu.getId())) {
                jsonObject.addProperty("checked", true);
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    /**
     * 保存角色权限设置
     *
     * @param menuIds
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveMenuSet")
    @RequiresPermissions(value = "角色管理")
    public Map<String, Object> saveMenuSet(String menuIds, Integer roleId) throws Exception {
        Map<String, Object> resultMap = new HashMap<>(16);
        // 根据角色id删除所有角色权限关联实体
        roleMenuService.deleteByRoleId(roleId);
        if (StringUtil.isNotEmpty(menuIds)) {
            String[] idsStr = menuIds.split(",");
            for (int i = 0; i < idsStr.length; i++) {
                Integer menuId2 = roleService.findById(roleId).getId();
                Integer roleId2 = menuService.findById(Integer.parseInt(idsStr[i])).getId();
                roleMenuService.add(roleId2, menuId2);
            }
        }
        resultMap.put("success", true);
        return resultMap;
    }
}
