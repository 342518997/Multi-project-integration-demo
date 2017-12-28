package com.github.pengchong.shiro.core;

import org.apache.shiro.web.util.SavedRequest;

import javax.servlet.http.HttpServletRequest;

/**当访问一些需要登录的请求时，自动把请求保存下来
 * <p>User: peng chong
 * <p>Date: 17-12-22
 * <p>Version: 1.0
 */
public class ClientSavedRequest extends SavedRequest {
    private String scheme;
    private String domain;
    private int port;
    private String contextPath;
    private String backUrl;

    public ClientSavedRequest(HttpServletRequest request,String backUrl) {
        super(request);
        this.scheme = request.getScheme();
        this.domain = request.getServerName();
        this.port = request.getServerPort();
        this.backUrl = backUrl;
        this.contextPath = request.getContextPath();
    }

    public String getScheme() {
        return scheme;
    }

    public String getDomain() {
        return domain;
    }

    public int getPort() {
        return port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public String getBackUrl() {
        return backUrl;
    }
    public String getRequestUrl() {
        String requestURI = getRequestURI();
        if(backUrl != null) {//1如果从外部传入了successUrl（登录成功之后重定向的地址），且以http://或https://开头那么直接返回（相应的拦截器直接重定向到它即可）
            if(backUrl.toLowerCase().startsWith("http://") || backUrl.toLowerCase().startsWith("https://")) {
                return backUrl;
            } else if(!backUrl.startsWith(contextPath)) {//2如果successUrl有值但没有上下文，拼上上下文
                requestURI = contextPath + backUrl;
            } else {//3否则，如果successUrl有值，直接赋值给requestUrl即可；
                requestURI = backUrl;
            }
        }

        StringBuilder requestUrl = new StringBuilder(scheme);//4否则，如果successUrl没值，那么requestUrl就是当前请求的地址；
        requestUrl.append("://");
        requestUrl.append(domain);//5拼上url前边的schema，如http或https
        //6拼上域名
        if("http".equalsIgnoreCase(scheme) && port != 80) {
            requestUrl.append(":").append(String.valueOf(port));
        } else if("https".equalsIgnoreCase(scheme) && port != 443) {
            requestUrl.append(":").append(String.valueOf(port));
        }
        //7拼上重定向到的地址
        requestUrl.append(requestURI);
        //8如果successUrl没值，且有查询参数，拼上
        if (backUrl == null && getQueryString() != null) {
            requestUrl.append("?").append(getQueryString());
        }
        return requestUrl.toString();
    }
}
