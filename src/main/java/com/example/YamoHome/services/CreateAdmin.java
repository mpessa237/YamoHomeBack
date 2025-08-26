package com.example.YamoHome.services;

import com.example.YamoHome.dto.RegistrationRequest;
import com.example.YamoHome.entities.Role;
import com.example.YamoHome.entities.User;
import com.example.YamoHome.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CreateAdmin {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public User createAdmin(RegistrationRequest registrationRequest){

        User admin = new User();
        admin.setNom(registrationRequest.getNom());
        admin.setEmail(registrationRequest.getEmail());

        String encodedPassword = passwordEncoder.encode(registrationRequest.getMotDePasse());
        admin.setMotDePasse(encodedPassword);

        admin.setEnabled(true);
        admin.setAccountLocked(false);

        admin.setRole(Set.of(Role.ROLE_ADMIN));

        return userRepo.save(admin);
    }
}
