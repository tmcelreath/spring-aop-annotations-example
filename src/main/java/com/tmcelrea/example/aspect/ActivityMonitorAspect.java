package com.tmcelrea.example.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.tmcelrea.example.annotation.ActivityMonitor;
import com.tmcelrea.example.annotation.ActivityMonitors;

@Component
@Aspect
public class ActivityMonitorAspect {

	Log log = LogFactory.getLog(ActivityMonitorAspect.class);
	
	@After("execution(* *.*(..)) && @annotation(activityMonitor) ")
	public void logActivityMonitor(JoinPoint joinPoint, ActivityMonitor activityMonitor) {
		logActivity(activityMonitor, joinPoint);
	}
	
	@After("execution(* *.*(..)) && @annotation(activityMonitors) ")
	public void logActivityMonitors(JoinPoint joinPoint, ActivityMonitors activityMonitors) {
		for(ActivityMonitor activityMonitor: activityMonitors.value()) {
			logActivity(activityMonitor, joinPoint);
		}
	}
	
	private void logActivity(ActivityMonitor activity, JoinPoint joinPoint) {
		log.info("ACTIVITY FOR " + joinPoint.getClass().getName() + ": " + activity.context()+"|"+activity.action()+"|"+activity.content());
	}
	
}
