package org.eop.ssm.web.session.initializer;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * 负责添加Session过滤器
 * @author lixinjie
 * @since 2018-08-08
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {

	public SessionInitializer() {
		//调用父类构造函数会导致rootAppContext的初始化
		//且把SessionConfig注册进去，主要是为了
		//应用@EnableRedisHttpSession注解（负责向root容器中注册必要的bean）
		//如果rootAppContext已由其它类初始化（如MVC初始化）
		//则该处无需调用父类构造函数
		//但是SessionConfig还是要注册
		//@EnableRedisHttpSession注解还是要应用
		//所以SessionConfig应该注册在MVC初始化的类里
		//的rootAppContext中而不是servletAppContext中
		//super(SessionConfig.class);
	}
}
