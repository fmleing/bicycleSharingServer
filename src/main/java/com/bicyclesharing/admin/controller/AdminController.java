package com.bicyclesharing.admin.controller;

import com.bicyclesharing.admin.entity.Admin;
import com.bicyclesharing.admin.service.AdminService;
import com.bicyclesharing.adminmessage.entity.AdminMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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

    /**
     * 1.管理员列表页显示
     *
     * @param requestMap
     * @param page
     * @return
     */
    @RequestMapping(value = "admin-admin-list-show", method = RequestMethod.GET)
    public ModelAndView listShow(Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        //映射
        requestMap.put("nav", "admin-list");
        //获取管理员列表
        ArrayList<Admin> admins = (ArrayList<Admin>) adminService.getAllAdmin();
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
        return new ModelAndView("/admin/list","requestMap",requestMap);
    }

    /**
     * 2.按名(like)搜索管理员或管理员通知显示
     *
     * @param requestMap
     * @param name
     * @return
     */
    @RequestMapping(value = "admin-admin-searchadmin-show", method = RequestMethod.GET)
    public ModelAndView searchAdminShow(Map<String, Object> requestMap, @RequestParam("name") String name) {
        requestMap.put("nav", "admin-list");
        ArrayList<Admin> admins = (ArrayList<Admin>) adminService.getAdminByNameLike(name);
        requestMap.put("pageAdmins", admins);
       return new ModelAndView("/admin/list","requestMap",requestMap);
    }
    @RequestMapping(value="admin-admin-searchmessage-show", method=RequestMethod.GET)
    public ModelAndView searchAdminMessageShow(Map<String, Object> requestMap, @RequestParam("title") String title){
        requestMap.put("nav", "admin-message");
        ArrayList<AdminMessage> adminMessages = (ArrayList<AdminMessage>) adminService.getAdminMessageByTitleLike(title);
        requestMap.put("pageAdminMessages", adminMessages);
        return new ModelAndView("/admin/message","requestMap",requestMap);
    }

    /**
     * 3.管理员通知显示
     *
     * @param requestMap index
     * @param page
     * @return
     */
    @RequestMapping(value = "admin-admin-message-show", method = RequestMethod.GET)
    public ModelAndView messageShow(Map<String, Object> requestMap, @RequestParam("page") Integer page) {
        requestMap.put("nav", "admin-message");
        ArrayList<AdminMessage> adminMessages = (ArrayList<AdminMessage>) adminService.getAllAdminMessage();
        requestMap.put("adminMessages", adminMessages);

        int pageCount = adminMessages.size();  //数据条数
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
        ArrayList<AdminMessage> pageAdminMessages = new ArrayList<>();
        if (pageMax == 1) {
            pageAdminMessages.addAll(adminMessages);
        } else if (pagePointer == pageMax) {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * (pagePointer - 1) + (pageCount % pageSize); ++i) {
                pageAdminMessages.add(adminMessages.get(i));
            }
        } else {
            for (int i = pageSize * (pagePointer - 1); i < pageSize * pagePointer; ++i) {
                pageAdminMessages.add(adminMessages.get(i));
            }
        }
        requestMap.put("pageMax", pageMax);
        requestMap.put("pagePoint", pagePointer);
        requestMap.put("pageAdminMessages", pageAdminMessages);

        return new ModelAndView("/admin/message","requestMap",requestMap);
    }

    /**
     * 4.新增管理员显示
     *
     * @return
     */
    @RequestMapping(value = "admin-admin-register-show", method = RequestMethod.GET)
    public String registerShow() {
        return "/admin/register";
    }

    /**
     * 5.新增管理员
     *
     * @param name
     * @param password
     * @param password2
     * @param email
     * @return
     */
    @RequestMapping(value = "admin-admin-register-execute", method = RequestMethod.POST)
    public String registerExecute( @RequestParam("name") String name,
                                   @RequestParam("password") String password, @RequestParam("password2") String password2,
                                   @RequestParam("email") String email) {
        System.out.println(name);
        boolean registerSuccess = adminService.addAdmin( name, password, password2, email);
        String view = "redirect:/admin-admin-list-show?page=1";
        if (!registerSuccess) {
            view = "/admin/register";
        }
        return view;
    }

    /**
     * 6.管理员授权
     *
     * @return
     */
    @RequestMapping(value = "admin-admin-password-show", method = RequestMethod.GET)
    public String passwordShow() {
        return "/admin/password";
    }

    /**
     * 7.管理员授权处理
     *
     * @param requestMap
     * @param session
     * @param password
     * @return
     */
    @RequestMapping(value = "admin-admin-password-execute", method = RequestMethod.POST)
    public String passwordExecute(Map<String, Object> requestMap, HttpSession session,
                                  @RequestParam String password) {
        if ("huija".equals(password)) {
            session.setAttribute("advanced", 1);
        }
        return "redirect:/admin-admin-list-show?page=1";
    }

    /**
     * 8.删除管理员执行
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-admin-removeadmin-execute/{id}", method = RequestMethod.GET)
    public String removeAdminExecute(@PathVariable Integer id) {
        adminService.removeAdmin(id);
        return "redirect:/admin-admin-list-show?page=1";
    }

    /**
     * 9.修改管理员信息显示
     *
     * @param requestMap
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-admin-editadmin-show/{id}", method = RequestMethod.GET)
    public ModelAndView editAdminShow(Map<String, Object> requestMap, @PathVariable Integer id) {
        Admin admin = adminService.getAdminById(id);
        requestMap.put("admin", admin);
        return new ModelAndView("admin/list","requestMap",requestMap);
    }

    /**
     * 10.修改管理员信息
     *
     * @param id
     * @param name
     * @param password
     * @param email
     * @return
     */
    @RequestMapping(value = "admin-admin-editadmin-execute", method = RequestMethod.POST)
    public String editAdminExecute(@RequestParam("id") Integer id,
                                   @RequestParam("name") String name, @RequestParam("password") String password,
                                   @RequestParam("email") String email) {
        boolean editSuccess = adminService.editAdmin(id, name, password, email);
        String view = "redirect:/admin-admin-list-show?page=1";
        if (!editSuccess) {
            view = "redirect:/admin-admin-editadmin-show/" + id;
        }
        return view;
    }

    /**
     * 11.添加管理员通知显示
     *
     * @return
     */
    @RequestMapping(value = "admin-admin-addadminmessage-show", method = RequestMethod.GET)
    public String addAdminMessageShow() {
        return "admin/message-add";
    }

    /**
     * 12.添加管理员通知
     *
     * @param title
     * @param content
     * @param adminId
     * @return
     */
    @RequestMapping(value = "admin-admin-addadminmessage-execute", method = RequestMethod.POST)
    public String addAdminMessageExecute( @RequestParam("title") String title,
                                          @RequestParam("content") String content, @RequestParam("adminId") Integer adminId) {
        String view = "redirect:/admin-admin-message-show?page=1";
        boolean addSuccess = adminService.addAdminMessage( title, content, adminId);
        if (!addSuccess) {
            view = "/admin/message-add";
        }
        return view;
    }

    /**
     * 13.更改管理员通知显示
     *
     * @param requestMap
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-admin-editadminmessage-show/{id}", method = RequestMethod.GET)
    public ModelAndView showAdminMessageEdit(Map<String, Object> requestMap, @PathVariable("id") Integer id) {
        AdminMessage adminMessage = adminService.getAdminMessageById(id);
        requestMap.put("adminMessage", adminMessage);
        return new ModelAndView("/admin/message-edit","requestMap",requestMap);
    }

    /**
     * 14.更改管理员通知
     *
     * @param title
     * @param content
     * @param adminMessageId
     * @return
     */
    @RequestMapping(value = "admin-admin-editadminmessage-execute", method = RequestMethod.POST)
    public String editAdminMessageExecute(@RequestParam("title") String title,
                                          @RequestParam("content") String content, @RequestParam("adminMessageId") Integer adminMessageId) {
        String view = "redirect:/admin-admin-message-show?page=1";
        boolean editSuccess = adminService.editAdminMessage(adminMessageId, title, content);
        if (!editSuccess) {
            view = "/admin/message-edit";
        }
        return view;
    }

    /**
     * 15.删除管理员通知
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "admin-admin-removeadminmessage-execute/{id}", method = RequestMethod.GET)
    public String removeAdminMessageExecute(@PathVariable Integer id) {
        adminService.removeAdminMessage(id);
        return "redirect:/admin-admin-message-show?page=1";
    }
}