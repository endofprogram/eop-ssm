package org.eop.ssm.web.config.security.metadatasource.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.eop.ssm.web.config.security.metadatasource.mapper.MetadataSourceMapper;
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
		return null;
	}

	@Override
	public LinkedHashMap<String, List<String>> getAllUrlRolesMappings() {
		return null;
	}

}
