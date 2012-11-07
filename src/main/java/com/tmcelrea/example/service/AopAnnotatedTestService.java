package com.tmcelrea.example.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.tmcelrea.example.annotation.ActivityMonitor;
import com.tmcelrea.example.annotation.ActivityMonitors;

@Service
public class AopAnnotatedTestService implements TestService {

	Log log = LogFactory.getLog(AopAnnotatedTestService.class);
	
	@ActivityMonitor(action="singleAction", context="singleContext", content="singleContent")
	public void singleAnnotationMethod() {
		log.info("IN singleAnnotationMethod()");
	}
	
	@ActivityMonitors( {
		@ActivityMonitor(action="multipltAction1", context="multipleContext1", content="multipleContent1"),
		@ActivityMonitor(action="multipltAction2", context="multipleContext2", content="multipleContent2")
		}
	)
	public void multipleAnnotationMethod() {
		log.info("IN multipleAnnotationMethod()");
	}
	
	
}
