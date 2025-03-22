package com.ashish.refreshscope.service;

import com.ashish.refreshscope.dto.EmployeeDto;
import com.ashish.refreshscope.entity.Employee;
import com.ashish.refreshscope.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> getEmployeeList(){
        Iterable<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        Consumer<Employee> consumer = employee -> employeeDtoList.add(new EmployeeDto(employee.getId(), employee.getName()));
        employeeList.forEach(consumer);
        return employeeDtoList;
    }
}
