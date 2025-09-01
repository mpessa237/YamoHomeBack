package com.example.YamoHome;

import com.example.YamoHome.entities.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof User) {
            // C'est ici qu'on fait la correction : on retourne l'ID de l'utilisateur
            return Optional.of(((User) principal).getUserId());
        }

        return Optional.empty();
    }
}
