Run eats
	inbuilt server of spring boot

Prerequisites
	Git
	JDK 8 or later
	Maven 3.0 or later
	MySQL Version 5.0 or later
	
Configurations
	Open the application.properties file and set your own configurations for the database connection.

Actuator
To monitor and manage your application
	URL	Method
	http://localhost:8080/emp-activity/problem-statment1	GET
	http://localhost:8080/emp-activity/problem-statment2	GET
	
	
-----------------------------------------------------------------------------------------------------------------
|							Other Info																			|
|		1.	JSON files folder	E:\\WorkspaceJava\\eats\\src\\main\\resources\\EmployeeActivitiesToBeProcessed  |
|			you can change it from com.eats.utilities.Constant	as per your requirement/path					|
|																												|
|		2. Attached eats_db.sql for DDL and DDL statements 														|
-------------------------------------------------------------------------------	----------------------------------
	
	
-------------------------------------------------------------------------------
|							JSON Response: of 									|
|				http://localhost:8080/emp-activity/problem-statment2			|
|				Note :- maybe different as per LocalDateTime					|
-------------------------------------------------------------------------------
{
    "all_employees_last_7_days_statistics": [
        {
            "activity_name": "login",
            "occurrence": 13
        },
        {
            "activity_name": "teabreak",
            "occurrence": 3
        },
        {
            "activity_name": "logout",
            "occurrence": 2
        },
        {
            "activity_name": "naptime",
            "occurrence": 2
        },
        {
            "activity_name": "gamemood",
            "occurrence": 2
        },
        {
            "activity_name": "lunchbreak",
            "occurrence": 1
        }
    ],
    "todays_activites": [
        {
            "employee_id": 530003,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                },
                {
                    "name": "teabreak",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                },
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                },
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                }
            ]
        },
        {
            "employee_id": 530004,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                },
                {
                    "name": "teabreak",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                },
                {
                    "name": "logout",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        },
        {
            "employee_id": 530005,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                },
                {
                    "name": "teabreak",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                },
                {
                    "name": "lunchbreak",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        },
        {
            "employee_id": 530007,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                },
                {
                    "name": "gamemood",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        },
        {
            "employee_id": 530009,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                },
                {
                    "name": "naptime",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        },
        {
            "employee_id": 530010,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                },
                {
                    "name": "naptime",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        },
        {
            "employee_id": 530012,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                },
                {
                    "name": "gamemood",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                }
            ]
        },
        {
            "employee_id": 530013,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                },
                {
                    "name": "logout",
                    "start_time": "2020-01-19T20:30:20.000+0000"
                }
            ]
        },
        {
            "employee_id": 530008,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        },
        {
            "employee_id": 530011,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        },
        {
            "employee_id": 530006,
            "activities": [
                {
                    "name": "login",
                    "start_time": "2020-01-19T20:30:21.000+0000"
                }
            ]
        }
    ]
}
-------------------------------------------------------------------------------
|									END 										|
|				http://localhost:8080/emp-activity/problem-statment2			|
-------------------------------------------------------------------------------