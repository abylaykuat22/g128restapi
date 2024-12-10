package kz.bitlab.g128springrestapi.controller;

import kz.bitlab.g128springrestapi.dtos.StudentCreate;
import kz.bitlab.g128springrestapi.dtos.StudentEdit;
import kz.bitlab.g128springrestapi.dtos.StudentView;
import kz.bitlab.g128springrestapi.entity.Student;
import kz.bitlab.g128springrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentView> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public StudentView getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void createStudent(@RequestBody StudentCreate studentCreate) {
        studentService.create(studentCreate);
    }

    @PutMapping
    public void updateStudent(@RequestBody StudentEdit student) {
        studentService.update(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/find-by-exam")
    public List<StudentView> findStudents(@RequestParam Integer exam) {
        return studentService.findAllByExam(exam);
    }

    @GetMapping("/find-by-age-between")
    public List<StudentView> findStudentsBetween(@RequestParam(name = "min_age") Integer minAge, @RequestParam(name = "max_age") Integer maxAge) {
        return studentService.findAllByAgeBetween(minAge, maxAge);
    }

}
