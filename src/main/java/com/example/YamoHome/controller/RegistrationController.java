package com.example.YamoHome.controller;

import com.example.YamoHome.common.ApiResponse;
import com.example.YamoHome.dto.RegistrationRequest;
import com.example.YamoHome.services.CreateAdmin;
import com.example.YamoHome.services.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class RegistrationController {

    private final RegisterService registerService;
    private final CreateAdmin createAdmin;


    @PostMapping("/user")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest registrationRequest){
        var user = registerService.register(registrationRequest);
        return ResponseEntity.ok(new ApiResponse("successfully register user",user.getNom()));
    }

    @PostMapping("/create-admin")
    public ResponseEntity<ApiResponse> createAdmin(@Validated @RequestBody RegistrationRequest registrationRequest) {
        var admin = createAdmin.createAdmin(registrationRequest);
        return ResponseEntity.ok(new ApiResponse("admin created successfully",admin.getNom()));
    }




}
