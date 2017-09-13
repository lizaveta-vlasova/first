package com.mobileapplication.service.impl;

import com.mobileapplication.dao.ClientDao;
import com.mobileapplication.domain.Client;
import com.mobileapplication.domain.ClientRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Сервис для работы с данными пользователей.
 *
 */
@Service
public class UserDetailsServiceStub implements UserDetailsService {

	private final ClientDao clientDao;

	@Autowired
	public UserDetailsServiceStub(final ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {

		try {
			Client client = clientDao.findByUserEmail (email);
			List<GrantedAuthority> authorities = buildUserAuthority(client.getClientRoles());

			return buildUserForAuthentication(client, authorities);

		} catch (EmptyResultDataAccessException e) {
			throw new UsernameNotFoundException ("User with name = " + email + " not found");
		}

	}

	private List<GrantedAuthority> buildUserAuthority(Set<ClientRole> clientRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<>();

		for (ClientRole clientRole : clientRoles) {
			setAuths.add(new SimpleGrantedAuthority(clientRole.getRole()));
		}

        return new ArrayList<>(setAuths);
	}

	private User buildUserForAuthentication(Client client, List<GrantedAuthority> authorities) {
        return new User(client.getEmail(), client.getPassword(),true, true, true, true, authorities);
	}
}
