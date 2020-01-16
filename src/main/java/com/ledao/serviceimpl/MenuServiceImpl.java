package com.ledao.serviceimpl;

import com.ledao.entity.Menu;
import com.ledao.mapper.MenuMapper;
import com.ledao.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限菜单Service实现类
 *
 * @author LeDao
 * @company
 * @create 2020-01-16 22:42
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findByParentIdAndRoleId(Integer parentId, Integer roleId) {
        return menuMapper.findByParentIdAndRoleId(parentId, roleId);
    }
}
