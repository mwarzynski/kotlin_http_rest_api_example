package com.example.microservice.app.course

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

data class Student(@JsonIgnore var id: String, var name: String?)

data class Course(@Id var id: String? = null,
                  @CreatedDate var createdDate: LocalDateTime?,
                  @LastModifiedDate var modifiedDate: LocalDateTime?,
                  @Field var name: String?,
                  @Field var description: String?,
                  @Field var students: MutableMap<String, Student> = HashMap()
) {
    fun studentAdd(student: Student) = students.set(student.id, student)
    fun studentDelete(student: Student) = students.remove(student.id)
}