package com.swiftcode.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.swiftcode.domain.Authority;
import com.swiftcode.domain.Menu;
import com.swiftcode.domain.User;
import com.swiftcode.repository.MenuRepository;
import com.swiftcode.repository.UserRepository;
import com.swiftcode.security.AuthoritiesConstants;
import com.swiftcode.security.SecurityUtils;
import com.swiftcode.service.dto.MenuDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chen
 **/
@Slf4j
@Service
public class MenuService {
    private MenuRepository menuRepository;
    private UserRepository userRepository;

    public MenuService(MenuRepository menuRepository, UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }


    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> findMenus() {
        Map<String, Object> data = Maps.newHashMap();
        try {
            String login = SecurityUtils.getCurrentUserLogin().get();
            User user = userRepository.findOneByLogin(login).get();
            Set<Authority> authorities = user.getAuthorities();
            boolean isAdmin = false;
            for (Authority authority : authorities) {
                if (authority.getName().equals(AuthoritiesConstants.ADMIN)) {
                    isAdmin = true;
                    break;
                }
            }
            //查询所有菜单
            List<Menu> allMenu = menuRepository.findAll(new Sort(Sort.Direction.ASC, "parentId", "order"));

            List<MenuDTO> allMenuDto = allMenu
                .stream()
                .map(menu -> new MenuDTO(menu.getId(), menu.getText(), menu.getParentId(), menu.getIcon(),  menu.getLink(), menu.getOrder(), Lists.newArrayListWithCapacity(0))).collect(Collectors.toList());
            //根节点
            List<MenuDTO> rootMenu = Lists.newArrayList();
            for (Menu nav : allMenu) {
                if (nav.getParentId() == 0) {
                    MenuDTO rootDto = new MenuDTO(nav.getId(), nav.getText(), nav.getParentId(), nav.getIcon(),  nav.getLink(), nav.getOrder(), Lists.newArrayListWithCapacity(0));
                    rootMenu.add(rootDto);
                }
            }
            /* 根据Menu类的order排序 */
            rootMenu.sort(Menu.order());
            //为根菜单设置子菜单，getChild是递归调用的
            for (MenuDTO nav : rootMenu) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<MenuDTO> childList = getChild(nav.getId(), allMenuDto);
                nav.setChildren(childList);
            }
            data.put("success", "true");
            data.put("menu", rootMenu);
            return data;
        } catch (Exception e) {
            data.put("success", "false");
            data.put("menu", Collections.EMPTY_LIST);
            return data;
        }
    }


    private List<MenuDTO> getChild(Long id, List<MenuDTO> allMenu) {
        //子菜单
        List<MenuDTO> childList = Lists.newArrayList();
        for (MenuDTO nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (nav.getParentId().equals(id)) {
                childList.add(nav);
            }
        }
        //递归
        for (MenuDTO nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        childList.sort(Menu.order());
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return Lists.newArrayList();
        }
        return childList;
    }
}
