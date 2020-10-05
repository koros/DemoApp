package com.koros.demoapp.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.Assert.*;

public class JwtUserDetailsServiceTest {

    JwtUserDetailsService jwtUserDetailsService = new JwtUserDetailsService();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void loadUserByUsername() {
        String username = "user";
        UserDetails resp = jwtUserDetailsService.loadUserByUsername(username);
        Assert.assertNotNull(resp);
        Assert.assertEquals(username, resp.getUsername());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_ExceptionIsThrownWhenBadCredentials() {
        String username = "mickey mouse";
        jwtUserDetailsService.loadUserByUsername(username);
    }
}