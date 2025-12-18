<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta property="wb:webmaster" content="db254371b9c24d32"/>
    <title>${config.title!''}</title>
    <link rel="stylesheet" href="libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="app/site/css/index.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="${config.description!''}">
    <meta name="keywords" content="${config.keywords!''}">
    <meta name="author" content="${config.author!''}">
    <meta name="robots" content="${config.robots!''}">
    <#if config.favicon?? && config.favicon != ''>
        <link rel="icon" href="${config.favicon!''}" type="image/x-icon">
        <link rel="shortcut icon" href="${config.favicon!''}" type="image/x-icon">
    <#else>

    </#if>
    <style>
        html, body {
            background: transparent url("${config.background!'images/bg.png'}") repeat 0 0;
        }
    </style>
</head>
<body class="hide">
<div id="page">
    <header id="hd">
        <ul class="language">
            <li data-language="zh">中文</li>
            <li>|</li>
            <li data-language="en">English</li>
        </ul>
    </header>
    <div id="bd">
        <div id="page-template">
            <article>
                <section class="brief-info">
                    <h1>
                        <b>${config.author!''}</b>
                    </h1>
                    <section class="net-info">
                        <ul>
                            <#if social??>
                                <#if social.weibo?? && social.weibo != ''>
                                    <li>
                                        <a title="weibo" href="${social.weibo}" target="_blank">
                                            <img class="net-img" src="images/weibo.png"/>
                                        </a>
                                    </li>
                                </#if>

                                <#if social.github?? && social.github != ''>
                                    <li>
                                        <a title="GitHub" href="${social.github}" target="_blank">
                                            <img class="net-img" src="images/github.png"/>
                                        </a>
                                    </li>
                                </#if>

                                <#if social.gitee?? && social.gitee != ''>
                                    <li>
                                        <a title="Gitee" href="${social.gitee}" target="_blank">
                                            <img class="net-img" src="images/gitee.png"/>
                                        </a>
                                    </li>
                                </#if>

                                <#if social.twitter?? && social.twitter != ''>
                                    <li>
                                        <a title="twitter" href="${social.twitter}" target="_blank">
                                            <img class="net-img" src="images/twitter.png"/>
                                        </a>
                                    </li>
                                </#if>

                                <#if social.site?? && social.site != ''>
                                    <li>
                                        <a title="site" href="${social.site}" target="_blank">
                                            <img class="net-img" src="images/site.png"/>
                                        </a>
                                    </li>
                                </#if>
                                <#if social.presume?? && social.presume != ''>
                                    <li>
                                        <a title="简历" href="${social.presume}" target="_blank">
                                            <img class="net-img" src="images/presume.png"/>
                                        </a>
                                    </li>
                                </#if>
                                <#if social.email?? && social.email != ''>
                                    <li>
                                        <a title="mail" href="mailto:${social.email}">
                                            <img class="net-img" src="images/mail.png"/>
                                        </a>
                                    </li>
                                </#if>
                            </#if>
                        </ul>
                    </section>
                </section>
                <div class="avatar">
                    <img src="${config.avatar!'images/avatar.svg'}">
                </div>
            </article>
            <article class="dots-wrap">
                <#if milestones??>
                    <#list milestones as milestone>
                        <div class="dots">
                            <span class="dot"></span>
                            <#if milestone.multipleEvent?? && milestone.multipleEvent>
                                <span class="leaves"></span>
                            </#if>
                            <section class="milestones">
                                <section class="title">
                                    <#if milestone.date?? && milestone.date != ''>
                                        <h3 class="date">${milestone.date}</h3>
                                    </#if>
                                    <#if milestone.summary?? && milestone.summary != ''>
                                        <b class="summary">${milestone.summary}</b>
                                    </#if>
                                </section>

                                <#if milestone.events?? && milestone.events?size gt 0>
                                    <ul>
                                        <#list milestone.events as event>
                                            <#if event??>
                                                <li>
                                                    <#if milestone.multipleEvent?? && milestone.multipleEvent>
                                                        <span class="small-dot"></span>
                                                    </#if>
                                                    <#if event.content?? && event.content != ''>
                                                        <span class="content">${event.content}</span>
                                                    </#if>

                                                    <#if event.details?? && event.details?size gt 0>
                                                        <section class="details">
                                                            <ul>
                                                                <#list event.details as detail>
                                                                    <#if detail??>
                                                                        <li>
                                                                            <#if detail.field?? && detail.field != ''>
                                                                                <b>${detail.field}</b>
                                                                            </#if>
                                                                            <#if detail.content?? && detail.content != ''>
                                                                                <span>${detail.content}</span>
                                                                            </#if>
                                                                        </li>
                                                                    </#if>
                                                                </#list>
                                                            </ul>
                                                        </section>
                                                    </#if>
                                                </li>
                                            </#if>
                                        </#list>
                                    </ul>
                                </#if>
                            </section>
                        </div>
                    </#list>
                </#if>
            </article>
        </div>
    </div>
</div>
<footer id="ft">
    <div class="copyright">
        <span>${config.copyright!''}</span>
        <span> Powered by <a target="_blank" href="https://github.com/xiaoniucode">xiaoniucode.</a></span>
    </div>
</footer>
<script src="/libs/jquery/jquery-3.7.1.min.js"></script>
<script src="/libs/layui/layui.js"></script>
<script src="/libs/bootstrap/bootstrap.js"></script>
<script src="/app/ajax.js"></script>
<script src="/app/site/index.js"></script>

</body>
</html>
