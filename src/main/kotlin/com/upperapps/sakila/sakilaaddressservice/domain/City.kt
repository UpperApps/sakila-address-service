package com.upperapps.sakila.sakilaaddressservice.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class City (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "city_id")
        var id: Long,
        @Column(name = "city")
        var name: String,
        @ManyToOne
        @JoinColumn(name = "country_id")
        var country: Country,
        var lastUpdate: LocalDateTime
)