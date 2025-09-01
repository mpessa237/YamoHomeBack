package com.example.YamoHome.services;

import com.example.YamoHome.dto.RegistrationRequest;
import com.example.YamoHome.entities.Role;
import com.example.YamoHome.entities.User;
import com.example.YamoHome.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class RegisterService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public User register(RegistrationRequest registrationRequest){

        User user = new User();
        user.setNom(registrationRequest.getNom());
        user.setEmail(registrationRequest.getEmail());

        String rawMotDePasse = registrationRequest.getMotDePasse();
        String encodeMotDePasse = passwordEncoder.encode(rawMotDePasse);
        user.setMotDePasse(encodeMotDePasse);

        user.setEnabled(false);
        user.setAccountLocked(false);

        user.setRole(Set.of(Role.ROLE_USER));
        return userRepo.save(user);
    }

    public List<User> findAll(){
        return this.userRepo.findAll();
    }
}
