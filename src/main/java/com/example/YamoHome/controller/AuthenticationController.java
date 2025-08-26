package com.example.YamoHome.controller;

import com.example.YamoHome.dto.AuthenticationRequestDTO;
import com.example.YamoHome.dto.AuthenticationResponseDTO;
import com.example.YamoHome.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@Validated @RequestBody AuthenticationRequestDTO authenticationRequestDTO){
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestDTO));
    }
}
