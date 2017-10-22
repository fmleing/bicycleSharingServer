<%--
  Created by IntelliJ IDEA.
  User: Tomecs
  Date: 2017/10/21
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="/static/js/theme.js"/>
<header>
    <div class="am-fl tpl-header-logo">
        <img src="/static/img/logo/logo.png" style="width:30px; height: 30px; float: left; margin-top:14px; margin-left: 15px;">
        <div style="color: #cfcfcf; line-height: 57px; margin-left:5px; font-weight:bold; float: left;">单车后台管理</div>
    </div>
    <div class="tpl-header-fluid" >
        <div class="am-fl tpl-header-switch-button am-icon-list">
            <span>
            </span>
        </div>
        <div class="am-fr tpl-header-navbar">
            <ul>
                <li class="am-text-sm tpl-header-navbar-welcome">
                    <a href="javascript:;">欢迎你，<span>${sessionScope.admin.adminName}</span></a>
                </li>
                <li>
                    <a href="/admin/logout">
                        <span class="am-icon-sign-out"></span>退出
                    </a>
                </li>
            </ul>
        </div>
    </div>
</header>
