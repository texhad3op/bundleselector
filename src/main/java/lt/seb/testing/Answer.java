package lt.seb.testing;

import lt.seb.testing.resolver.types.Bundle;

public class Answer {
    private Integer age;
    private Boolean isStudent;
    private Integer income;
    private Bundle bundle;

    public Answer(Integer age, Boolean isStudent, Integer income, Bundle bundle) {
        this.age = age;
        this.isStudent = isStudent;
        this.income = income;
        this.bundle = bundle;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(Boolean isStudent) {
        this.isStudent = isStudent;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

}
