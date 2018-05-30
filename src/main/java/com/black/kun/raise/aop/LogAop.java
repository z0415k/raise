package com.black.kun.raise.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zk
 * 记录日志 接口执行时间，接口参数
 */
@Aspect
@Component
public class LogAop {
    private Logger log = LoggerFactory.getLogger(LogAop.class);

    private ThreadLocal<Long> runTime = new ThreadLocal<>();

    /**
     * 切入点
     * 1）execution(* *(..))
     * 表示匹配所有方法
     * 2）execution(public * com. savage.service.UserService.*(..))
     * 表示匹配com.savage.server.UserService中所有的公有方法
     * 3）execution(* com.savage.server..*.*(..))
     * 表示匹配com.savage.server包及其子包下的所有方法
     */
    @Pointcut("execution(public * com.black.kun.raise.controller..*.*(..))")
    public void webLog() {

    }

    /**
     * 具体切入执行
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        runTime.set(System.currentTimeMillis());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * 最后执行
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
        log.info("SPEND TIME : " + (System.currentTimeMillis() - runTime.get()));
        runTime.remove();
    }
}
