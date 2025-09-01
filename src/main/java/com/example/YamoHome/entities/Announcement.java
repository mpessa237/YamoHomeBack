package com.example.YamoHome.entities;

import com.example.YamoHome.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "announcements")
@Entity
public class Announcement extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;
    private String title;
    private String description;
    private Double price;
    private String neighborhood;
    private String city;
    private String address;

    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;

    private int bedrooms;
    private int bathrooms;
    @Enumerated(EnumType.STRING)
    private AnnouncementStatus announcementStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "announcement", cascade = CascadeType.ALL)
    private Set<Image> images;
}
