package com.lu.common.config;

import com.lu.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    private SysLogService sysLogService;

    ThreadLocal<SysLog> threadLocal = new ThreadLocal<>();

    @Pointcut("@annotation(com.lu.common.config.SysLog)")
    public void logPointCut() {

    }


    @Before("logPointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("====================前置通知开始====================");
        this.work(joinPoint);
    }

    public void work(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = method.getAnnotation(SysLog.class);
        //获取请求Ip
        // String ip = IpAddressUtil.getIpAdrress(request);
        //获取请求URL
        StringBuffer requestURL = request.getRequestURL();
        //请求方法全路径
        String methodPath = joinPoint.getTarget().getClass().getName() + "." + method.getName();
        //获得切点方法参数
        String params = "";
        try {
            Object[] args = joinPoint.getArgs();
            List<Object> list = Arrays.asList(args);
            List<Object> paramsList = new ArrayList<>();
            list.forEach(item -> {
                if (!(item instanceof HttpServletRequest) &&
                        !(item instanceof HttpServletResponse) &&
                        !(item instanceof MultipartFile)) {
                    paramsList.add(item);
                }
            });
            params = JSON.toJSONString(paramsList);
            String headerToken = request.getHeader(Constant.LOGIN_TOKEN);
            String token = headerToken != null ? headerToken : CookieUtils.getCookieValue(request, Constant.LOGIN_TOKEN);
            String clientType = request.getHeader(Constant.CLIENT_TYPE);
            log.info("token:" + token);
            log.info("clientType:" + clientType);
            log.info("方法:" + methodPath);
            log.info("URL:" + requestURL);
            log.info("请求IP:" + ip);
            log.info("参数:" + params);
            if (sysLog != null) {
                String operationName = method.getAnnotation(SysLog.class).value();
                String module = method.getAnnotation(SysLog.class).module();
                int isDB = method.getAnnotation(SysLog.class).dbFlag();
                log.info("日志内容:" + operationName);
                log.info("日志模块:" + module);
                String str = isDB == Constant.DB_USE ? "写入数据库日志" : "不写入数据库日志";
                log.info("isDB:" + str);
                if (isDB == Constant.DB_USE) {
                    SysLogEntity sysLogEntity = new SysLogEntity();
                    sysLogEntity.setOperation(operationName);
                    sysLogEntity.setModule(module);
                    sysLogEntity.setUrl(requestURL.toString());
                    sysLogEntity.setCreateTime(new Date());
                    sysLogEntity.setMethod(methodPath);
                    sysLogEntity.setParams(params);
                    sysLogEntity.setIp(ip);
                    sysLogEntity.setClientType(clientType);
                    // clientType.equals(Constant.CLIENT_WEB)

                    if (StringUtils.isNotEmpty(token)) {
                        BaseUserDTO userEntity = redisService.get(token);
                        if (userEntity != null) {
                            sysLogEntity.setUserId(userEntity.getUserId());
                            sysLogEntity.setOrgId(userEntity.getOrgId());
                            sysLogEntity.setRealName(userEntity.getAccount() + "-" + userEntity.getRealName());
                            log.info("操作人:" + userEntity.getAccount() + "-" + userEntity.getRealName());
                        } else {
                            log.info("无效token");
                        }
                    }
                    sysLogService.save(sysLogEntity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
