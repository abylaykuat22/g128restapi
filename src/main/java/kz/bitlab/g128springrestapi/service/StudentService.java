package kz.bitlab.g128springrestapi.service;

import kz.bitlab.g128springrestapi.dtos.StudentDto;
import kz.bitlab.g128springrestapi.entity.Student;
import kz.bitlab.g128springrestapi.mapper.StudentMapper;
import kz.bitlab.g128springrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return StudentMapper.INSTANCE.toDtoList(students);
    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        return StudentMapper.INSTANCE.toDto(student);
    }

    public void saveStudent(Student student) {
        Integer exam = student.getExam();
        if (exam != null) {
            if (exam >= 90) {
                student.setMark("A");
            } else if (exam >= 75) {
                student.setMark("B");
            } else if (exam >= 60) {
                student.setMark("C");
            } else if (exam >= 50) {
                student.setMark("D");
            } else {
                throw new IllegalArgumentException("Invalid exam");
            }
        }
        studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentDto> findAllByExam(Integer exam) {
        List<Student> students = studentRepository.findAllByExamGreaterThanEqual(exam);
        return StudentMapper.INSTANCE.toDtoList(students);
    }

    public List<StudentDto> findAllByAgeBetween(Integer minAge, Integer maxAge) {
        List<Student> students = studentRepository.findAllByAgeBetween(minAge, maxAge);
        return StudentMapper.INSTANCE.toDtoList(students);
    }

}
