package com.eats.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eats.model.Activity;

public interface ActivityService {
	
	ArrayList<Object> findNameAndOccurrOfSevenDays(Date sartDateTime, Date endDateTime);

	ArrayList<Object> findByEidOrdByStrTimeOfLastTFHr(int eId,Date sartDateTime, Date endDateTime);

	List<Activity> sortEidBasedOnActivity(Date sartDateTime, Date endDateTime);

	Activity save(Activity activityInfo);

}
