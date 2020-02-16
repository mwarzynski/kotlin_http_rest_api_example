package com.example.microservice.app.person

import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, String>