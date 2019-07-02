package com.upperapps.sakila.sakilaaddressservice.domain

import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Serializable
class Address (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "address_id")
        var id: Long,
        var address: String,
        var address2: String?,
        var district: String,
        @ManyToOne
        @JoinColumn(name = "city_id")
        var city: City,
        var postalCode: String?,
        var phone: String,
        @ContextualSerialization
        var lastUpdate: LocalDateTime
)