package com.trisor.user.security;

import org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter;
import org.springframework.core.convert.converter.Converter;

import java.util.Collections;
import java.util.Map;

public class UserClaimsAdapter implements
        Converter<Map<String, Object>, Map<String, Object>> {

    private final MappedJwtClaimSetConverter delegate =
            MappedJwtClaimSetConverter.withDefaults(Collections.emptyMap());

    public Map<String, Object> convert(Map<String, Object> claims) {
        Map<String, Object> convertedClaims = this.delegate.convert(claims);
        String fullName = convertedClaims.get("fullName") != null ?
                (String) convertedClaims.get("fullName") : "unknown";

        convertedClaims.put("fullName", fullName.toUpperCase());

        return convertedClaims;
    }
}
