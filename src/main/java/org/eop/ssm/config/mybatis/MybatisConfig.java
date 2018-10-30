package org.eop.ssm.config.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
//@Configuration
//@MapperScan(basePackages = {"org.eop.ssm.**.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

	@Bean
	public SqlSessionFactory sqlSessionFactory(DruidDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis/mybatis-config.xml"));
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/**/*.xml"));
		return sqlSessionFactory.getObject();
	}
}
