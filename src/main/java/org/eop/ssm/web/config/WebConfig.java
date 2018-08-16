package org.eop.ssm.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixinjie
 * @since 2018-01-08
 */
@Configuration
@ComponentScan(basePackages = {"org.eop.ssm.web.config.*", "org.eop.ssm.web.exception.handler", "org.eop.ssm.**.controller"})
public class WebConfig {

}
