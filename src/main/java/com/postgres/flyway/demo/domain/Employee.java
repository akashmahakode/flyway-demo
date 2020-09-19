package com.postgres.flyway.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Employee data to be persisted in data store
 */
@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = -7112636627990614298L;

    /**
     * Id of the employee
     */
    @Id
    @Column(name = "emp_id", nullable = false)
    private String employeeId;

    /**
     * Name of the employee
     */
    @Column(name = "emp_name", nullable = false)
    private String employeeName;

    /**
     * Email of the employee
     */
    @Column(name = "emp_email", nullable = false)
    private String employeeEmail;

    /**
     * Phone number of the employee
     */
    @Column(name = "emp_phone", nullable = false)
    private String employeePhone;
}
