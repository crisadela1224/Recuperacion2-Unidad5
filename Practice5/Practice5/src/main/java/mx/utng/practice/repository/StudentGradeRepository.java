package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.StudentGrade;

public interface StudentGradeRepository extends JpaRepository<StudentGrade, Long> {
	@Query("Select studentGrade from StudentGrade studentGrade")
	public List<StudentGrade> finAll();
}

