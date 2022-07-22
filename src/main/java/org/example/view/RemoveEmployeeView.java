package org.example.view;

import org.example.controllers.Controller;
import org.example.dao.EmployeeDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveEmployeeView implements View {

    private final EmployeeDAO employeeDAO;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public RemoveEmployeeView(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public int printInfo() {
        System.out.println("Введите индивидуальный номер сотрудника");
        try {
            int employeeId = Integer.parseInt(reader.readLine());
            employeeDAO.deleteEmployeeById(employeeId);
            System.out.println("Сотрудник удален");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n==================");
        return Controller.MAIN_MENU_ACTION;
    }
}
