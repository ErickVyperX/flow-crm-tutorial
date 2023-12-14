package com.example.application.security;

import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    private final AuthenticationContext authenticationContext;

    public SecurityService(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    public UserDetails getAuthenticatedUser() {
        UserDetails user = null;
        if (authenticationContext.getAuthenticatedUser(UserDetails.class).isPresent()) {
            user = authenticationContext.getAuthenticatedUser(UserDetails.class).get();
        }
        return user;
    }

    public void logout() {
        authenticationContext.logout();
    }
}
