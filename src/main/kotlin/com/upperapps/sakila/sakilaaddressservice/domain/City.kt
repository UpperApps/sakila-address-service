package com.upperapps.sakila.sakilaaddressservice.domain

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Serializable
class City (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "city_id")
        var id: Long,
        @Column(name = "city")
        var name: String,
        @ManyToOne
        @JoinColumn(name = "country_id")
        @ContextualSerialization
        var country: Country,
        @ContextualSerialization
        var lastUpdate: LocalDateTime
)