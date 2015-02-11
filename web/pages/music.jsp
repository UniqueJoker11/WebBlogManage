<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/30
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="common/common.jsp"%>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/pages/css/music.css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugin/audioplayer/audioplayer.js"></script>
<script>
    $(function(){
        $("#player").autoplayer();
    });

</script>

    </head>
<body>
<div class="uk-grid">
    <div class="uk-width-1-1">
        <nav class="header-nav">
          <a class="header-brand">Geek-Music</a>
            <ul>
                <li><a href="#">发现音乐</a></li>
                <li><a href="#">歌单</a></li>
                <li><a href="#">私藏电台</a></li>
                <li><a href="#">珍贵记忆</a></li>
            </ul>
            <ul class="header-navbar">
                <li><i class="uk-icon-medium uk-icon-bars"></i></li>
            </ul>
        </nav>
    </div>
    <div class="uk-width-1-1">

    </div>
</div>
<div class="uk-grid">
    <div class="uk-width-1-1">
    <audio preload="auto" id="player" controls>
    <source src="<%=request.getContextPath()%>/music/Time After Time.mp3" />
    </audio>
    </div>
</div>
</body>
</html>
