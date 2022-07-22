package org.example.dao;

import org.example.entity.SalGradeEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalGradeDAOPostgresImpl implements SalGradeDAO {

    private static final String createSalGrade_query
            = "insert into salgrade values(?,?,?);";
    private static final String getSalGradeById_query
            = "select * from salgrade where grade=?;";
    private static final String getSalGradeBySalary_query
            = "select * from salgrade where minsal<= ? and hisal>= ?;";

    @Override
    public void createSalGrade(SalGradeEntity inputData) {
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(createSalGrade_query)) {

            statement.setInt(1, inputData.getGrade());
            statement.setFloat(2, inputData.getMinSalary());
            statement.setFloat(3, inputData.getMaxSalary());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSalGradeById(int id) {
        throw new UnsupportedOperationException("This method has not yet been implemented");
    }

    @Override
    public SalGradeEntity getSalGradeById(int id) {
        SalGradeEntity result = null;
        ResultSet resultSet = null;
        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(getSalGradeById_query)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                float minSalary = resultSet.getFloat(2);
                float maxSalary = resultSet.getFloat(3);

                result = new SalGradeEntity();
                result.setGrade(id);
                result.setMinSalary(minSalary);
                result.setMaxSalary(maxSalary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBFactory.free(resultSet);
        }
        return result;
    }

    @Override
    public SalGradeEntity getSalGradeBySalary(float salary) {
        SalGradeEntity result = null;
        ResultSet resultSet = null;

        try (PreparedStatement statement = MyPostgreFactory.getConnection()
                .prepareStatement(getSalGradeBySalary_query)) {
            statement.setFloat(1, salary);
            statement.setFloat(2, salary);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int grade = resultSet.getInt("grade");
                float minSalary = resultSet.getFloat("minsal");
                float maxSalary = resultSet.getFloat("hisal");

                result = new SalGradeEntity();
                result.setGrade(grade);
                result.setMinSalary(minSalary);
                result.setMaxSalary(maxSalary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBFactory.free(resultSet);
        }
        return result;
    }
}
