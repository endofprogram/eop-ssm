package org.eop.ssm.config.datasource;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
public class DataSourceProperties {

	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${initialSize}")
	private int initialSize;
	
	@Value("${maxActive}")
	private int maxActive;
	
	@Value("${minIdle}")
	private int minIdle;
	
	@Value("${maxWait}")
	private int maxWait;
	
	@Value("${validationQuery}")
	private String validationQuery;
	
	@Value("${validationQueryTimeout}")
	private int validationQueryTimeout;
	
	@Value("${testOnBorrow}")
	private Boolean testOnBorrow;
	
	@Value("${testOnReturn}")
	private Boolean testOnReturn;
	
	@Value("${testWhileIdle}")
	private Boolean testWhileIdle;
	
	@Value("${poolPreparedStatements}")
	private Boolean poolPreparedStatements;
	
	@Value("${maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	
	@Value("${keepAlive}")
	private Boolean keepAlive;
	
	@Value("${timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	
	@Value("${minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	
	@Value("${filters}")
	private String filters;
	
	@Value("${connectionProperties}")
	private String connectionProperties;

	
	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public int getMaxWait() {
		return maxWait;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public int getValidationQueryTimeout() {
		return validationQueryTimeout;
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

	public Boolean getPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public int getMaxPoolPreparedStatementPerConnectionSize() {
		return maxPoolPreparedStatementPerConnectionSize;
	}

	public Boolean getKeepAlive() {
		return keepAlive;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public String getFilters() {
		return filters;
	}

	public String getConnectionProperties() {
		return connectionProperties;
	}
	
}
