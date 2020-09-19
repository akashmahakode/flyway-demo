package com.postgres.flyway.demo.domain;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CreateEmployeeRequest {

    @NotBlank(message = "Id is missing.")
    private String id;

    @NotBlank(message = "Name is missing.")
    private String name;

    @NotBlank(message = "Email is missing.")
    private String email;

    @NotBlank(message = "Phone is missing")
    private String phone;
}
