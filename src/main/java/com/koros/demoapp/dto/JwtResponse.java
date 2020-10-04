package com.koros.demoapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@RequiredArgsConstructor
@Data
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
}
