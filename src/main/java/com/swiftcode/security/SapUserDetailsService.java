package com.swiftcode.security;

import com.google.common.collect.Lists;
import com.swiftcode.domain.SapUser;
import com.swiftcode.repository.SapUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chen
 **/
@Slf4j
@Component("sapUserDetailsService")
public class SapUserDetailsService implements UserDetailsService {
    private final SapUserRepository sapUserRepository;

    public SapUserDetailsService(SapUserRepository sapUserRepository) {
        this.sapUserRepository = sapUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userCode) throws UsernameNotFoundException {
        return sapUserRepository.findByUserCode(userCode)
            .map(this::createSpringSecurityUser)
            .orElseThrow(() -> new UsernameNotFoundException("Customer " + userCode + " was not fount"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(SapUser user) {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(user.getUserCode(),
            user.getPassword(),
            grantedAuthorities);
    }
}
