<#import "common.ftl" as c>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>里程碑</title>
    <@c.styles/>
    <link href="/libs/jsoneditor/jsoneditor.min.css" rel="stylesheet">
    <style>
        .jsoneditor  {
            color: #1a1a1a;
            border: none!important;
        }
    </style>
</head>
<body>
<@c.navigation user={}/>

<div class="flex-fluid">
    <div class="layui-row">
        <div class="layui-col-xs6">
            <div>中文:</div>
            <div id="jsoneditor1" style=" height: 78vh;"></div>
        </div>
        <div class="layui-col-xs6">
            <div>英文:</div>
            <div id="jsoneditor2" style=" height: 78vh;"></div>
        </div>
    </div>
    <div class="layui-row" style="margin:10px 0; text-align: center;">
        <button type="button" class="layui-btn" id="saveBtn">保存更新</button>
    </div>
</div>
<@c.footer/>
<@c.scripts/>
<script src="/libs/jsoneditor/jsoneditor.min.js"></script>
<script src="/app/ajax.js"></script>
<script>
    layui.use(['Rest'], function () {
        const Rest = layui.Rest;
        const layer = layui.layer;
        const editor = new JSONEditor(document.getElementById("jsoneditor1"), {
            mode: 'code',
            mainMenuBar: false
        });
        const editor2 = new JSONEditor(document.getElementById("jsoneditor2"), {
            mode: 'code',
            mainMenuBar: false
        });

        Rest.get("/admin/milestone/get").then(data => {
            editor.set(data.zh);
            editor2.set(data.en);
        });

        $('#saveBtn').on('click', function() {
            const zh = JSON.stringify(editor.get());
            const en = JSON.stringify(editor2.get());
            Rest.put('/admin/milestone/update', {zh: zh, en: en}).then(() => {
                layer.msg("更新成功");
            });
        })
    });
</script>
</body>
</html>
