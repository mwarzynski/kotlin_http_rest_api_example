package com.example.microservice.app.person

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/people")
class Controller(private val repository: PersonRepository) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): Optional<Person> = repository.findById(id)

    @GetMapping
    fun findAll(@PageableDefault pageable: Pageable): Page<Person> = repository.findAll(pageable)

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = repository.deleteById(id)
}