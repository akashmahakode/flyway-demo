package com.postgres.flyway.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Problem json reported to the client in case of errors.
 * E.g. {
 *   "title": "NOT_FOUND",
 *   "status": 404,
 *   "details": "404 Employee( id=307) not found"
 * }
 */
@Data
@AllArgsConstructor
public class Problem {

    private String title;

    private Integer status;

    private String details;

}
