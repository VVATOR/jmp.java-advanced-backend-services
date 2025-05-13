package com.epam.jmp.jabs.module1.config.sequrity;

import com.epam.jmp.jabs.module1.constant.UserRoles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private static final String AUTH_ENDPOINT_PATTERN = "/api/v1/auth/**";
    private static final String PRODUCTS_ENDPOINT_PATTERN = "/api/v1/products";
    private static final String H2_CONSOLE_ENDPOINT_PATTERN = "/h2-console/**";
    private static final String ROOT_PATTERN = "/";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationConverter jwtAuthenticationConverter) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(ROOT_PATTERN, AUTH_ENDPOINT_PATTERN).permitAll()
                        .requestMatchers(H2_CONSOLE_ENDPOINT_PATTERN).permitAll()
                        .requestMatchers(HttpMethod.GET, PRODUCTS_ENDPOINT_PATTERN).permitAll()
                        .requestMatchers(HttpMethod.DELETE, PRODUCTS_ENDPOINT_PATTERN).hasRole(UserRoles.ADMIN.name())
                        .requestMatchers(HttpMethod.PUT, PRODUCTS_ENDPOINT_PATTERN).hasAnyRole(UserRoles.ADMIN.name(), UserRoles.USER.name())
                        .requestMatchers(HttpMethod.POST, PRODUCTS_ENDPOINT_PATTERN).hasAnyRole(UserRoles.ADMIN.name(), UserRoles.USER.name())
                        .requestMatchers(PRODUCTS_ENDPOINT_PATTERN).authenticated()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt
                                .jwtAuthenticationConverter(jwtAuthenticationConverter)
                        )
                ).build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        final var grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        grantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
        grantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
        final var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }
}
