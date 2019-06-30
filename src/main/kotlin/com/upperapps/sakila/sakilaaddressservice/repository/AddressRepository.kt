package com.upperapps.sakila.sakilaaddressservice.repository

import com.upperapps.sakila.sakilaaddressservice.domain.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Long> {
}