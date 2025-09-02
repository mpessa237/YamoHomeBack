package com.example.YamoHome.services;

import com.example.YamoHome.dto.AnnouncementReqDTO;
import com.example.YamoHome.dto.AnnouncementRespDTO;
import com.example.YamoHome.entities.Announcement;
import com.example.YamoHome.entities.AnnouncementStatus;
import com.example.YamoHome.entities.User;
import com.example.YamoHome.mapper.AnnouncementMapper;
import com.example.YamoHome.repositories.AnnouncementRepo;
import com.example.YamoHome.repositories.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final UserRepo userRepo;
    private final AnnouncementRepo announcementRepo;
    private final AnnouncementMapper announcementMapper;

    @Transactional
    public AnnouncementRespDTO createAnnouncement(AnnouncementReqDTO announcementReqDTO){
        // Étape 1 : Récupérer l'utilisateur actuellement authentifié.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User currentUser = userRepo.findByEmail(userEmail)
                .orElseThrow(()->new RuntimeException("user not found:" + userEmail));
        Announcement newAnnouncement = announcementMapper.toEntity(announcementReqDTO);

        newAnnouncement.setUser(currentUser);
        newAnnouncement.setAnnouncementStatus(AnnouncementStatus.PENDING);

        Announcement savedAnnouncement = announcementRepo.save(newAnnouncement);

        return announcementMapper.toDto(savedAnnouncement);

    }

    @Transactional
    public List<AnnouncementRespDTO> getAllAnnouncements() {
        // 1. Récupère toutes les entités
        List<Announcement> announcements = announcementRepo.findAll();

        // 2. Utilise le mapper pour convertir chaque entité en DTO
        return announcements.stream()
                .map(announcementMapper::toDto)
                .collect(Collectors.toList());
    }

}
