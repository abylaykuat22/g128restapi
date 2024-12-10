package kz.bitlab.g128springrestapi.repository;

import kz.bitlab.g128springrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByExamGreaterThanEqual(Integer exam);

    List<Student> findAllByAgeBetween(Integer minAge, Integer maxAge);

}
