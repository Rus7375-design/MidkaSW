package com.example.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.dto.StudentDto;
import com.example.Entity.StudentEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Mapper {

    @Mapping(target = "firstNameStudent", source = "firstNameEntity")
    @Mapping(target = "lastNameStudent", source = "lastNameEntity")
    @Mapping(target = "email", ignore = true) // email нет в Entity, игнорируем
    StudentDto toDto(StudentEntity studentEntity);

    @Mapping(target = "firstNameEntity", source = "firstNameStudent")
    @Mapping(target = "lastNameEntity", source = "lastNameStudent")
    @Mapping(target = "age", ignore = true) // age нет в DTO, игнорируем
    StudentEntity toEntity(StudentDto studentDto);

    List<StudentDto> toDtoList(List<StudentEntity> studentEntityList);
}
