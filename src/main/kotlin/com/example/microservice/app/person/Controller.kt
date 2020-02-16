package com.example.microservice.app.person

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/people")
class Controller {

    @Autowired
    lateinit var repository: Repository

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Person? = repository.findById(id)

    @GetMapping
    fun findAll(): List<Person> = repository.findAll()

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Boolean = repository.removeById(id)
}