package cn.test.manager.log;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class LogAspect {
	private org.slf4j.Logger log = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(public * cn.test.manager.web..*.*(..))")
	public void logAspect() {
		
	}
	
	@Before("logAspect()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		log.info("URL: " + request.getRequestURL().toString());
		log.info("Method: " + request.getMethod());
		log.info("IP: " + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			log.info("name:{}, value:{}", name, request.getParameter(name));
		}
		
	}
	
	@AfterReturning(returning = "ret", pointcut = "logAspect()")
	public void doAfterReturning(Object ret) throws Throwable{
		log.info("Response : " + ret);
	}

}
