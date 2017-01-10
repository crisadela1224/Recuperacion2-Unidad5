package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.utng.practice.model.MemberShip;

;

public interface MemberShipRepository extends JpaRepository<MemberShip, Long>{
	@Query("Select memberShip from MemberShip memberShip")
	public List<MemberShip> finAll();
}
