package com.upperapps.sakila.sakilaaddressservice.api.dto

import com.upperapps.sakila.sakilaaddressservice.domain.Country
import kotlinx.serialization.ContextualSerialization
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class CountryDto(val id: Long, val name: String) {
    companion object {
        fun fromDomain(country: Country): CountryDto {
            return CountryDto(country.id, country.name)
        }
    }
}