package com.example.YamoHome.controller;

import com.example.YamoHome.dto.AnnouncementReqDTO;
import com.example.YamoHome.dto.AnnouncementRespDTO;
import com.example.YamoHome.services.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<AnnouncementRespDTO> createAnnouncement(@Validated @RequestBody AnnouncementReqDTO announcementReqDTO){

        AnnouncementRespDTO announcementRespDTO = announcementService.createAnnouncement(announcementReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(announcementRespDTO);
    }
}
