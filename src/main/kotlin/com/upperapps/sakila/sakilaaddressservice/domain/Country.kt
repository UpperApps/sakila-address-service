package com.upperapps.sakila.sakilaaddressservice.domain

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Serializable
class Country (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "country_id")
        var id: Long,
        @Column(name = "country")
        var name: String,
        @ContextualSerialization
        var lastUpdate: LocalDateTime
)
