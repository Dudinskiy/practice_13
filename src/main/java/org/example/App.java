package org.example;

import org.example.config.DataSourceConfig;
import org.example.controllers.Controller;
import org.example.controllers.MainController;
import org.example.entity.DepartmentEntity;
import org.example.entity.EmployeeEntity;
import org.example.entity.SalGradeEntity;
import org.example.dao.*;
import org.example.enums.DBType;
import org.example.utils.PrintInfo;
import org.example.utils.XmlParser;
import org.example.view.MainView;
import org.example.view.View;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        DataSourceConfig sourceConfig;
        try {
            File file = new File("dataSourceConfig.xml");
            sourceConfig = XmlParser.convertFromXml(file, true);
        } catch (ParserConfigurationException|IOException|SAXException e){
            e.getCause();
            System.out.println("Не удалось соединиться с базой данных");
            return;
        }

        DBFactory factory = DBFactory.getDBFactory(DBType.POSTGRE, sourceConfig);

        EmployeeDAO employeeDAO = factory.getEmployeeDAO();
        SalGradeDAO salGradeDAO = factory.getSalGradeDAO();
        DepartmentDAO departmentDAO = factory.getDepartmentDAO();

        View mainView = new MainView();
        Controller mainController = new MainController(mainView
                , employeeDAO, departmentDAO, salGradeDAO);
        mainController.process();
    }
}
