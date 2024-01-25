package com.example.hr.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.example.hr.common.filter.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	//bean이 만들어져야 된다면 @Bean 메서드를 통해서 함
	//<bean id="empService" class="com.example.myapp.hr.EmpService"/>이전 xml 문서에서는 이렇게 했었는데
	//<constructor-arg ref="empRepository"/>
	
//	@Bean
//	public IEmpService empService() {
//		return new EmpService(empRepository);//EmpService에는 생성자가 있어야 함
//	}
	
//	@Bean
//	public IEmpRepository empRepository() {
//		return new EmpRepository;
//	}
	
//	Controller, Service, Repository >> 의존성 주입을 어노테이션
//	나머지는 여기서 빈태그로 >> 인터셉터, 포맷팅, 스프링 시큐리티 등 >> 일관성 있다.
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.KOREAN);
		return slr;
		//위치가 바뀌면 언어, 통화 기호, 소수점이나 콤마 표기법 등이 바뀜 >> locale에 따라 달라짐
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("i18n/message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;//언어별로 공통된 키를 넣어놓고 locale이 바뀔 때마다 그 키에 대한 value를 바꾸면 쉽게 국제화가 가능하다.
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();//인터셉터 객체를 만들어서 반환
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
//		registry.addInterceptor(loginInterceptor())
//				.addPathPatterns("/file/**")
//				.addPathPatterns("/board/write/**")
//				.addPathPatterns("/board/update/**")
//				.addPathPatterns("/board/reply/**")
//				.addPathPatterns("/board/delete/**");//인터셉터 지정할 uri 지정 >> 해당 경로는 로그인 사용자만 볼 수 있도록
	}

}
