<#import "common.ftl" as c>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>个人信息</title>
    <@c.styles/>
</head>
<body>
<@c.navigation user={}/>
<div class="flex-fluid">
    <div class="layui-card m-4">
        <div class="layui-card-header">个人信息</div>
        <div class="layui-card-body">
            <form class="layui-form layui-form-pane" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" value="${user.username!}" autocomplete="off"
                               placeholder="请输入登陆用户名" lay-verify="required"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密 码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="oldPassword" autocomplete="off"
                               placeholder="请输入旧密码" lay-verify="required"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密 码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="newPassword" autocomplete="off"
                               placeholder="请输入新密码" lay-verify="required"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-submit lay-filter="profile_form">确认更新</button>
                </div>
            </form>
        </div>
    </div>
</div>

<@c.scripts/>
<@c.footer/>
<script src="/app/ajax.js"></script>
<script>
    layui.use(['form', 'Rest'], function () {
        const form = layui.form;
        const layer = layui.layer;
        const Rest = layui.Rest;
        form.on('submit(profile_form)', function (data) {
            const field = data.field;
            Rest.put("/admin/user/update-user",field).then(data=>{
                layer.msg("更新成功")
                window.location.href="/admin/login"
            })
            return false;
        });
    });
</script>
</body>
</html>

