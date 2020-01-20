package com.eats.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eats.model.Activity;
import com.eats.repository.ActivityRepository;
import com.eats.services.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	ActivityRepository activityRepository;
	
	@Override
	public ArrayList<Object> findNameAndOccurrOfSevenDays(Date sartDateTime, Date endDateTime) {
		List<Activity> activityList = activityRepository.findNameAndOccurrOfSevenDays(sartDateTime,endDateTime);
		ArrayList<Object> activityJsonArray = new ArrayList<>();
		for (Activity activity : activityList) {
			Map<String, Object> activityJsonObj = new HashMap<>();
			activityJsonObj.put("activity_name", activity.getActivityName());
			activityJsonObj.put("occurrence", activity.getOccurrence());
			activityJsonArray.add(activityJsonObj);
		}
		return activityJsonArray;
	}

	@Override
	public ArrayList<Object> findByEidOrdByStrTimeOfLastTFHr(int eId,Date sartDateTime, Date endDateTime) {
		List<Activity> activityInfoOfLast24Hours = activityRepository.findByEidOrdByStrTimeOfLastTFHr(eId,sartDateTime,endDateTime);
		ArrayList<Object> last24HourActiviesArray = new ArrayList<>();
		for (Activity activity : activityInfoOfLast24Hours) {
			Map<String,Object> activiyInfo = new LinkedHashMap<>();
			activiyInfo.put("name", activity.getActivityName());
			activiyInfo.put("start_time", activity.getStartTime());
			last24HourActiviesArray.add(activiyInfo);
		}
		return last24HourActiviesArray;
	}

	@Override
	public List<Activity> sortEidBasedOnActivity(Date sartDateTime, Date endDateTime) {
		return activityRepository.sortEidBasedOnActivity(sartDateTime,endDateTime);
	}

	@Override
	public Activity save(Activity activityInfo) {
		return activityRepository.save(activityInfo);
	}
}
