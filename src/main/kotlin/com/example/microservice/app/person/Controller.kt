package com.example.microservice.app.person

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/people")
class Controller(private val repository: PersonService) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): Optional<Person> = repository.getById(id)

    @GetMapping
    fun getAll(@PageableDefault pageable: Pageable): Page<Person> = repository.getAll(pageable)

    @PostMapping
    fun create(@RequestBody person: Person): Person = repository.create(person)

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody person: Person): Person = repository.update(id, person).get()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = repository.delete(id)
}