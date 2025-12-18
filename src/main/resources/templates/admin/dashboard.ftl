<#import "common.ftl" as c>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>控制台</title>
    <@c.styles/>
    <link href="/libs/jsoneditor/jsoneditor.min.css" rel="stylesheet">
    <style>
        .jsoneditor {
            color: #1a1a1a;
            border: none !important;
        }
    </style>
</head>
<body>
<@c.navigation user={}/>

<div class="flex-fluid">
    <div id="jsoneditor" style=" height: 80%;margin: 2% 30%;"></div>
</div>
<@c.footer/>
<@c.scripts/>
<script src="/app/ajax.js"></script>
<script src="/libs/jsoneditor/jsoneditor.min.js"></script>
<script>
    layui.use(['Rest'], function () {
        const demo = `
        [
  {
    "date": "2025-2028",
    "multipleEvent": true,
    "summary": "xx公司 - 后端开发",
    "events": [
      {
        "content": "xx平台开发",
        "details": [
          {
            "field": "简介：",
            "content": "内容细节"
          },
          {
            "field": "职责：",
            "content": "负责的工作内容"
          },
          {
            "field": "收获：",
            "content": "学到了什么"
          }
        ]
      },
      {
        "content": "事件2介绍",
        "details": [
          {
            "field": "简介：",
            "content": "支持HTML/CSS标签"
          }
        ]
      }
    ]
  }
]
        `
        const editor = new JSONEditor(document.getElementById("jsoneditor"), {
            mode: 'code',
            mainMenuBar: false
        });
        editor.set(JSON.parse(demo));
    });
</script>
</body>
</html>
