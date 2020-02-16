package com.example.microservice.app.person

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

data class Person(@Id var id: String? = null,
                  @Field var name: String? = null,
                  @CreatedDate var createdDate: LocalDateTime?,
                  @LastModifiedDate var lastModifiedDate: LocalDateTime?
)