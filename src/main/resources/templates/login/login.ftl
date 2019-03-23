<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>卖家登录</title>
    <style>
        /* 让页面所有元素的padding和margin都设置为0 */
        *{margin:0;padding:0;box-sizing:border-box;}
        /* 设置背景图，字体设置为微软雅黑 */
        body{background:url(../../static/picture/a.jpg);font-family: "微软雅黑", sans-serif;}
        /* 整个登录框的css，并使用绝对定位居中 */
        .login {
            position: absolute;
            top: 50%;
            left: 50%;
            margin: -150px 0 0 -150px;
            width:300px;
            height:300px;
        }
        /* 前面分析过的h1标签的css，text-shadow设置阴影使文字更好看，letter-spacing设置字符间距 */
        .login h1 { color:#555555; text-shadow: 0px 10px 8px #CDC673; letter-spacing:2px;text-align:center;margin-bottom:20px; }
        /* 两个输入框的css，border属性设置边框线粗细以及颜色，border-radius设置边框的圆角角度 */
        input{
            padding:10px;
            width:100%;
            color:white;
            margin-bottom:10px;
            background-color:#555555;
            border: 1px solid black;
            border-radius:4px;
            letter-spacing:2px;
        }
        /* 登录按钮的css，cursor:pointer当鼠标移到按钮上面时变成小手形状 */
        form button{
            width:100%;
            padding:10px;
            background-color:#CDC673;
            border:1px solid black;
            border-radius:4px;
            cursor:pointer;
        }
    </style>
</head>
<body>
<div class="headtop"></div>
<div class="login">
    <h1>Login</h1>
    <form role="form" method="post" action="/sell/seller/login">
        <div class="form-group">
        <input type="text" name="username" placeholder="用户名" required="required" value="${username!""}">
        </div>
        <div class="form-group">
        <input type="password" name="password" placeholder="密  码" required="required" value="${password!""}">
        </div>
        <button type="submit">登录</button>
    </form>
</div>
</body>
</html>
