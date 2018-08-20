package com.hopetop.cole.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.hopetop.cole.common.annotation.IgnoreToken;
import com.hopetop.cole.token.api.TokenService;
import com.hopetop.cole.token.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
public class AuthInterceptor implements HandlerInterceptor {

    private final static String ACCESS_TOKEN = "token";

    @Value("${server.token-on:false}")
    private boolean onToken;

    @Autowired
    private TokenService tokenService;

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果全局token没有开启直接放行
        if (!onToken) {
            return true;
        }
//        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        final Class<?> clazz = method.getDeclaringClass();
        // 判断接口是否需要登录
        //IgnoreToken methodAnnotation = method.getAnnotation(IgnoreToken.class);
        boolean hasClassAnnotation = clazz.isAnnotationPresent(IgnoreToken.class);
        boolean hasMethodAnnotation = method.isAnnotationPresent(IgnoreToken.class);
        // 加了@IgnoreToken注解，不需要认证，否则需要认证
        if (hasMethodAnnotation || hasClassAnnotation) {
            return true;
        }
        //从参数获取，优先request，然后header
        String token = request.getParameter(ACCESS_TOKEN);
        if (token == null || token.isEmpty()) {
            token = request.getHeader(ACCESS_TOKEN);
        }

//        if (token == null || token.isEmpty()) {
//            throw new AuthFailException();
//        }
        return tokenValid(response, token);
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * token验证
     *
     * @param  response response
     * @param  token    token
     * @return boolean
     */
    private boolean tokenValid(HttpServletResponse response, String token) throws Exception{
        JSONObject jsonObject = tokenService.checkToken(token);
        if (!jsonObject.getBoolean(Constants.SUCCESS)) {
            response.setHeader("content-type", "application/json;charset=UTF-8");
            response.setStatus(401);
            ServletOutputStream out;
            out = response.getOutputStream();
            String outMsg = jsonObject.toString();
            out.write(outMsg.getBytes("utf-8"));
            out.flush();
            return false;
        }
        return true;
    }
}
