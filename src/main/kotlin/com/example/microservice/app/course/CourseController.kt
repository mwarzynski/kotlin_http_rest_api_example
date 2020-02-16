package com.example.microservice.app.course

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/courses")
class CourseController(private val service: CourseService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Optional<Course> = service.getById(id)

    @GetMapping
    fun getAll(@PageableDefault pageable: Pageable): Page<Course> = service.getAll(pageable)

    @PostMapping
    fun create(@RequestBody course: Course): Course = service.create(course)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody course: Course): Course = service.update(id, course).get()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = service.delete(id)
}