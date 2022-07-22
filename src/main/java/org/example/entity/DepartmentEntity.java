package org.example.entity;

public class DepartmentEntity {
    private int number;
    private String name;
    private String location;

    public DepartmentEntity() {
        super();
    }

    public DepartmentEntity(int number, String name, String location) {
        this.number = number;
        this.name = name;
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
