package org.example.dao;

import org.example.entity.SalGradeEntity;

public interface SalGradeDAO {
    void createSalGrade(SalGradeEntity inputData);

    void deleteSalGradeById(int id);

    SalGradeEntity getSalGradeById(int id);

    SalGradeEntity getSalGradeBySalary(float salary);
}
