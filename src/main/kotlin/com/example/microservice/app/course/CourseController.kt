package com.example.microservice.app.course

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/courses")
class CourseController(private val repository: CourseService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Optional<Course> = repository.getById(id)

    @GetMapping
    fun getAll(@PageableDefault pageable: Pageable): Page<Course> = repository.getAll(pageable)

    @PostMapping
    fun create(@RequestBody course: Course): Course = repository.create(course)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody course: Course): Course = repository.update(id, course).get()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = repository.delete(id)
}