package org.example.dao;

import org.example.entity.EmployeeEntity;

import java.sql.*;
import java.time.LocalDate;

public class EmployeeDAOPostgresImpl implements EmployeeDAO {

    private static final String createEmployee_query = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String getEmployeeById_query = "select * from emp where empno=?;";
    private static final String deleteEmployeeById_query = "delete from emp where empno=?;";

    @Override
    public void createEmployee(EmployeeEntity inputData) {
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(createEmployee_query)) {

            statement.setInt(1, inputData.getId());
            statement.setString(2, inputData.getName());
            statement.setString(3, inputData.getJob());
            statement.setInt(4, inputData.getManagerId());
            statement.setDate(5, Date.valueOf(inputData.getHirDate()));
            statement.setFloat(6, inputData.getSalary());
            statement.setFloat(7, inputData.getCommission());
            statement.setInt(8, inputData.getDepartmentNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(deleteEmployeeById_query)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmployeeEntity getEmployeeById(int id) {
        EmployeeEntity result = null;
        ResultSet resultSet = null;
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(getEmployeeById_query)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int number = resultSet.getInt("empno");
                String name = resultSet.getString("ename");
                String job = resultSet.getString("job");
                int managerId = resultSet.getInt("mgr");
                LocalDate hirDate = resultSet.getDate("hiredate").toLocalDate();
                float salary = resultSet.getFloat("sal");
                float commission = resultSet.getFloat("comm");
                int departmentNumber = resultSet.getInt("deptno");

                result = new EmployeeEntity();
                result.setId(number);
                result.setName(name);
                result.setJob(job);
                result.setManagerId(managerId);
                result.setHirDate(hirDate);
                result.setSalary(salary);
                result.setCommission(commission);
                result.setDepartmentNumber(departmentNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBFactory.free(resultSet);
        }
        return result;
    }
}
