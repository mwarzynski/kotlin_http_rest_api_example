package com.example.microservice.app.course

import com.example.microservice.app.person.PersonService
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
    fun studentsAdd(courseId: String, studentIds: List<String>): Optional<Course>
    fun studentsDelete(courseId: String, studentIds: List<String>): Optional<Course>
}

@Service
class CourseServiceImpl(
        private val repository: CourseRepository,
        private val updater: CourseUpdater,
        private val personService: PersonService
) : CourseService {
    override fun getAll(pageable: Pageable): Page<Course> = repository.findAll(pageable)

    override fun getById(id: String): Optional<Course> = repository.findById(id)

    override fun create(course: Course): Course = repository.save(course)

    override fun update(id: String, course: Course): Optional<Course> = getById(id).map {
        updater.update(it, course)
        repository.save(it)
    }

    override fun delete(id: String) = repository.deleteById(id)

    override fun studentsAdd(courseId: String, studentIds: List<String>): Optional<Course> {
        // Validate if all students exists.
        val students = studentsFetch(studentIds)
        // Fetch course and add students to it.
        return getById(courseId).map {course ->
            students.forEach{course.studentAdd(it)}
            repository.save(course)
        }
    }

    override fun studentsDelete(courseId: String, studentIds: List<String>): Optional<Course> {
        // Validate if all students exists.
        val students = studentsFetch(studentIds)
        // Fetch course and add students to it.
        return getById(courseId).map{course ->
            students.forEach{course.studentDelete(it)}
            repository.save(course)
        }
    }

    private fun studentsFetch(peopleIDs: List<String>): List<Student>
            = personService.getByIds(peopleIDs).map{person -> Student(person.id!!, person.name)}
}