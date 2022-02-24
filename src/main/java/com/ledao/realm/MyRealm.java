package com.ledao.realm;

import com.ledao.entity.Menu;
import com.ledao.entity.Role;
import com.ledao.entity.User;
import com.ledao.mapper.UserMapper;
import com.ledao.service.MenuService;
import com.ledao.service.RoleService;
import com.ledao.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义Realm
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 02:30
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private MenuService menuService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.findByUserName(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roleList = roleService.findByUserId(user.getId());
        Set<String> roles = new HashSet<>(16);
        for (Role role : roleList) {
            roles.add(role.getName());
            List<Menu> menuList = menuService.findByRoleId(role.getId());
            for (Menu menu : menuList) {
                info.addStringPermission(menu.getName());
            }
        }
        info.setRoles(roles);
        return info;
    }

    /**
     * 权限认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        User user = userService.findByUserName(userName);
        if (user != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "xxx");
            return authenticationInfo;
        } else {
            return null;
        }
    }
}
