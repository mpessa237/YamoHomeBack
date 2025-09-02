package com.example.YamoHome.controller;

import com.example.YamoHome.dto.AnnouncementReqDTO;
import com.example.YamoHome.dto.AnnouncementRespDTO;
import com.example.YamoHome.entities.Announcement;
import com.example.YamoHome.services.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<AnnouncementRespDTO>> getAllAnnouncements() {
        List<AnnouncementRespDTO> announcements = announcementService.getAllAnnouncements();
        return ResponseEntity.ok(announcements);
    }
}
