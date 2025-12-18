layui.use(['form', 'jquery', 'Rest'], function () {
    $("#page-template").html();
    var languageMap = {
        zh: $("#hd .language li[data-language='zh']"),
        en: $("#hd .language li[data-language='en']")
    }
    var currentLanguage = "zh"
    var $body = $("body");

    detectLanguage();
    switchLanguage(currentLanguage);
    initPopover();
    function detectLanguage() {
        var search = window.location.search;
        var query;
        if (search === '') {
            return;
        }
        query = search.substr(1).split('&');
        query.forEach(function (item) {
            var pair = item.split('=');
            if (pair[0] === 'lang' && typeof pair[1] !== 'undefined') {
                currentLanguage = pair[1];
            }
        });
    }

    //切换语言环境
    function switchLanguage(language) {
        $body.fadeOut(function () {
            $body.fadeIn(function () {
                $("#bd .avatar").css("z-index", "101");
            });
        });
        //激活语言
        languageMap[currentLanguage].removeClass("active");
        languageMap[language].addClass("active");

        $body[0].className = language;
        currentLanguage = language;

    }

    //初始化弹出框
    function initPopover() {
        $(".milestones ul li .content").each(function () {
            const $this = $(this), $li = $this.parent(), details = $this.next(".details").html();

            $li.attr("data-original-title", $this.html());

            if (!!details) {
                $li.attr("data-content", details);
            }
        });

        $(".milestones ul li").popover({
            placement: "bottom",
            trigger: "manual",
            html: true
        });
        $.fn.popover.Constructor.prototype.getTitle = function() {
            var title
                , $e = this.$element
                , o = this.options;

            title = $e.attr('data-original-title')
                || (typeof o.title == 'function' ? o.title.call($e[0]) : o.title);

            return title || '';
        }

        $.fn.popover.Constructor.prototype.getContent = function() {
            var content
                , $e = this.$element
                , o = this.options;

            content = $e.attr('data-content')
                || (typeof o.content == 'function' ? o.content.call($e[0]) : o.content);

            return content || '';
        }
        $.fn.popover.Constructor.prototype.setContent = function() {
            var $tip = this.tip();

            $tip.find('.popover-title').html(this.getTitle());

            var content = this.getContent();
            if (content) {
                $tip.find('.popover-content > *').html(content);
            } else {
                $tip.find('.popover-content > *').html('');
            }

            $tip.removeClass('fade top bottom left right in');
        }

        // 添加鼠标事件处理
        $(".milestones ul li").on("mouseenter", function(e) {
            var $this = $(this);

            if ($this.data("hideTimeout")) {
                clearTimeout($this.data("hideTimeout"));
                $this.removeData("hideTimeout");
            }

            $this.popover("show");

            var popover = $this.data("popover");
            if (popover && popover.$tip) {
                var $popover = popover.$tip;

                $popover.off("mouseenter").on("mouseenter", function() {
                    clearTimeout($this.data("hideTimeout"));
                });

                $popover.off("mouseleave").on("mouseleave", function() {
                    var hideTimeout = setTimeout(function() {
                        $this.popover("hide");
                    }, 100);
                    $this.data("hideTimeout", hideTimeout);
                });
            }
        }).on("mouseleave", function(e) {
            var $this = $(this);
            var popover = $this.data("popover");

            if (popover && popover.$tip) {
                var $popover = popover.$tip;
                var toElement = e.toElement || e.relatedTarget;
                if ($popover.is(toElement) || $popover.has(toElement).length > 0) {
                    return;
                }
            }
            var hideTimeout = setTimeout(function() {
                $this.popover("hide");
            }, 100);
            $this.data("hideTimeout", hideTimeout);
        });

        var originalPopoverShow = $.fn.popover.Constructor.prototype.show;
        $.fn.popover.Constructor.prototype.show = function() {
            var result = originalPopoverShow.apply(this, arguments);
            if (this.$tip) {
                this.$tip.off("mouseenter mouseleave");
            }
            return result;
        };
    }

    //点击切换语言
    $("#hd .language").click(function (e) {
        var $languageDom = $(e.target)
            , language = $languageDom.attr("data-language");
        if (!language || currentLanguage === language) {
            return;
        }
        switchLanguage(language);
        window.location.href="/?lang="+language
    });
});
