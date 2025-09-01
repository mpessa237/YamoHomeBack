package com.example.YamoHome.mapper;

import com.example.YamoHome.dto.UserRespDTO;
import com.example.YamoHome.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserRespDTO toDto(User user){
        if (user==null){
            return null;
        }
        return UserRespDTO.builder()
                .userId(user.getUserId())
                .nom(user.getNom())
                .email(user.getEmail())
                .build();
    }
}
