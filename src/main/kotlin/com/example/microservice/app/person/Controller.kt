package com.example.microservice.app.person

import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/people")
class Controller {

    @Autowired
    lateinit var repository: PersonRepository

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): Optional<Person> = repository.findById(id)

    @GetMapping
    fun findAll(): Iterable<Person> = repository.findAll()

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) = repository.deleteById(id)
}