package com.eats.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.function.Consumer;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eats.model.Activity;
import com.eats.model.Employee;
import com.eats.services.ActivityService;
import com.eats.services.EmployeeService;
import com.eats.utilities.Constant;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/emp-activity")
public class InsertFromJSONFileController extends Constant{

	@Autowired
	ActivityService activityService;

	@Autowired
	EmployeeService employeeService;

	/**
	 * GET emp-activity/problem-statment1 Host: http://localhost:8080/
	 * 
	 * @return HttpStatus.OK if all employees inserted successfully
	 * @throws ParseException
	 */
	@GetMapping("/problem-statment1")
	public ResponseEntity<String> getFiles() throws ParseException {
		File file = new File(JSON_FILE_PATH);
		fetchFiles(file, f -> f.getAbsolutePath());// lambda expression since JDK 1.8
		return new ResponseEntity<>("All employees record successfully inserted!", HttpStatus.OK);
	}

	/**
	 * 
	 * @param dir list of files in EmployeeActivitiesToBeProcessed resource folder
	 * @param fileConsumer 
	 * @throws ParseException
	 */
	public void fetchFiles(File dir, Consumer<File> fileConsumer) throws ParseException {
		if (dir.isDirectory()) {
			for (File file1 : dir.listFiles()) {
				// JSON parser object to parse read file
				JSONParser jsonParser = new JSONParser();
				try (FileReader reader = new FileReader(file1)) {
					Object obj = jsonParser.parse(reader);
					getJsonOfEmployee(obj.toString());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				fetchFiles(file1, fileConsumer);
			}
		} else {
			fileConsumer.accept(dir);
		}
	}

	/**
	 * A function used for save employee and their activities
	 * 
	 * @param employee is JSON as String
	 */
	public void getJsonOfEmployee(String employee) {
		JsonElement jelement = new JsonParser().parse(employee);
		JsonObject jobject = jelement.getAsJsonObject();
		Employee employeeObj = new Employee();
		employeeObj.setEmployeeId(jobject.get("employee_id").getAsLong());
		employeeService.save(employeeObj);

		JsonArray jarray = jobject.getAsJsonArray("activities");
		for (JsonElement jsonElement : jarray) {
			Activity activityObj = new Activity();
			activityObj.setActivityName(jsonElement.getAsJsonObject().get("name").getAsString());
			activityObj.setStartTime(Timestamp.valueOf(jsonElement.getAsJsonObject().get("time").getAsString()));
			activityObj.setDuration(jsonElement.getAsJsonObject().get("duration").getAsInt());
			activityObj.setEmployee(employeeObj);
			activityService.save(activityObj);
		}
	}
}
