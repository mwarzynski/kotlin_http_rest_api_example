package com.example.microservice.app.person

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

interface PersonService {
    fun getAll(pageable: Pageable): Page<Person>
    fun getById(id: String): Optional<Person>
    fun create(person: Person): Person
    fun update(id: String, person: Person): Optional<Person>
    fun delete(id: String)
}

@Service
class PersonServiceImpl(
        private val repository: PersonRepository,
        private val updater: PersonUpdater
) : PersonService {
    override fun getAll(pageable: Pageable): Page<Person> = repository.findAll(pageable)
    override fun getById(id: String): Optional<Person> = repository.findById(id)
    override fun create(person: Person): Person = repository.save(person)
    override fun update(id: String, person: Person): Optional<Person> {
        return getById(id).map {
            updater.update(it, person)
            repository.save(it)
        }
    }
    override fun delete(id: String) = repository.deleteById(id)
}