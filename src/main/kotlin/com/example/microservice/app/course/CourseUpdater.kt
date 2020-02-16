package com.example.microservice.app.course

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.Mappings

@Mapper
interface CourseUpdater {
    @Mappings(
        Mapping(target = "id", ignore = true),
        Mapping(target = "createdDate", ignore = true),
        Mapping(target = "modifiedDate", ignore = true),
        Mapping(target = "students", ignore = true)
    )
    fun update(@MappingTarget target: Course, source: Course): Course
}
