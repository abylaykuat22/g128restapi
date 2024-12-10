package kz.bitlab.g128springrestapi.mapper;

import kz.bitlab.g128springrestapi.dtos.StudentDto;
import kz.bitlab.g128springrestapi.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    List<StudentDto> toDtoList(List<Student> entities);

    @Mapping(target = "fullName", source = "name")
    StudentDto toDto(Student entity);

}
