package com.koros.demoapp.controller;

import com.koros.demoapp.config.JwtTokenUtil;
import com.koros.demoapp.config.JwtUserDetailsService;
import com.koros.demoapp.dto.JwtRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JwtAuthenticationControllerTest {

    @Mock AuthenticationManager authenticationManager;
    @Mock JwtTokenUtil jwtTokenUtil;
    @Mock JwtUserDetailsService userDetailsService;

    @InjectMocks
    JwtAuthenticationController jwtAuthenticationController;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldFilterTransactionsById() throws Exception{
        String username = "username";
        String password = "password";
        String token = "some jwt token";
        JwtRequest authenticationRequest = new JwtRequest(username, password);
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
        Mockito.when(jwtTokenUtil.generateToken(userDetails)).thenReturn(token);
        ResponseEntity<?> resp = jwtAuthenticationController.createAuthenticationToken(authenticationRequest);
        Assert.assertTrue(resp.getStatusCode().is2xxSuccessful());
    }
}