package online.templab.miaoshaweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//TODO:暂不启动RateLimit
//@Configuration
public class RateLimitConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        registry.addInterceptor(new SmoothBurstyInterceptor(100, SmoothBurstyInterceptor.LimitType.DROP)).addPathPatterns("/**");
        //限流可配置为SmoothBurstyInterceptor.LimitType.DROP丢弃请求或者SmoothBurstyInterceptor.LimitType.WAIT等待，100为每秒的速率
    }
}
