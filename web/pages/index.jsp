<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/25
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="common/common.jsp"></jsp:include>
    <script type="text/javascript" src="<%=request.getContextPath()%>/pages/js/index.js"></script>
</head>
<body>
<nav class="uk-navbar">
    <a href="" class="uk-navbar-brand"><i class="uk-icon-paw"></i>&nbsp;Geek-Home</a>
    <div class="uk-navbar-flip">
        <ul class="uk-navbar-nav">
            <li><a class="" href="">首页</a></li>
            <li><a class="" href="">嗨生活</a></li>
            <li><a class="" href="">Geek吧</a></li>
            <li><a class="" href="">小道消息</a></li>
        </ul>
    </div>
</nav>
<div class="uk-container uk-container-center">
    <div class="uk-grid">
        <div class="uk-width-medium-1-1">
            <div class="uk-grid">
                <div class="uk-width-5-6">
                    <form class="uk-form uk-form-horizontal" id="submitUrlContent" method="post">
                        <div class="uk-form-row">
                            <label class="uk-form-label" for="form-h-it">URL</label>
                            <div class="uk-form-controls">
                                <input type="text" name="urlAddress" id="form-h-it" placeholder="输入有效的网址">
                            </div>
                        </div>
                        <input type="submit" name="submitBtn" value="提交"/>
                    </form>
                    <iframe id="showContent">
                        展示内容
                    </iframe>
                </div>
                <div class="uk-width-1-6">
                    jerjgsdmgvorsgvirni
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
