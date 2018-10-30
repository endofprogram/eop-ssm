package org.eop.ssm.web.config.security;

import java.util.Arrays;

import org.eop.ssm.web.config.security.access.decision.CompositeAccessDecisionManager;
import org.eop.ssm.web.config.security.access.decision.RoleAccessDecisionVoter;
import org.eop.ssm.web.config.security.access.decision.UriAccessDecisionVoter;
import org.eop.ssm.web.config.security.login.handler.JsonAuthenticationFailureHandler;
import org.eop.ssm.web.config.security.login.handler.JsonAuthenticationSuccessHandler;
import org.eop.ssm.web.config.security.password.FakePasswordEncoder;
import org.eop.ssm.web.config.security.service.FakeUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new FakeUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new FakePasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.accessDecisionManager(new CompositeAccessDecisionManager(
				Arrays.asList(new RoleAccessDecisionVoter(), new UriAccessDecisionVoter())))
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/example/login")
			.loginProcessingUrl("/example/loginProcess")
			//.successForwardUrl("/example/success")//转发
			//.failureForwardUrl("/example/failure")//转发
			//.defaultSuccessUrl("/example/success")//重定向
			//.failureUrl("/example/failure")//重定向
			.successHandler(new JsonAuthenticationSuccessHandler())
			.failureHandler(new JsonAuthenticationFailureHandler())
			.permitAll()
			.and().logout()
			.logoutUrl("/example/logoutProcess")
			.logoutSuccessUrl("/example/logout")
			//.logoutSuccessHandler(new JsonLogoutSuccessHandler())
			.permitAll()
			.and().exceptionHandling()
			.accessDeniedPage("/example/deny")
			/*.accessDeniedHandler(new JsonAccessDeniedHandler())*/;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.debug(true);
	}
}
