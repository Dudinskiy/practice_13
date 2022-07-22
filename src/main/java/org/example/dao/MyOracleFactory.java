package org.example.dao;

public class MyOracleFactory extends DBFactory{
    @Override
    public EmployeeDAO getEmployeeDAO() {
        return null;
    }

    @Override
    public DepartmentDAO getDepartmentDAO() {
        return null;
    }

    @Override
    public SalGradeDAO getSalGradeDAO() {
        return null;
    }
}
