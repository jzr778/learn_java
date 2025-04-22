package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override // 目标资源运行前，返回true：放行，返回false，不放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        System.out.println("preHandle...");
        // 1. 获取请求url
        String url = req.getRequestURI().toString();
        log.info("请求的url：{}",url);

        // 2. 判断url中是否包含login，包含则放行
        if(url.contains("login")){
            log.info("登陆操作，放行...");
            // 其实过滤器还需要判断令牌是否为空，为空会直接给前端返回NOT_LOGIN，前端接收到会跳转到登陆页面
            return true;
        }

        // 3. 获取请求头中令牌(token)
        String jwt = req.getHeader("token");

        // 4. 判断令牌是否存在，不存在返回错误结果
        if(!StringUtils.hasLength(jwt)){ // 为null或空串
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }
        // 5. 解析token，如果解析失败，返回错误结果
        try {
            Claims tmp = JwtUtils.parseJWT(jwt);
            log.info("解析令牌为：{}",tmp);
        } catch (Exception e) { // 解析失败
            e.printStackTrace();
            log.info("令牌解析失败，返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }
        // 6. 放行
        log.info("令牌合法，放行");

        return true;

    }

    @Override // 目标资源运行后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override // 视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
