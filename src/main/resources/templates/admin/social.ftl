<#import "common.ftl" as c>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>文章管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <@c.styles/>
</head>
<body>
<@c.navigation user={}/>
<div class="flex-fluid  mt-4" style="text-align: center;margin: 0 30%">
    <form class="layui-form layui-form-pane" action="">
        <input type="hidden" name="id" value="${social.id!''}">
        <div class="layui-form-item">
            <label class="layui-form-label">GitHub</label>
            <div class="layui-input-block">
                <input value="${social.github!''}" type="text" name="github" autocomplete="off" placeholder="输入链接，不填则不展示"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Gitee</label>
            <div class="layui-input-block">
                <input type="text" name="gitee" value="${social.gitee!''}" autocomplete="off" placeholder="输入链接，不填则不展示"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">Twitter(X)</label>
            <div class="layui-input-block">
                <input type="text" name="twitter" value="${social.twitter!''}" autocomplete="off" placeholder="输入链接，不填则不展示"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">Weibo</label>
            <div class="layui-input-block">
                <input type="text" name="weibo" value="${social.weibo!''}" autocomplete="off" placeholder="输入链接，不填则不展示"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">Site</label>
            <div class="layui-input-block">
                <input type="text" name="site" value="${social.site!''}" autocomplete="off" placeholder="输入链接，不填则不展示"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">Presume</label>
            <div class="layui-input-block">
                <input type="text" name="presume" value="${social.presume!''}" autocomplete="off" placeholder="输入链接，不填则不展示"
                       class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">Email</label>
            <div class="layui-input-block">
                <input type="text" name="email" value="${social.email!''}" autocomplete="off" placeholder="输入链接，不填则不展示"
                       class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <button class="layui-btn" lay-submit lay-filter="social_form">保存</button>
        </div>
    </form>
</div>
<@c.scripts/>
<@c.footer/>
<script src="/app/ajax.js"></script>
<script>
    layui.use(['form', 'Rest'], function () {
        var form = layui.form;
        var layer = layui.layer;
        const Rest = layui.Rest;
        form.on('submit(social_form)', function (data) {
            var field = data.field;
            Rest.put('/admin/social/update', field).then(res => {
                layer.msg('success')
            })
            return false;
        });
    });
</script>
</body>
