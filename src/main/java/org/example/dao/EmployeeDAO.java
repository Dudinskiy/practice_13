package org.example.dao;

import org.example.entity.EmployeeEntity;

public interface EmployeeDAO {
    void createEmployee(EmployeeEntity inputData);

    void deleteEmployeeById(int id);

    EmployeeEntity getEmployeeById(int id);
}
