package com.match.service.automatematchservice.dao;



import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "lookup_s")
public class Lookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lookup_s_key")
    private Integer lookupSKey;

    @Column(name = "lookup_id")
    private String lookupId;

    @Column(name = "sys")
    private String sys;

    @Column(name = "load_datetime")
    private LocalDateTime loadDatetime;

    // Getters and Setters
}

