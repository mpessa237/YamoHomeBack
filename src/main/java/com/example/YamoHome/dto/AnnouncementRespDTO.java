package com.example.YamoHome.dto;

import com.example.YamoHome.entities.AnnouncementStatus;
import com.example.YamoHome.entities.PropertyType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class AnnouncementRespDTO {
    private Long announcementId;
    private String title;
    private String description;
    private Double price;
    private String neighborhood;
    private String city;
    private String address;
    private PropertyType propertyType;
    private int bedrooms;
    private int bathrooms;
    private AnnouncementStatus announcementStatus;
    private List<String> imageUrls;
    private UserRespDTO user;
}
