package com.aorez.controller;

import com.aorez.domain.Role;
import com.aorez.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
//第一次只在controller上用注解，用注解要加组件扫描
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping(value = "/save", produces = "application/json;charset=utf-8")
    public String save(Role role) {
        //传过来就已经是乱码
        System.out.println(role);
        roleService.save(role);
        return "redirect:/role/list";
    }
}
