package com.example.YamoHome.repositories;

import com.example.YamoHome.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {
}
