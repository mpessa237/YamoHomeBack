package com.example.YamoHome.services;

import com.example.YamoHome.dto.AuthenticationRequestDTO;
import com.example.YamoHome.dto.AuthenticationResponseDTO;
import com.example.YamoHome.entities.User;
import com.example.YamoHome.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO authenticationRequestDTO){

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequestDTO.getEmail(),
                        authenticationRequestDTO.getMotDePasse()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        var claims = new HashMap<String,Object>();
        var user = ((User)auth.getPrincipal());
        System.out.println(user);
        claims.put("fullName",user.getNom());

        var jwt = jwtService.generateToken(claims,user);

        return AuthenticationResponseDTO.builder().token(jwt).build();
    }
}
