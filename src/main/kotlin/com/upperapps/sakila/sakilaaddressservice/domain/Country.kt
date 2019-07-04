package com.upperapps.sakila.sakilaaddressservice.domain

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Serializable
data class Country (
        @field:[Id GeneratedValue(strategy = GenerationType.AUTO) Column(name = "country_id")]
        var id: Long,

        @field:[Column(name = "country")]
        var name: String,

        @ContextualSerialization
        var lastUpdate: LocalDateTime
)

