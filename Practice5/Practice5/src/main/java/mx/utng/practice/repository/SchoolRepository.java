package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.School;


public interface SchoolRepository extends JpaRepository<School, Long> {
	@Query("Select school from School school")
	public List<School> finAll();
}
