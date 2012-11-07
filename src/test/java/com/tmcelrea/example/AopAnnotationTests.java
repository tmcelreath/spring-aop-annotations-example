package com.tmcelrea.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmcelrea.example.service.AopAnnotatedTestService;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AopAnnotationTests {

	@Test
	public void testSingleAnnotation() {
		AopAnnotatedTestService clazz = new AopAnnotatedTestService();
		clazz.singleAnnotationMethod();
	}
	
}
