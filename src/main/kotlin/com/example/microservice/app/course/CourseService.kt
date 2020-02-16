package com.example.microservice.app.course

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

interface CourseService {
    fun getAll(pageable: Pageable): Page<Course>
    fun getById(id: String): Optional<Course>
    fun create(course: Course): Course
    fun update(id: String, course: Course): Optional<Course>
    fun delete(id: String)
}

@Service
class CourseServiceImpl(
        private val repository: CourseRepository
) : CourseService {
    override fun getAll(pageable: Pageable): Page<Course> = repository.findAll(pageable)
    override fun getById(id: String): Optional<Course> = repository.findById(id)
    override fun create(course: Course): Course = repository.save(course)
    override fun update(id: String, course: Course): Optional<Course> {
        return getById(id).map {
            it.name = course.name
            repository.save(it)
        }
    }

    override fun delete(id: String) = repository.deleteById(id)
}