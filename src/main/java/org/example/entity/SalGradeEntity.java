package org.example.entity;

public class SalGradeEntity {
    private int grade;
    private float minSalary;
    private float maxSalary;

    public SalGradeEntity() {
        super();
    }

    public SalGradeEntity(int grade, float minSalary, float maxSalary) {
        this.grade = grade;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public float getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(float minSalary) {
        this.minSalary = minSalary;
    }

    public float getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(float maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "SalGradeEntity{" +
                "grade=" + grade +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
