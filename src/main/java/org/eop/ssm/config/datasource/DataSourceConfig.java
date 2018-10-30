package org.eop.ssm.config.datasource;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
//@Configuration
//@PropertySource(value = "classpath:db/db.properties", ignoreResourceNotFound = true)
public class DataSourceConfig {

	@Bean
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(initMethod = "init", destroyMethod = "close")
	public DruidDataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(dataSourceProperties.getDriver());
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());
		dataSource.setInitialSize(dataSourceProperties.getInitialSize());
		dataSource.setMaxActive(dataSourceProperties.getMaxActive());
		dataSource.setMinIdle(dataSourceProperties.getMinIdle());
		dataSource.setMaxWait(dataSourceProperties.getMaxWait());
		dataSource.setValidationQuery(dataSourceProperties.getValidationQuery());
		dataSource.setValidationQueryTimeout(dataSourceProperties.getValidationQueryTimeout());
		dataSource.setTestOnBorrow(dataSourceProperties.getTestOnBorrow());
		dataSource.setTestOnReturn(dataSourceProperties.getTestOnReturn());
		dataSource.setTestWhileIdle(dataSourceProperties.getTestWhileIdle());
		dataSource.setPoolPreparedStatements(dataSourceProperties.getPoolPreparedStatements());
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(dataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
		dataSource.setKeepAlive(dataSourceProperties.getKeepAlive());
		dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
		dataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
		dataSource.setFilters(dataSourceProperties.getFilters());
		dataSource.setConnectionProperties(dataSourceProperties.getConnectionProperties());
		return dataSource;
	}
	
	@Profile("dev")
	@Configuration
	@PropertySource(value = "classpath:db/dev/db.properties", ignoreResourceNotFound = true)
	static class DataSourceConfigDev {
		
	}
	
	@Profile("test")
	@Configuration
	@PropertySource(value = "classpath:db/test/db.properties", ignoreResourceNotFound = true)
	static class DataSourceConfigTest {
		
	}
	
	@Profile("prod")
	@Configuration
	@PropertySource(value = "classpath:db/prod/db.properties", ignoreResourceNotFound = true)
	static class DataSourceConfigProd {
		
	}
}
