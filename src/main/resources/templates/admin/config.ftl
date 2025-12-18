<#import "common.ftl" as c>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>站点配置</title>
    <@c.styles/>
</head>
<body>
<@c.navigation/>
<div class="flex-fluid  mt-4" style="text-align: center;margin: 0 30%">
    <form class="layui-form layui-form-pane" action="">
        <input type="hidden" name="id" value="${config.id!''}">
        <!-- 头像隐藏字段 -->
        <input type="hidden" name="avatar" id="avatar_url" value="${config.avatar!'/images/avatar.svg'}">

        <!-- 背景隐藏字段 -->
        <input type="hidden" name="background" id="background_url" value="${config.background!'/images/bg.png'}">

        <!-- favicon隐藏字段 -->
        <input type="hidden" name="favicon" id="favicon_url" value="${config.favicon!'/images/avatar.svg'}">
        <div class="layui-form-item">
            <label class="layui-form-label">网站头像</label>
            <div class="layui-input-block">
                <div style="width: 132px;" id="upload-avatar">
                    <div class="layui-upload-list">
                        <img  src="${config.avatar!'/images/avatar.svg'}" class="layui-upload-img" id="site_avatar" style="width: 100%; height: 92px;">
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">网站背景</label>
            <div class="layui-input-block">
                <div style="width: 132px;" id="upload-background">
                    <div class="layui-upload-list">
                        <img src="${config.background!'/images/bg.png'}" class="layui-upload-img" id="site_background" style="width: 100%; height: 92px;">
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">favicon</label>
            <div class="layui-input-block">
                <div style="width: 132px;" id="upload-favicon">
                    <div class="layui-upload-list">
                        <img src="${config.favicon!'/images/avatar.svg'}" class="layui-upload-img" id="site_favicon" style="width: 100%; height: 92px;">
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">作者名字</label>
            <div class="layui-input-block">
                <input type="text" name="author" value="${config.author!''}" autocomplete="off" placeholder="用于网站首页展示"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">网站标题</label>
            <div class="layui-input-block">
                <input type="text" name="title" value="${config.title!''}" autocomplete="off" placeholder="SEO标签"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">网站描述</label>
            <div class="layui-input-block">
                <input type="text" name="description" value="${config.description!''}" autocomplete="off" placeholder="SEO标签"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">关键字</label>
            <div class="layui-input-block">
                <input type="text" name="keywords" value="${config.keywords!''}" autocomplete="off" placeholder="SEO标签"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">爬虫协议</label>
            <div class="layui-input-block">
                <input type="text" name="robots" value="${config.robots!''}" autocomplete="off" placeholder="如：index, follow"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">版权信息</label>
            <div class="layui-input-block">
                <input type="text" name="copyright" value="${config.copyright!''}" autocomplete="off" placeholder="页面底部展示"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <button class="layui-btn" lay-submit lay-filter="config_form">保存</button>
        </div>
    </form>
</div>
<@c.scripts/>
<@c.footer/>
<script src="/app/ajax.js"></script>
<script>
    layui.use(['form', 'upload', 'Rest'], function () {
        var form = layui.form;
        const upload = layui.upload;
        const layer = layui.layer;
        const Rest = layui.Rest;
        const $ = layui.$;

        // 为三个图片分别设置上传
        uploadAvatar('avatar', 'site_avatar', '头像');
        uploadAvatar('background', 'site_background', '背景');
        uploadAvatar('favicon', 'site_favicon', 'favicon');

        function uploadAvatar(fieldName, imgId, label) {
            upload.render({
                elem: '#upload-' + fieldName,
                url: '/admin/file/upload', // 统一上传接口
                data: { type: fieldName }, // 可以传递类型参数
                before: function (obj) {
                    const loadIndex = layer.msg(label + '上传中...', {icon: 16, time: 0});
                    $(this.elem).data('loadIndex', loadIndex);
                },
                done: function (res) {
                    const loadIndex = $(this.elem).data('loadIndex');
                    if (loadIndex) layer.close(loadIndex);
                    if (res.code === 0) {
                        // 更新图片显示
                        $('#' + imgId).attr('src', res.data);
                        // 更新隐藏字段的值
                        $('#' + fieldName + '_url').val(res.data);
                        layer.msg(label + '上传成功！', {icon: 1});
                    } else {
                        layer.msg(label + '上传失败: ' + (res.msg || '未知错误'));
                    }
                },
                error: function () {
                    const loadIndex = $(this.elem).data('loadIndex');
                    if (loadIndex) layer.close(loadIndex);
                    layer.msg(label + '上传请求发送失败');
                }
            });
        }
        form.on('submit(config_form)', function (data) {
            var field = data.field;
            Rest.put('/admin/config/update', field).then(res => {
                    layer.msg('保存成功', {icon: 1});
            })
            return false;
        });
    });
</script>
</body>
</html>
