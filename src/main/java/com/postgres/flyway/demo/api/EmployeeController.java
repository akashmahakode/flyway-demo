package com.postgres.flyway.demo.api;

import com.postgres.flyway.demo.domain.CreateEmployeeRequest;
import com.postgres.flyway.demo.domain.Employee;
import com.postgres.flyway.demo.domain.EmployeeService;
import com.postgres.flyway.demo.exception.Problem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Controller class to accept requests to create and store employees
 * and retrieves an employee
 */
@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Loads employee from data store specified by employee id
     * @param id employee id
     * @return employee details if found else htpp status 404
     */
    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Employee> loadEmployee(@PathVariable("id") String id){
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * Create and store the employee in the data store
     * @param inputData Employee data to be stored
     * @return saved employee.
     */
    @PostMapping(value = {"", "/"})
    public ResponseEntity<Employee> saveEmployee(@RequestBody CreateEmployeeRequest inputData){
        Employee employee = employeeService.saveEmployee(inputData);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<Problem> handleException(HttpClientErrorException exception){
        log.error("Returning HTTP_STATUS : {}, {}", exception.getStatusCode(), exception.getLocalizedMessage());
        return new ResponseEntity<>(
                new Problem(exception.getStatusCode().name(), exception.getStatusCode().value(), exception.getLocalizedMessage()),
                exception.getStatusCode());
    }
}
