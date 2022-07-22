package org.example.utils;

import org.example.entity.DepartmentEntity;
import org.example.entity.EmployeeEntity;
import org.example.entity.SalGradeEntity;


public class PrintInfo {
    private PrintInfo() {
    }

    public static void printEmployeeAllInfo(EmployeeEntity employee
            , DepartmentEntity department
            , SalGradeEntity grade) {
        if (employee == null || department == null || grade == null) {
            System.out.println("Нет данных для печати");
            return;
        }

        StringBuilder builder = new StringBuilder("Данные о сотруднике:\n");
        builder.append("1) индивидуальный номер - ").append(employee.getId()).append("\n");
        builder.append("2) имя - ").append(employee.getName()).append("\n");
        builder.append("3) должность - ").append(employee.getJob()).append("\n");
        builder.append("4) индивидуальный номер руководителя - ").append(employee.getManagerId()).append("\n");
        builder.append("5) дата приема на работу - ").append(employee.getHirDate()).append("\n");
        builder.append("6) размер оклад - ").append(employee.getSalary()).append("\n");
        builder.append("7) категория оклада - ").append(grade.getGrade()).append("\n");
        builder.append("8) размер комиссионных - ").append(employee.getCommission()).append("\n");
        builder.append("9) номер подразделения - ").append(employee.getDepartmentNumber()).append("\n");
        builder.append("10) название подразделения - ").append(department.getName()).append("\n");
        builder.append("11) расположение - ").append(department.getLocation());

        System.out.println(builder);
    }
}
