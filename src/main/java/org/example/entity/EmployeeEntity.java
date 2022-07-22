package org.example.entity;

import java.time.LocalDate;

public class EmployeeEntity {
    private int id;
    private String name;
    private String job;
    private int managerId;
    private LocalDate hirDate;
    private float salary;
    private float commission;
    private int departmentNumber;

    public EmployeeEntity() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public LocalDate getHirDate() {
        return hirDate;
    }

    public void setHirDate(LocalDate hirDate) {
        this.hirDate = hirDate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", managerId=" + managerId +
                ", hirDate=" + hirDate +
                ", salary=" + salary +
                ", commission=" + commission +
                ", departmentNumber=" + departmentNumber +
                '}';
    }
}
