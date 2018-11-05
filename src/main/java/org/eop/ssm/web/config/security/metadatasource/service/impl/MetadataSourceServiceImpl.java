package org.eop.ssm.web.config.security.metadatasource.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.eop.ssm.web.config.security.metadatasource.service.MetadataSourceService;
import org.springframework.stereotype.Service;

/**
 * @author lixinjie
 * @since 2018-10-31
 */
@Service
public class MetadataSourceServiceImpl implements MetadataSourceService {

	//private MetadataSourceMapper metadataSourceMapper;
	
	@Override
	public Date getLastModified() {
		return new Date();
	}

	@Override
	public LinkedHashMap<String, List<String>> getAllUrlRolesMappings() {
		LinkedHashMap<String, List<String>> urms = new LinkedHashMap<>();
		urms.put("/example/rolec", Arrays.asList("ROLE_C"));
		urms.put("/example/roled", Arrays.asList("ROLE_D"));
		urms.put("/example/login", Arrays.asList("permitAll"));
		urms.put("/example/loginProcess", Arrays.asList("permitAll"));
		urms.put("/example/logoutProcess", Arrays.asList("permitAll"));
		urms.put("/example/logout", Arrays.asList("permitAll"));
		urms.put("/**", Arrays.asList("authenticated"));
		return urms;
	}

}
