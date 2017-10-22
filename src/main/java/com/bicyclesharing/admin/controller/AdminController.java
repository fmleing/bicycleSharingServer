package com.bicyclesharing.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * admin 后端控制
 * Created by Tomecs on 2017/10/21.
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping(value = "/list")
    public String test() {
        System.out.println("aaa");
        return "/admin/a";
    }

}
