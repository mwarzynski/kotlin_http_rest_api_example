package com.example.microservice.app.person

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Field

data class Person(@Id var id: String? = null,
                  @Field var name: String? = null)