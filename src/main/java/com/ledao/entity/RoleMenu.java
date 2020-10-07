package com.ledao.entity;

/**
 * 角色菜单关联实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:46
 */
public class RoleMenu {
    /**
     * 编号
     */
    private Integer id;
    /**
     *角色
     */
    private Role role;
    /**
     *菜单
     */
    private Menu menu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id=" + id +
                ", role=" + role +
                ", menu=" + menu +
                '}';
    }
}
