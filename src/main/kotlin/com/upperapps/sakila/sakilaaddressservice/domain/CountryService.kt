package com.upperapps.sakila.sakilaaddressservice.domain

import com.upperapps.sakila.sakilaaddressservice.api.dto.CountryDto
import com.upperapps.sakila.sakilaaddressservice.repository.CountryRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class CountryService (val countryRepository: CountryRepository) {

    @Cacheable(cacheNames = arrayOf("address-counries"))
    fun findAllCountries(): List<CountryDto> {
        return countryRepository.findAll().map { country -> CountryDto.fromDomain(country) }
    }
}