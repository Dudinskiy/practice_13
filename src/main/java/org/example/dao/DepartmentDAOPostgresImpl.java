package org.example.dao;

import org.example.entity.DepartmentEntity;

import java.sql.*;

public class DepartmentDAOPostgresImpl implements DepartmentDAO {

    private static final String createDepartment_query
            = "insert into dept values(?,?,?);";
    private static final String getDepartmentById_query
            = "select * from dept where deptno=?;";
    private static final String deleteDepartmentById_query
            = "delete from dept where deptno=?;";

    @Override
    public void createDepartment(DepartmentEntity inputData) {
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(createDepartment_query)) {

            statement.setInt(1, inputData.getNumber());
            statement.setString(2, inputData.getName());
            statement.setString(3, inputData.getLocation());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartmentById(int id) {
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(deleteDepartmentById_query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DepartmentEntity getDepartmentById(int id) {
        DepartmentEntity result = null;
        ResultSet resultSet = null;
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(getDepartmentById_query)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int number = resultSet.getInt("deptno");
                String name = resultSet.getString("dname");
                String location = resultSet.getString("loc");

                result = new DepartmentEntity();
                result.setNumber(number);
                result.setName(name);
                result.setLocation(location);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBFactory.free(resultSet);
        }
        return result;
    }
}
