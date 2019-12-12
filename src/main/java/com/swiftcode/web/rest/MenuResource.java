package com.swiftcode.web.rest;


import com.swiftcode.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chen
 **/
@RestController
@RequestMapping("/api")
public class MenuResource {
    private MenuService menuService;

    public MenuResource(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public ResponseEntity<Map<String, Object>> menus() {
        return ResponseEntity.ok(menuService.findMenus());
    }

}
