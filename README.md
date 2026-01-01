# HealthCheckService
A simple health check service that monitors 3 endpoints and exposes metrics via /health

**#Project Overview**

This project is a simple health check service built as part of the Npontu Technologies – Platforms Developer Officer Intern interview assignment.
The service monitors three backend services (endpoints) and exposes their health status through a single /health endpoint. It is designed to help detect service failures early and support production monitoring.

Thehealth check service monitors
1. The database service
2. The Cache service
3. The external API service

Each service is checked by making an HTTP request and evaluating the response.

**#How failure is detected**
A service is considered DOWN when:
	•	It does not respond within the expected time
	•	It returns an error status code 
	•	The connection fails completely

The health check service periodically checks each endpoint and updates their status accordingly.


**#How to Run the Project**
	1.	Clone the repository
	2.	Install dependencies
	3.	Start the application
	4.	Access the health check at:
  http://localhost:<port>/actuator/health
