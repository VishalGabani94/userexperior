package com.eats.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eats.model.Activity;
import com.eats.services.ActivityService;
import com.eats.services.EmployeeService;
import com.eats.utilities.Utilities;

@RestController
@RequestMapping("/emp-activity")
public class GetActivityController extends Utilities{

	@Autowired
	ActivityService activityService;
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * GET emp-activity/problem-statment2 Host: http://localhost:8080/
	 * Accept: application/json,text/javascript
	 * 
	 * @return HttpStatus.OK and JSON of statistics
	 */
	@GetMapping("/problem-statment2")
	public ResponseEntity<?> getActivityOfEmployee(){
		Map<String,Object> statistics = new LinkedHashMap<>();
		statistics.put("all_employees_last_7_days_statistics", employeeSevenDaysActivity());
		statistics.put("todays_activites", todaysActivites());
		return new ResponseEntity<>(statistics,HttpStatus.OK);
	}
	
	/**
	 * A function used for calculate last 7 days occurrence of activity 
	 * Duration feature since JDK 1.8
	 * 
	 * Utilities specific extension of
	 * {@link com.eats.utilities.Utilities}
	 * 
	 * @return ArrayList<Object>
	 */
	public ArrayList<Object> employeeSevenDaysActivity() {
		return activityService
				.findNameAndOccurrOfSevenDays(getDateByLastHrOrDtOr(Duration.ofDays(7)), todaysDate());
	}
	
	/**
	 * A function used for calculate last 24hr activities
	 * 
	 * * Duration feature since JDK 1.8
	 * 
	 * Utilities specific extension of
	 * {@link com.eats.utilities.Utilities}
	 * 
	 * @return ArrayList<Object>
	 */
	public ArrayList<Object> todaysActivites() {
		Date lclDT = todaysDate();
		Date lclDTLastTFHr = getDateByLastHrOrDtOr(Duration.ofHours(24));

		ArrayList<Object> todaysActivitesArray = new ArrayList<Object>();
		List<Activity> eIdOrderByActivty = activityService.sortEidBasedOnActivity(lclDTLastTFHr, lclDT);

		for (Activity activityInfo : eIdOrderByActivty) {
			Map<String, Object> todaysActivitesObj = new LinkedHashMap<>();
			todaysActivitesObj.put("employee_id", activityInfo.getEmployee().getEmployeeId());
			todaysActivitesObj.put("activities", activityService
					.findByEidOrdByStrTimeOfLastTFHr(activityInfo.getEmployee().getId(), lclDTLastTFHr, lclDT));
			todaysActivitesArray.add(todaysActivitesObj);
		}
		return todaysActivitesArray;
	}
	
}
