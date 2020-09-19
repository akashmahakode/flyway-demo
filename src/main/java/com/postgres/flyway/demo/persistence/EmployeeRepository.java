package com.postgres.flyway.demo.persistence;

import com.postgres.flyway.demo.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface to perform CRUD operations on "employees" data store
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {}
