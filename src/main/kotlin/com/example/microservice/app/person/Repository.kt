package com.example.microservice.app.person

import org.springframework.stereotype.Repository

@Repository
class Repository {
    val people: MutableList<Person> = ArrayList()

    fun findById(id: Int): Person? {
        return people.singleOrNull { it.id == id }
    }

    fun findAll(): List<Person> {
        return people
    }

    fun save(person: Person): Person {
        person.id = (people.maxBy { it.id!! }?.id ?: 0) + 1
        people.add(person)
        return person
    }

    fun removeById(id: Int): Boolean {
        return people.removeIf { it.id == id }
    }
}