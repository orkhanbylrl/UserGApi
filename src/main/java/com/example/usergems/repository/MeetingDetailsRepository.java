package com.example.usergems.repository;

import com.example.usergems.model.entity.MeetingDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MeetingDetailsRepository extends JpaRepository<MeetingDetailsEntity, Long> {
    @Query("""
    SELECT m FROM MeetingDetailsEntity m
    WHERE m.person.id = :personId
      AND m.user.email = :email
""")
    List<MeetingDetailsEntity> getMeetingDetails(@Param("personId") Long personId, @Param("email") String email);
}
