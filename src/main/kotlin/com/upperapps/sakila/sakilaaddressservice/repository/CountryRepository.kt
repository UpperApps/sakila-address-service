package com.upperapps.sakila.sakilaaddressservice.repository

import com.upperapps.sakila.sakilaaddressservice.domain.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<Country, Long> {
}