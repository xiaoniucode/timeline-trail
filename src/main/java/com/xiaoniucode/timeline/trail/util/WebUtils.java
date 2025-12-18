package com.xiaoniucode.timeline.trail.util;



import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.Optional;


/**
 * @author liuxin
 */
public abstract class WebUtils {

    /**
     * 获取请求的域名（协议 + 主机 + 端口）
     *
     * @param request HttpServletRequest
     * @return 域名（如 http://example.com:8080）
     */
    public static String getDomain(HttpServletRequest request) {
        // 1. 优先从反向代理头获取（生产环境）
        Optional<String> forwardedDomain = getForwardedDomain(request);
        if (forwardedDomain.isPresent()) {
            return forwardedDomain.get();
        }

        // 2. 从Host头或请求信息获取（直接访问场景）
        String host = Optional.ofNullable(request.getHeader("Host"))
                .orElseGet(() -> request.getServerName() + (request.getServerPort() != 80 && request.getServerPort() != 443 ? ":" + request.getServerPort() : ""));

        if (host != null) {
            String scheme = Optional.ofNullable(request.getHeader("X-Forwarded-Proto"))
                    .orElse(request.getScheme());
            return scheme + "://" + host;
        }

        // 3. 开发环境兜底（本地IP+端口）
        return getDevLocalDomain(request);
    }

    /**
     * 从反向代理头获取域名
     *
     * @param request HttpServletRequest
     * @return 域名（如果存在）
     */
    private static Optional<String> getForwardedDomain(HttpServletRequest request) {
        // 处理标准反向代理头：X-Forwarded-Host + X-Forwarded-Proto
        String forwardedHost = request.getHeader("X-Forwarded-Host");
        if (forwardedHost != null) {
            String proto = Optional.ofNullable(request.getHeader("X-Forwarded-Proto"))
                    .orElse("https");
            return Optional.of(proto + "://" + forwardedHost.split(",")[0].trim());
        }
        return Optional.empty();
    }

    /**
     * 获取开发环境本地域名
     *
     * @param request HttpServletRequest
     * @return 本地域名（如 http://localhost:8080）
     */
    private static String getDevLocalDomain(HttpServletRequest request) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = request.getServerPort();
            return "http://" + ip + (port != 80 && port != 443 ? ":" + port : "");
        } catch (Exception e) {
            return "http://localhost" + (request.getServerPort() != 80 && request.getServerPort() != 443 ? ":" + request.getServerPort() : "");
        }
    }
}
