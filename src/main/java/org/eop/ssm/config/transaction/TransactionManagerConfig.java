package org.eop.ssm.config.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
@Configuration
@EnableTransactionManagement
public class TransactionManagerConfig {

	@Bean
	public DataSourceTransactionManager transactionManager(DruidDataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}
}
