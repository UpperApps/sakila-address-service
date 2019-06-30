package com.upperapps.sakila.sakilaaddressservice.repository

import com.upperapps.sakila.sakilaaddressservice.domain.City
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository : JpaRepository<City, Long> {
}