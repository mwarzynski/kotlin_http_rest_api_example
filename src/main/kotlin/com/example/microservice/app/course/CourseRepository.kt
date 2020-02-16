package com.example.microservice.app.course

import org.springframework.data.repository.PagingAndSortingRepository

interface CourseRepository : PagingAndSortingRepository<Course, String>