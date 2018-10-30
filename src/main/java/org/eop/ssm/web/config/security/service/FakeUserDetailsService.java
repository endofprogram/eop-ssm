package org.eop.ssm.web.config.security.service;

import java.util.Arrays;

import org.eop.ssm.web.config.security.access.authority.RoleGrantedAuthority;
import org.eop.ssm.web.config.security.access.authority.UriGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author lixinjie
 * @since 2018-10-30
 */
public class FakeUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("admin".equals(username)) {
			return new User("admin", "123", Arrays.asList(new RoleGrantedAuthority("ROLE_Admin"),
					new UriGrantedAuthority("/example/index")));
		}
		throw new UsernameNotFoundException("username '" + username + "' not found");
	}

}
