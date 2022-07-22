package org.example.dao;

import org.example.config.DataSourceConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyPostgreFactory extends DBFactory {
    private static DataSourceConfig config;
    private static Connection connection = null;

    public MyPostgreFactory(DataSourceConfig config) {
        MyPostgreFactory.config = config;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(config.getUrl()
                        , config.getUserName(), config.getPassword());
                Class.forName(config.getDriver());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOPostgresImpl();
    }

    @Override
    public DepartmentDAO getDepartmentDAO() {
        return new DepartmentDAOPostgresImpl();
    }

    @Override
    public SalGradeDAO getSalGradeDAO() {
        return new SalGradeDAOPostgresImpl();
    }
}
