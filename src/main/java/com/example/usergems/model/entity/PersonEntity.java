package com.example.usergems.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String email;
    String avatarLink;
    String title;
    String linkedinUrl;
    Integer totalMeetingCount;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<MeetingDetailEntity> meetingDetails = new HashSet<>();
    LocalDateTime lastFetchedAt;
    @ManyToMany(mappedBy = "accepted")
    private Set<EventEntity> acceptedEvents = new HashSet<>();
    @ManyToMany(mappedBy = "rejected")
    private Set<EventEntity> rejectedEvents = new HashSet<>();
    @Embedded
    CompanyObj company;
}
