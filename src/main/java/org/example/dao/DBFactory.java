package org.example.dao;

import org.example.config.DataSourceConfig;
import org.example.enums.DBType;

import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class DBFactory {

    public abstract EmployeeDAO getEmployeeDAO();
    public abstract DepartmentDAO getDepartmentDAO();
    public abstract SalGradeDAO getSalGradeDAO();

    public static DBFactory getDBFactory(DBType type, DataSourceConfig config) {
        switch (type) {
            case POSTGRE:
                return new MyPostgreFactory(config);
            case ORACLE:
                return new MyOracleFactory();
            default:
                return null;
        }
    }

    public static void free(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
