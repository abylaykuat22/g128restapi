package kz.bitlab.g128springrestapi.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private Long id;
    private String fullName;
    private String email;
    private Integer age;
    private Integer exam;
    private String mark;
}
