package org.eop.ssm.config.idgene;

import org.eop.common.idgene.CycleRadixIdGenerator;
import org.eop.common.idgene.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lixinjie
 * @since 2018-08-08
 */
@Configuration
public class IdGeneConfig {

	@Bean
	public IdGenerator idGenerator() {
		return new CycleRadixIdGenerator();
	}
}
