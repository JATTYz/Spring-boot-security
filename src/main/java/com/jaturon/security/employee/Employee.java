package com.jaturon.security.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private Integer employeeId;
    private String employeeName;
}
