package com.jaturon.security.employee;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/employees")
public class EmployeeManagementController {

    private static final List<Employee> EMPLOYEES = Arrays.asList(
            new Employee(1, "Alice Paul"),
            new Employee(2, "Alison Max"),
            new Employee(3, "John Owen")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINEE')")
    public List<Employee> getAllEmployee(){
        return EMPLOYEES;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('employee:write')")
    public void registerNewEmployee(@RequestBody Employee employee){
        System.out.println(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    @PreAuthorize("hasAuthority('employee:write')")
    public void deleteEmployee(@PathVariable("employeeId") Integer employeeId){
        System.out.println(employeeId);
    }
    @PutMapping(path = "{employeeId}")
    @PreAuthorize("hasAuthority('employee:write')")
    public void updateEmployee(@PathVariable("employeeId") Integer employeeId,@RequestBody Employee employee){
        System.out.println(String.format("%s %s", employeeId, employee));
    }
}
