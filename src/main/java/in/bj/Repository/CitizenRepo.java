package in.bj.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.bj.Entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
	
	
	@Query("select distinct (plan_Name) from Citizen")
	public List<String> getPlanName();
	
	@Query("select distinct (plan_Status) from Citizen")
	public List<String> getPlanStatus();

}
