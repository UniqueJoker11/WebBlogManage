<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/26
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="common/common.jsp"></jsp:include>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/css/login.css"/>
</head>
<body>
<div class="uk-grid">
    <div class="uk-width-1-1">
       <div class="nav-header">

       </div>
    </div>
    <div class="uk-width-1-1">
        <div class="uk-grid">
            <div class="uk-width-1-2 colin-left-nav">

            </div>
            <div class="uk-width-1-2">
                <ul class="uk-tab colin-login-tabs" data-uk-tab data-uk-switcher="{connect:'#loginComponent',animation: 'fade'}">
                    <li class="uk-active"><a href="">登陆|LOGIN</a></li>
                    <li><a href="">注册|REGISTER</a></li>
                </ul>
                <ul id="loginComponent" class="uk-switcher">
                    <li>
                        <form id="userLoginForm" class="uk-form uk-form-horizontal colin-login-form" method="post" action="musicManage/indexLogin.html">
                            <div class="uk-form-row">
                                <label class="uk-form-label" for="loginUsername">用户名|USERNAME</label>
                                <div class="uk-form-controls">
                                    <input type="text" name="loginUsername" id="loginUsername" class="uk-width-4-6 uk-form-large" placeholder="请输入登陆用户名">
                                </div>
                            </div>
                            <div class="uk-form-row">
                                <label class="uk-form-label" for="loginPasswrod">密码|PASSWORD</label>
                                <div class="uk-form-controls">
                                    <input type="password"  class="uk-width-4-6 uk-form-large" name="loginPasswrod" id="loginPasswrod" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="uk-form-row colin-form-btn">
                                <button class="uk-button uk-button-primary uk-button-large" type="submit"><i class="uk-icon-users"></i>&nbsp;&nbsp;登录|LOGIN</button>
                                <button class="uk-button uk-button-danger uk-button-large" type="reset"><i class="uk-icon-undo"></i>&nbsp;&nbsp;重置|RESET</button>
                            </div>
                        </form>
                    </li>
                    <li>
                        <form  id="userRegisterForm" class="uk-form uk-form-horizontal  colin-login-form" method="post" action="musicManage/userRegister.html">
                            <div class="uk-form-row">
                                <label class="uk-form-label" for="registerUsername">*用户名|USERNAME</label>
                                <div class="uk-form-controls">
                                    <input type="text" class="uk-width-4-6 uk-form-large" name="registerUsername" id="registerUsername" placeholder="请输入登陆用户名">
                                </div>
                            </div>

                            <div class="uk-form-row">
                                <label class="uk-form-label" for="registerPassword">*密码|PASSWORD</label>
                                <div class="uk-form-controls">
                                    <input type="password" class="uk-width-4-6 uk-form-large" name="registerPassword" id="registerPassword" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="uk-form-row">
                                <label class="uk-form-label" for="confirmPassword">*确认密码|PASSWORD</label>
                                <div class="uk-form-controls">
                                    <input type="password" class="uk-width-4-6 uk-form-large" name="confirmPassword" id="confirmPassword" placeholder="请输入确认密码">
                                </div>
                            </div>
                            <div class="uk-form-row">
                                <label class="uk-form-label" for="registerEmail">*邮箱|EMAIL</label>
                                <div class="uk-form-controls">
                                    <input type="text"  class="uk-width-4-6 uk-form-large" id="registerEmail" placeholder="请输入邮箱">
                                </div>
                            </div>
                            <div class="uk-form-row colin-form-btn">
                                <button class="uk-button uk-button-primary uk-button-large" type="submit"><i class="uk-icon-users"></i>&nbsp;&nbsp;注册|REGISTER</button>&nbsp;&nbsp;
                                <button class="uk-button uk-button-danger uk-button-large" type="reset"><i class="uk-icon-undo"></i>&nbsp;&nbsp;重置|RESET</button>
                            </div>
                        </form>
                    </li>
                </ul>
            </div>
        </div>

    </div>
    <%--<div class="uk-width-1-1">
        <div class="uk-grid">
            <div class="uk-width-5-6">

            </div>
            <div class="uk-width-1-6">

            </div>
        </div>
    </div>--%>
</div>
</body>
</html>
