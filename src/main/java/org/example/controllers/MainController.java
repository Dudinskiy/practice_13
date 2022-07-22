package org.example.controllers;

import org.example.dao.DepartmentDAO;
import org.example.dao.EmployeeDAO;
import org.example.dao.SalGradeDAO;
import org.example.view.AddEmployeeView;
import org.example.view.GetEmployeeView;
import org.example.view.RemoveEmployeeView;
import org.example.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainController extends Controller {

    private final List<Controller> controllers = new ArrayList<>();

    public MainController(View view, EmployeeDAO employeeDAO
            , DepartmentDAO departmentDAO, SalGradeDAO salGradeDAO) {
        super(view, Controller.MAIN_MENU_ACTION);

        controllers.add(this);
        controllers.add(new GetEmployeeController(new GetEmployeeView(employeeDAO, departmentDAO, salGradeDAO)
                , Controller.GET_EMPLOYEE_ACTION));
        controllers.add(new AddEmployeeController(new AddEmployeeView(employeeDAO)
                , Controller.ADD_EMPLOYEE_ACTION));
        controllers.add(new RemoveEmployeeController(new RemoveEmployeeView(employeeDAO)
                , Controller.REMOVE_EMPLOYEE_ACTION));
    }

    public int process() {
        int action = view.printInfo();

        while (action != EXIT_ACTION) {
            for (Controller controller : controllers) {
                if (controller.canProcess(action)) {
                    action = controller.process();
                }
            }
        }
        return EXIT_ACTION;
    }
}
