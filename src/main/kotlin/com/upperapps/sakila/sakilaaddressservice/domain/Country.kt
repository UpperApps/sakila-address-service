package com.upperapps.sakila.sakilaaddressservice.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Country (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "country_id")
        var id: Long,
        @Column(name = "country")
        var name: String,
        var lastUpdate: LocalDateTime
)