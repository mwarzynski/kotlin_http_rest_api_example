package com.example.microservice.app.course

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

data class Course(@Id var id: String? = null,
                  @CreatedDate var createdDate: LocalDateTime?,
                  @LastModifiedDate var modifiedDate: LocalDateTime?,
                  @Field var name: String?,
                  @Field var description: String?
)