package org.example.view;

import org.example.controllers.Controller;
import org.example.dao.EmployeeDAO;
import org.example.entity.EmployeeEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddEmployeeView implements View {

    private final EmployeeDAO employeeDAO;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public AddEmployeeView(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public int printInfo() {
        try {
            EmployeeEntity employee = new EmployeeEntity();

            System.out.println("Введите индивидуальный номер:");
            int empNumber = Integer.parseInt(reader.readLine());
            employee.setId(empNumber);

            System.out.println("Введите имя:");
            String name = reader.readLine();
            employee.setName(name);

            System.out.println("Введите должность:");
            String job = reader.readLine();
            employee.setJob(job);

            System.out.println("Введите индивидуальный номер руководителя:");
            int mgrNumber = Integer.parseInt(reader.readLine());
            employee.setManagerId(mgrNumber);

            System.out.println("Введите дату приема на работу:");
            String date = reader.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            employee.setHirDate(LocalDate.parse(date, formatter));

            System.out.println("Введите размер оклад:");
            float salary = Float.parseFloat(reader.readLine());
            employee.setSalary(salary);

            System.out.println("Введите размер комиссионных:");
            float commission = Float.parseFloat(reader.readLine());
            employee.setCommission(commission);

            System.out.println("Введите номер подразделения:");
            int depNumber = Integer.parseInt(reader.readLine());
            employee.setDepartmentNumber(depNumber);

            employeeDAO.createEmployee(employee);
            System.out.println("Сотрудник добавлен");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n==================");
        return Controller.MAIN_MENU_ACTION;
    }
}
