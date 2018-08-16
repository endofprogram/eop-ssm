package org.eop.ssm.config.dubbo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;

/**
 * @author lixinjie
 * @since 2018-08-16
 */
@Configuration
@DubboComponentScan(basePackages = {"org.eop.ssm.**.dubbo.provider", "org.eop.ssm.**.dubbo.consumer"})
@ComponentScan(basePackages = {"org.eop.ssm.**.dubbo.consumer"})
@PropertySource(value = "classpath:dubbo/dubbo.properties", ignoreResourceNotFound = true)
public class DubboConfig {

	@Bean
	public DubboProperties dubboProperties() {
		return new DubboProperties();
	}
	
	@Bean
	public ApplicationConfig applicationConfig(DubboProperties dubboProperties) {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(dubboProperties.getApplicationName());
		return applicationConfig;
	}
	
	@Bean
    public RegistryConfig registryConfig(DubboProperties dubboProperties) {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol(dubboProperties.getRegistryProtocol());
        registryConfig.setAddress(dubboProperties.getRegistryAddress());
        registryConfig.setPort(dubboProperties.getRegistryPort());
        return registryConfig;
	}
	
	@Bean
    public ProtocolConfig protocolConfig(DubboProperties dubboProperties) {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(dubboProperties.getProtocolName());
        protocolConfig.setPort(dubboProperties.getProtocolPort());
        return protocolConfig;
	}
	
	 @Bean
     public ProviderConfig providerConfig(DubboProperties dubboProperties) {
         ProviderConfig providerConfig = new ProviderConfig();
         providerConfig.setTimeout(dubboProperties.getProviderTimeout());
         return providerConfig;
	 }
	 
	 @Bean
     public ConsumerConfig consumerConfig(DubboProperties dubboProperties) {
         ConsumerConfig consumerConfig = new ConsumerConfig();
         consumerConfig.setTimeout(dubboProperties.getConsumerTimeout());
         return consumerConfig;
	 }
	 
	 @Profile("dev")
	 @Configuration
	 @PropertySource(value = "classpath:dubbo/dev/dubbo.properties", ignoreResourceNotFound = true)
	 static class DubboConfigDev {
		 
	 }
	 
	 @Profile("test")
	 @Configuration
	 @PropertySource(value = "classpath:dubbo/test/dubbo.properties", ignoreResourceNotFound = true)
	 static class DubboConfigTest {
		 
	 }
	 
	 @Profile("prod")
	 @Configuration
	 @PropertySource(value = "classpath:dubbo/prod/dubbo.properties", ignoreResourceNotFound = true)
	 static class DubboConfigProd {
		 
	 }
}
