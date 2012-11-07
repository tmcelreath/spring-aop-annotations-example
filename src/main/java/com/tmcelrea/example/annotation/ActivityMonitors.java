package com.tmcelrea.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityMonitors {

	ActivityMonitor[] value() default {};
	
}
