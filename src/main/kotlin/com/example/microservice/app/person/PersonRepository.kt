package com.example.microservice.app.person

import org.springframework.data.repository.PagingAndSortingRepository

interface PersonRepository : PagingAndSortingRepository<Person, String>