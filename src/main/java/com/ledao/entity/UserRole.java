package com.ledao.entity;

/**
 * 用户角色关联实体
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 21:45
 */
public class UserRole {
    /**
     * 编号
     */
    private Integer id;
    /**
     *用户
     */
    private User user;
    /**
     *角色
     */
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                '}';
    }
}
