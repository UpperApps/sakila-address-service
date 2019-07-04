package com.upperapps.sakila.sakilaaddressservice.api

import com.upperapps.sakila.sakilaaddressservice.repository.AddressRepository
import com.upperapps.sakila.sakilaaddressservice.repository.CityRepository
import com.upperapps.sakila.sakilaaddressservice.repository.CountryRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/addresses")
class AddressController (val addressRepository: AddressRepository,
                         val countryRepository: CountryRepository,
                         val cityRepository: CityRepository) {

    @GetMapping
    fun findAll() = addressRepository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Long) = addressRepository.findById(id)

    @GetMapping("/countries")
    @Cacheable(cacheNames = arrayOf("address-counries"))
    fun findAllCountries() = countryRepository.findAll()

    @GetMapping("/cities")
    fun findAllCities() = cityRepository.findAll()
}