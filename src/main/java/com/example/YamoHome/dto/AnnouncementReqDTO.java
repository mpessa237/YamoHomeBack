package com.example.YamoHome.dto;

import com.example.YamoHome.entities.PropertyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@Builder
public class AnnouncementReqDTO {
    @NotEmpty(message = "title is mandatory")
    @NotBlank(message = "title is mandatory")
    private String title;
    private String description;
    private Double price;
    @NotEmpty(message = "neighborhood is mandatory")
    @NotBlank(message = "neighborhood is mandatory")
    private String neighborhood;
    @NotEmpty(message = "city is mandatory")
    @NotBlank(message = "city is mandatory")
    private String city;
    private PropertyType propertyType;
    private String address;
    private int bedrooms;
    private int bathrooms;
    private List<String> imageUrls;
}
