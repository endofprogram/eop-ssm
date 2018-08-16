package org.eop.ssm.config.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
@EnableRedisHttpSession
@Configuration
@PropertySource(value = "classpath:session/session.properties", ignoreResourceNotFound = true)
public class SessionConfig {

	//如果要改变Session的策略
	//只需向容器中注册Bean即可
	//Session ID放到header中
	//@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}
	
	@Primary
	@Bean
	public ThreadPoolTaskScheduler taskScheduler() {
		return new ThreadPoolTaskScheduler();
	}
	
	@Profile("dev")
	@Configuration
	@PropertySource(value = "classpath:session/dev/session.properties", ignoreResourceNotFound = true)
	static class SessionConfigDev {
		
	}
	
	@Profile("test")
	@Configuration
	@PropertySource(value = "classpath:session/test/session.properties", ignoreResourceNotFound = true)
	static class SessionConfigTest {
		
	}
	
	@Profile("prod")
	@Configuration
	@PropertySource(value = "classpath:session/prod/session.properties", ignoreResourceNotFound = true)
	static class SessionConfigProd {
		
	}
}
