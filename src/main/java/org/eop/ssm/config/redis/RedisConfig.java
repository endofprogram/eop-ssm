package org.eop.ssm.config.redis;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
//@Configuration
//@PropertySource(value = "classpath:redis/redis.properties", ignoreResourceNotFound = true)
public class RedisConfig {
	
	@Bean
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		//key必须是字符串，直接按UTF-8编码序列化为字节数组
		redisTemplate.setKeySerializer(redisTemplate.getStringSerializer());
		redisTemplate.setHashKeySerializer(redisTemplate.getStringSerializer());
		//value不做限制，使用String或Jdk自带的对象序列化为字节数组
		JdkAndStringRedisSerializer jdkAndStringRedisSerializer = new JdkAndStringRedisSerializer();
		redisTemplate.setValueSerializer(jdkAndStringRedisSerializer);
		redisTemplate.setHashValueSerializer(jdkAndStringRedisSerializer);
		return redisTemplate;
	}
	
	@Bean
	public RedisProperties redisProperties() {
		return new RedisProperties();
	}
	
	@Bean
	public RedisConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {
		JedisConnectionFactory jedisConnectionFactory = null;
		if (StringUtils.hasText(redisProperties.getClusterNodes())) {
			jedisConnectionFactory = new JedisConnectionFactory(clusterConfig(redisProperties), poolConfig(redisProperties));
			jedisConnectionFactory.setPassword(redisProperties.getClusterPassword());
			jedisConnectionFactory.setTimeout(redisProperties.getConnectionTimeout());
			return jedisConnectionFactory;
		}
		if (StringUtils.hasText(redisProperties.getHost())) {
			jedisConnectionFactory = new JedisConnectionFactory(poolConfig(redisProperties));
			jedisConnectionFactory.setHostName(redisProperties.getHost());
			jedisConnectionFactory.setPassword(redisProperties.getNodePassword());
			jedisConnectionFactory.setPort(redisProperties.getPort());
			jedisConnectionFactory.setTimeout(redisProperties.getTimeout());
			return jedisConnectionFactory;
		}
		return jedisConnectionFactory;
	}
	
	private RedisClusterConfiguration clusterConfig(RedisProperties redisProperties) {
		RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(Arrays.asList(redisProperties.getClusterNodes().split(",")));
		clusterConfig.setMaxRedirects(redisProperties.getMaxAttempts());
		return clusterConfig;
	}
	
	private JedisPoolConfig poolConfig(RedisProperties redisProperties) {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setLifo(redisProperties.getLifo());
		poolConfig.setFairness(redisProperties.getFairness());
		poolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
		poolConfig.setMinEvictableIdleTimeMillis(redisProperties.getMinEvictableIdleTimeMillis());
		poolConfig.setSoftMinEvictableIdleTimeMillis(redisProperties.getSoftMinEvictableIdleTimeMillis());
		poolConfig.setNumTestsPerEvictionRun(redisProperties.getNumTestsPerEvictionRun());
		poolConfig.setEvictionPolicyClassName(redisProperties.getEvictionPolicyClassName());
		poolConfig.setTestOnCreate(redisProperties.getTestOnCreate());
		poolConfig.setTestOnBorrow(redisProperties.getTestOnBorrow());
		poolConfig.setTestOnReturn(redisProperties.getTestOnReturn());
		poolConfig.setTestWhileIdle(redisProperties.getTestWhileIdle());
		poolConfig.setTimeBetweenEvictionRunsMillis(redisProperties.getTimeBetweenEvictionRunsMillis());
		poolConfig.setBlockWhenExhausted(redisProperties.getBlockWhenExhausted());
		
		poolConfig.setMaxTotal(redisProperties.getMaxTotal());
		poolConfig.setMaxIdle(redisProperties.getMaxIdle());
		poolConfig.setMinIdle(redisProperties.getMinIdle());
		
		return poolConfig;
	}
	
	@Profile("dev")
	@Configuration
	@PropertySource(value = "classpath:redis/dev/redis.properties", ignoreResourceNotFound = true)
	static class RedisConfigDev {
		
	}
	
	@Profile("test")
	@Configuration
	@PropertySource(value = "classpath:redis/test/redis.properties", ignoreResourceNotFound = true)
	static class RedisConfigTest {
		
	}
	
	@Profile("prod")
	@Configuration
	@PropertySource(value = "classpath:redis/prod/redis.properties", ignoreResourceNotFound = true)
	static class RedisConfigProd {
		
	}
	
	/**
	 * <p>主要用于RedisTemplate里的Value和HashValue的序列化器
	 * <p>序列化时：
	 * <p>字符串、数字按字符串类型序列化
	 * <p>其他按Jdk标准序列化
	 * <p>反序列化时：
	 * <p>先按Jdk标准反序列化
	 * <p>出现失败时，再按字符串类型反序列化
	 * <p>注：存入是数字时，取出时是字符串，需自己转换成数字
	 * @author lixinjie
	 * @since 2018-08-08
	 */
	static class JdkAndStringRedisSerializer implements RedisSerializer<Object> {

		private StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		private JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
		
		@Override
		public byte[] serialize(Object t) {
			if (t == null) {
				return jdkSerializationRedisSerializer.serialize(t);
			}
			if (t instanceof String) {
				return stringRedisSerializer.serialize((String)t);
			}
			if (t instanceof Number) {
				return stringRedisSerializer.serialize(t.toString());
			}
			return jdkSerializationRedisSerializer.serialize(t);
		}

		@Override
		public Object deserialize(byte[] bytes) {
			try {
				return jdkSerializationRedisSerializer.deserialize(bytes);
			} catch (Exception ex) {
				//ignore
			}
			return stringRedisSerializer.deserialize(bytes);
		}

	}
}
