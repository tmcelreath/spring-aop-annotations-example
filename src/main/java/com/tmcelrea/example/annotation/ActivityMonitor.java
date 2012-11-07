package com.tmcelrea.example.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityMonitor {

	public String context() default "";
	public String action() default "";
	public String content() default "";
	
}
