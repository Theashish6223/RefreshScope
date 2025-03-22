package com.ashish.refreshscope.controller;

import com.ashish.refreshscope.dto.EmployeeDto;
import com.ashish.refreshscope.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/all")
    public List<EmployeeDto> getAll(){
        return employeeService.getEmployeeList();
    }
}
