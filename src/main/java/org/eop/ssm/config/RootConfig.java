package org.eop.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
@Configuration
@ComponentScan(basePackages = {"org.eop.ssm.config.*", "org.eop.ssm.**.service"})
public class RootConfig {

}
