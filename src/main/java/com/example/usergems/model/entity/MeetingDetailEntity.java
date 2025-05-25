package com.example.usergems.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "meeting_detail")
public class MeetingDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;
    Integer numberOfMeeting;
    @ManyToOne
    @JoinColumn(name = "person_id")
    PersonEntity person;
}
