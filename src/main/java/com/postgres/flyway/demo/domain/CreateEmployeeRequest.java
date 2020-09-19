package com.postgres.flyway.demo.domain;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CreateEmployeeRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;
}
