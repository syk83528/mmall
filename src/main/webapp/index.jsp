<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>首页</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap-theme.css">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <!--<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>-->
    <!--<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>-->
    <%--<![endif]-->--%>
    <style type="text/less" >
        .container-fluid {
            text-align: center;
            .row {
                margin: 0 auto;
                label {
                    width: 60px;
                }
            }
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <h1>你好，世界！</h1>
    <div class="row input-group">
            <input type="text" class="form-control" placeholder="请输入用户名" aria-describedby="basic-addon2">
    </div>
    <div class="row input-group">
        <input type="password" class="form-control" placeholder="请输入密码" aria-describedby="basic-addon2">
    </div>
    <div class="col-xs-12">
        <button class="btn btn-success">提交</button>
    </div>
</div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="js/less.min.js"></script>
</body>
</html>