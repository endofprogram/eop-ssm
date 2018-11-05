package org.eop.ssm.web.config.security.metadatasource;

import java.util.Date;

/**
 * @author lixinjie
 * @since 2018-10-31
 */
public interface SecurityMetadataSourceLoader {

	Date getLastModified();
	
	Date getLastLoaded();
	
	void load();
	
	void reload();
}
