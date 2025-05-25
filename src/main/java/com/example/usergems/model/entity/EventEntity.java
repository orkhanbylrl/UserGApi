package com.example.usergems.model.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime updatedAt;
    LocalDateTime startAt;
    LocalDateTime endAt;
    String title;

    @ManyToMany
    @JoinTable(
            name = "event_accepted",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<PersonEntity> accepted = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "event_rejected",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Set<PersonEntity> rejected = new HashSet<>();
}
