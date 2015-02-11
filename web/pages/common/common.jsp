<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/12/25
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导入共同的JS-->
<% String basePath=new StringBuilder(request.getContextPath()).append("/resources").toString();%>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/uikit.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/autocomplete.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/cover.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/datepicker.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/form-password.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/form-select.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/htmleditor.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/nestable.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/notify.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/pagination.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/search.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/slideshow.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/slideshow-fx.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/sortable.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/sticky.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/timepicker.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/components/upload.min.js"></script>

<!--导入共同的css-->
<link rel="stylesheet" href="<%=basePath%>/css/uikit.min.css"/>
<!--网站共通名字-->
<title>GeekWorld</title>
