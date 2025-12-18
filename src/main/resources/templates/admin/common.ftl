<#macro navigation user={}>
    <ul class="layui-nav">
        <div class="d-flex justify-content-between">
            <div>
                <li class="layui-nav-item"><a href="/admin/dashboard">控制面板</a></li>
                <li class="layui-nav-item">
                    <a href="/admin/milestone">里程碑</a>
                </li>
                <li class="layui-nav-item">
                    <a href="/admin/social/index">社交账号</a>
                </li>
                <li class="layui-nav-item">
                    <a href="/admin/config">站点配置</a>
                </li>
            </div>
            <div>
                <li class="layui-nav-item">
                    <a href="javascript:;">
<#--                        <img src="" class="layui-nav-img">-->
                       ${loginUser.username!'未知'}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/user/profile">账号信息</a></dd>
                        <hr>
                        <dd style="text-align: center;"><a href="/admin/logout">退出登陆</a></dd>
                    </dl>
                </li>
                <li style="text-align: right" class="layui-nav-item"><a target="_blank" href="/">访问站点</a></li>
            </div>
        </div>
    </ul>
</#macro>

<#macro footer>
    <div class="d-flex layui-footer justify-content-center">
        <span> Powered by <a  target="_blank" href="https://github.com/xiaoniucode">xiaoniucode.</a></span>
    </div>
</#macro>

<#macro styles>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/libs/layui/css/layui.css">
    <link rel="stylesheet" href="/app/admin/css/global.css">
    <link rel="stylesheet" href="/libs/bootstrap/css/grid.css">
</#macro>

<#macro scripts>
    <script src="/libs/jquery/jquery-3.7.1.min.js"></script>
    <script src="/libs/layui/layui.js"></script>
    <script src="/app/common.js"></script>
</#macro>

