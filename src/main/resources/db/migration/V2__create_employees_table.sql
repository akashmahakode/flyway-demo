CREATE TABLE IF NOT EXISTS employees
(
    emp_id              VARCHAR(100)  NOT NULL PRIMARY KEY,
    emp_name            VARCHAR(100)  NOT NULL,
    emp_email           VARCHAR(100)  NOT NULL,
    emp_phone           VARCHAR(100)  NOT NULL
);

ALTER TABLE employees
    OWNER TO employees_owner;