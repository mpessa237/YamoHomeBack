package com.example.YamoHome.mapper;

import com.example.YamoHome.dto.AnnouncementReqDTO;
import com.example.YamoHome.dto.AnnouncementRespDTO;
import com.example.YamoHome.dto.UserRespDTO;
import com.example.YamoHome.entities.Announcement;
import com.example.YamoHome.entities.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AnnouncementMapper {
    private final UserMapper userMapper;


    public Announcement toEntity(AnnouncementReqDTO announcementReqDTO){
        if (announcementReqDTO==null){
            return null;
        }
        Announcement announcement = new Announcement();
        announcement.setTitle(announcementReqDTO.getTitle());
        announcement.setCity(announcementReqDTO.getCity());
        announcement.setAddress(announcementReqDTO.getAddress());
        announcement.setDescription(announcementReqDTO.getDescription());
        announcement.setNeighborhood(announcementReqDTO.getNeighborhood());
        announcement.setPrice(announcementReqDTO.getPrice());
        announcement.setBedrooms(announcementReqDTO.getBedrooms());
        announcement.setBathrooms(announcement.getBedrooms());
        announcement.setPropertyType(announcementReqDTO.getPropertyType());

        if (announcementReqDTO.getImageUrls()!=null){
            announcement.setImages(announcementReqDTO.getImageUrls().stream()
                    .map(url->{
                        Image image = new Image();
                        image.setImageUrl(url);
                        image.setAnnouncement(announcement);
                        return image;
                    })
                    .collect(Collectors.toSet()));
        }
        return announcement;
    }

    public AnnouncementRespDTO toDto(Announcement announcement){
        if (announcement==null){
            return null;
        }
        List<String> imageUrls = announcement.getImages().stream()
                .map(Image::getImageUrl)
                .collect(Collectors.toList());

        UserRespDTO userRespDTO  = null;
        if (announcement.getUser() != null) {
            userRespDTO = userMapper.toDto(announcement.getUser());
        }
        return AnnouncementRespDTO.builder()
                .announcementId(announcement.getAnnouncementId())
                .title(announcement.getTitle())
                .description(announcement.getDescription())
                .price(announcement.getPrice())
                .neighborhood(announcement.getNeighborhood())
                .city(announcement.getCity())
                .address(announcement.getAddress())
                .propertyType(announcement.getPropertyType())
                .bedrooms(announcement.getBedrooms())
                .bathrooms(announcement.getBathrooms())
                .announcementStatus(announcement.getAnnouncementStatus())
                .imageUrls(imageUrls)
                .user(userRespDTO) // Le DTO de l'utilisateur est inclus ici
                .build();
    }

}
