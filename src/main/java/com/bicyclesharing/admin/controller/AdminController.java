package com.bicyclesharing.admin.controller;

import com.bicyclesharing.admin.entity.Admin;
import com.bicyclesharing.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

/**
 * admin 后端控制
 * Created by Tomecs on 2017/10/21.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView test(Map<String, Object> requestMap, @RequestParam(value = "page",required = false,defaultValue="1") Integer page) {
        //映射
        requestMap.put("nav", "admin-list");
        //获取管理员列表
        ArrayList<Admin> admins = (ArrayList<Admin>)adminService.getAllAdmin();
        requestMap.put("admins", admins);
        int pageCount = admins.size();  //数据条数
        int pageSize = 10;  //分页条数
        int pageMax = pageCount / pageSize;  //最大页数
        int pagePointer = 1;  //当前指向页
        if (pageMax != 0 && pageCount % pageSize != 0) {
            ++pageMax;
        }
        if (pageMax == 0) {
            pageMax = 1;
        }
        if (page < 1 || page > pageMax) {
            pagePointer = 1;
        } else {
            pagePointer = page;
        }
        ArrayList<Admin> pageAdmins = new ArrayList<>();
        if (pageMax == 1) {
            pageAdmins.addAll(admins);
        } else if (pagePointer == pageMax) {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * (pagePointer - 1) + (pageCount % pageSize); ++i) {
                pageAdmins.add(admins.get(i));
            }
        } else {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * pagePointer; ++i) {
                pageAdmins.add(admins.get(i));
            }
        }
        requestMap.put("pageMax", pageMax);
        requestMap.put("pagePoint", pagePointer);
        requestMap.put("pageAdmins", pageAdmins);
        return new ModelAndView("/admin/list",requestMap);
    }

}

