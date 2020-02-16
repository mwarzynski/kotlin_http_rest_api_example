package com.example.microservice.app.person

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget
import org.mapstruct.Mappings

@Mapper
interface PersonUpdater {
    @Mappings(
        Mapping(target = "id", ignore = true),
        Mapping(target = "createdDate", ignore = true),
        Mapping(target = "modifiedDate", ignore = true)
    )
    fun update(@MappingTarget target: Person, source: Person): Person
}
