package org.eop.ssm.config.redis;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
public class RedisProperties {

	// node.redis
	@Value("${node.host}")
	private String host;

	@Value("${node.password}")
	private String nodePassword;

	@Value("${node.port}")
	private String port;

	@Value("${node.timeout}")
	private String timeout;
	
	// redis.clients.jedis.JedisCluster
	@Value("${cluster.clusterNodes}")
	private String clusterNodes;
	
	@Value("${cluster.connectionTimeout}")
	private String connectionTimeout;
	
	@Value("${cluster.soTimeout}")
	private String soTimeout;
	
	@Value("${cluster.maxAttempts}")
	private String maxAttempts;
	
	@Value("${cluster.password}")
	private String clusterPassword;

	// org.apache.commons.pool2.impl.BaseObjectPoolConfig
	@Value("${pool.lifo}")
	private Boolean lifo;

	@Value("${pool.fairness}")
	private Boolean fairness;

	@Value("${pool.maxWaitMillis}")
	private Long maxWaitMillis;

	@Value("${pool.minEvictableIdleTimeMillis}")
	private Long minEvictableIdleTimeMillis;

	@Value("${pool.softMinEvictableIdleTimeMillis}")
	private Long softMinEvictableIdleTimeMillis;

	@Value("${pool.numTestsPerEvictionRun}")
	private Integer numTestsPerEvictionRun;

	@Value("${pool.evictionPolicyClassName}")
	private String evictionPolicyClassName;

	@Value("${pool.testOnCreate}")
	private Boolean testOnCreate;

	@Value("${pool.testOnBorrow}")
	private Boolean testOnBorrow;

	@Value("${pool.testOnReturn}")
	private Boolean testOnReturn;

	@Value("${pool.testWhileIdle}")
	private Boolean testWhileIdle;

	@Value("${pool.timeBetweenEvictionRunsMillis}")
	private Long timeBetweenEvictionRunsMillis;

	@Value("${pool.blockWhenExhausted}")
	private Boolean blockWhenExhausted;

	// org.apache.commons.pool2.impl.GenericObjectPoolConfig
	@Value("${pool.maxTotal}")
	private Integer maxTotal;

	@Value("${pool.maxIdle}")
	private Integer maxIdle;

	@Value("${pool.minIdle}")
	private Integer minIdle;

	
	public String getHost() {
		return host;
	}

	public String getNodePassword() {
		return nodePassword;
	}

	public Integer getPort() {
		return Integer.valueOf(port);
	}

	public Integer getTimeout() {
		return Integer.valueOf(timeout);
	}

	public String getClusterNodes() {
		return clusterNodes;
	}

	public Integer getConnectionTimeout() {
		return Integer.valueOf(connectionTimeout);
	}

	public Integer getSoTimeout() {
		return Integer.valueOf(soTimeout);
	}

	public Integer getMaxAttempts() {
		return Integer.valueOf(maxAttempts);
	}

	public String getClusterPassword() {
		return clusterPassword;
	}

	public Boolean getLifo() {
		return lifo;
	}

	public Boolean getFairness() {
		return fairness;
	}

	public Long getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public Long getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public Long getSoftMinEvictableIdleTimeMillis() {
		return softMinEvictableIdleTimeMillis;
	}

	public Integer getNumTestsPerEvictionRun() {
		return numTestsPerEvictionRun;
	}

	public String getEvictionPolicyClassName() {
		return evictionPolicyClassName;
	}

	public Boolean getTestOnCreate() {
		return testOnCreate;
	}

	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}

	public Boolean getTestOnReturn() {
		return testOnReturn;
	}

	public Boolean getTestWhileIdle() {
		return testWhileIdle;
	}

	public Long getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public Boolean getBlockWhenExhausted() {
		return blockWhenExhausted;
	}

	public Integer getMaxTotal() {
		return maxTotal;
	}

	public Integer getMaxIdle() {
		return maxIdle;
	}

	public Integer getMinIdle() {
		return minIdle;
	}
	
}
