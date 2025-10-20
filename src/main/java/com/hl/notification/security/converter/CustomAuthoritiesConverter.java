package com.hl.notification.security.converter;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomAuthoritiesConverter
        implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(@NonNull Jwt jwt) {
        return extractUserRoles(jwt);
    }

    private Collection<GrantedAuthority> extractUserRoles(Jwt jwt) {
//        Map<String, Object> realmAccess = jwt.getClaim("realm_access");
//        List<String> realmRoles = (List<String>) realmAccess.get("roles");
//
//        if (!CollectionUtils.isEmpty(realmRoles)) {
//            return realmRoles.stream()
//                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
//                    .collect(Collectors.toSet());
//        }

        return Collections.emptySet();
    }
}
