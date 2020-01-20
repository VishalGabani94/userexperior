package com.eats.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.json.JSONObject;

@Entity
@Table(name = "activity")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "id")
	private int id;
	
	@Column(name = "activity_name")
	private String activityName;
	
	@CreationTimestamp
	private Timestamp startTime;
	
	@Column(name = "duration")
	private int duration;
	
	@ManyToOne
	@JoinColumn(name="e_id")
	private Employee employee;
	
	@Transient
	private Long occurrence;

	public int getId() {
		return id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Long getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(Long occurrence) {
		this.occurrence = occurrence;
	}

	public Activity() {}
	
	public Activity(String activityName, Long occurrence) {
	    this.activityName = activityName;
	    this.occurrence  = occurrence;
	 }
	
	public Activity(Employee eId, Long occurrence) {
		this.employee = eId;
	    this.occurrence  = occurrence;
	 }

	@Override
	public String toString() {
		return "Activity [id=" + id + ", activityName=" + activityName + ", startTime=" + startTime + ", employee="
				+ employee + "]";
	}
}
