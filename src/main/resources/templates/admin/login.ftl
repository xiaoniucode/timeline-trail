<#import "common.ftl" as c>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>登录</title>
    <@c.styles/>
    <link rel="stylesheet" href="/app/admin/css/login.css">
</head>
<body>
<div class="flex-fluid">
    <div>
        <form class="layui-form">
            <div class="tinynote-login-container">
                <div class="layui-form-item">
                    <div class="layui-input-wrap " style="text-align: center;font-size: 24px;">
                        登录
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-wrap">
                        <div class="layui-input-prefix">
                            <i class="layui-icon layui-icon-username"></i>
                        </div>
                        <input type="text" name="username" value="" lay-verify="required" placeholder="用户名"
                               lay-reqtext="请填写用户名" autocomplete="off" class="layui-input" lay-affix="clear">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-wrap">
                        <div class="layui-input-prefix">
                            <i class="layui-icon layui-icon-password"></i>
                        </div>
                        <input type="password" name="password" value="" lay-verify="required"
                               placeholder="密   码"
                               lay-reqtext="请填写密码" autocomplete="off" class="layui-input" lay-affix="eye">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="login_form">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<@c.scripts/>
<@c.footer/>
<script src="/app/ajax.js"></script>
<script>
    layui.use(['Rest', 'form'], function () {
        const form = layui.form;
        const Rest = layui.Rest;
        form.on('submit(login_form)', function (data) {
            const formData = data.field;
            Rest.post('/admin/do-login', formData).then(res => {
                window.location.href = '/admin/dashboard';
            })
            return false;
        });
    });
</script>
</body>
</html>
