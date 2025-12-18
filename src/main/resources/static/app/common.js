/**
 * 通用工具对象
 * @namespace Common
 */
const Common = (function () {
    /**
     * 从当前URL获取指定参数的值
     * @param {string} key - 参数名称
     * @param {string} defaultValue - 参数不存在时的默认值
     * @returns {string} 参数值或默认值
     */
    function getUrlParam(key, defaultValue = '') {
        if (!key) return defaultValue;
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        return (r != null) ? decodeURIComponent(r[2]) : defaultValue;
    }

    return {
        getUrlParam: getUrlParam
    };
})();
