package org.eop.ssm.config.dubbo;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lixinjie
 * @since 2018-08-16
 */
public class DubboProperties {

	@Value("${application.name}")
	private String applicationName;
	
	@Value("${registry.protocol}")
	private String registryProtocol;
	
	@Value("${registry.address}")
	private String registryAddress;
	
	@Value("${registry.port}")
	private Integer registryPort;
	
	@Value("${protocol.name}")
	private String protocolName;
	
	@Value("${protocol.port}")
	private Integer protocolPort;
	
	@Value("${provider.timeout}")
	private Integer providerTimeout;
	
	@Value("${consumer.timeout}")
	private Integer consumerTimeout;

	
	public String getApplicationName() {
		return applicationName;
	}

	public String getRegistryProtocol() {
		return registryProtocol;
	}

	public String getRegistryAddress() {
		return registryAddress;
	}

	public Integer getRegistryPort() {
		return registryPort;
	}

	public String getProtocolName() {
		return protocolName;
	}

	public Integer getProtocolPort() {
		return protocolPort;
	}

	public Integer getProviderTimeout() {
		return providerTimeout;
	}

	public Integer getConsumerTimeout() {
		return consumerTimeout;
	}
}
