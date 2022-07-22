package org.example.view;

import org.example.controllers.Controller;
import org.example.dao.DepartmentDAO;
import org.example.dao.EmployeeDAO;
import org.example.dao.SalGradeDAO;
import org.example.entity.DepartmentEntity;
import org.example.entity.EmployeeEntity;
import org.example.entity.SalGradeEntity;
import org.example.utils.PrintInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetEmployeeView implements View {

    private final EmployeeDAO employeeDAO;
    private final DepartmentDAO departmentDAO;
    private final SalGradeDAO salGradeDAO;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public GetEmployeeView(EmployeeDAO employeeDAO, DepartmentDAO departmentDAO, SalGradeDAO salGradeDAO) {
        this.employeeDAO = employeeDAO;
        this.departmentDAO = departmentDAO;
        this.salGradeDAO = salGradeDAO;
    }

    @Override
    public int printInfo() {
        System.out.println("Введите индивидуальный номер сотрудника");
        try {
            int employeeId = Integer.parseInt(reader.readLine());
            EmployeeEntity employee = employeeDAO.getEmployeeById(employeeId);
            if(employee==null){
                System.out.println("Сотрудник с указанным номером отсутствует");
                System.out.println("\n==================");
                return Controller.MAIN_MENU_ACTION;
            }
            SalGradeEntity salGrade = salGradeDAO.getSalGradeBySalary(employee.getSalary());
            DepartmentEntity department = departmentDAO.getDepartmentById(employee.getDepartmentNumber());
            PrintInfo.printEmployeeAllInfo(employee, department, salGrade);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n==================");
        return Controller.MAIN_MENU_ACTION;
    }
}
