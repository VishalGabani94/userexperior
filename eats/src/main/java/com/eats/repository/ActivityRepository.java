package com.eats.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eats.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long>{

	@Query("SELECT new Activity(a.activityName,COUNT(a) as occurrence) FROM Activity a WHERE a.startTime BETWEEN :sartDateTime AND :endDateTime GROUP BY a.activityName ORDER BY occurrence DESC")
	List<Activity> findNameAndOccurrOfSevenDays(@Param("sartDateTime") Date sartDateTime,@Param("endDateTime")Date endDateTime);

	@Query("SELECT a FROM Activity a WHERE a.employee.id = :eId AND a.startTime BETWEEN :sartDateTime AND :endDateTime ORDER BY a.startTime")
	List<Activity> findByEidOrdByStrTimeOfLastTFHr(@Param("eId")int eId,@Param("sartDateTime")Date sartDateTime,@Param("endDateTime")Date endDateTime);
	
	@Query("SELECT new Activity(a.employee,COUNT(a) as occurrence) FROM Activity a WHERE a.startTime BETWEEN :sartDateTime AND :endDateTime GROUP BY a.employee.employeeId ORDER BY occurrence DESC")
	List<Activity> sortEidBasedOnActivity(@Param("sartDateTime") Date sartDateTime,@Param("endDateTime")Date endDateTime);
}
