package com.postgres.flyway.demo.domain;

import com.postgres.flyway.demo.metrics.EmployeeCounterMetrics;
import com.postgres.flyway.demo.metrics.EmployeeGaugeMetrics;
import com.postgres.flyway.demo.persistence.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final EmployeeCounterMetrics counterMetrics;

    public EmployeeService(EmployeeRepository hierarchyRepository, EmployeeCounterMetrics metrics){
        this.repository = hierarchyRepository;
        this.counterMetrics = metrics;
    }

    /**
     * Create and store the employee in data store.
     * @param employeeRequest input data of the employee to be stored
     * @return saved employee
     */
    public Employee saveEmployee(CreateEmployeeRequest employeeRequest) {

        Employee employee = createEmployee(employeeRequest);

        // Incrementing the counter whenever employee is created
        counterMetrics.incrementCounter();

        return repository.save(employee);
    }

    /**
     * Retrieve an employee from the data store.
     * @param id Employee identifier
     * @return employee details of the employee specified by id.
     */
    public Employee getEmployee(String id) {
        return repository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
                String.format("Employee( id=%s) not found", id)));
    }

    private Employee createEmployee(CreateEmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeRequest.getId());
        employee.setEmployeeName(employeeRequest.getName());
        employee.setEmployeeEmail(employeeRequest.getEmail());
        employee.setEmployeePhone(employeeRequest.getPhone());
        return employee;
    }

    public void getEmployeeCount() {
        EmployeeGaugeMetrics.EMPLOYEE_COUNT.set((int)repository.count());
    }
}
