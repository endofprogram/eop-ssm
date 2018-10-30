package org.eop.ssm.config.httpinvoker;

import org.eop.common.http.invoker.HttpComponentsRestTemplateHttpInvoker;
import org.eop.common.http.invoker.IHttpInvoker;
import org.eop.common.http.invoker.OkHttp3RestTemplateHttpInvoker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
//@Configuration
public class HttpInvokerConfig {

	@Primary
	@Bean
	public IHttpInvoker httpComponentsHttpInvoker() {
		return new HttpComponentsRestTemplateHttpInvoker();
	}
	
	@Bean
	public IHttpInvoker okHttp3HttpInvoker() {
		return new OkHttp3RestTemplateHttpInvoker();
	}
}
