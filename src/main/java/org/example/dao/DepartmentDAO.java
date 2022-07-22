package org.example.dao;

import org.example.entity.DepartmentEntity;

public interface DepartmentDAO {
    void createDepartment(DepartmentEntity inputData);

    void deleteDepartmentById(int id);

    DepartmentEntity getDepartmentById(int id);
}
