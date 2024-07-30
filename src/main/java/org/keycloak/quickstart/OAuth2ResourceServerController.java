package org.keycloak.quickstart;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OAuth2ResourceServerController {

    @GetMapping("/users")
    public String index(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getClaimAsString("preferred_username"));
    }

    @GetMapping("/admin")
    public String premium(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getClaimAsString("preferred_username"));
    }
}
