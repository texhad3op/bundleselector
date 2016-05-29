package lt.seb.testing;

import lt.seb.testing.resolver.types.Bundle;

public class CheckAnswer {
    private Integer age;
    private Boolean isStudent;
    private Integer income;
    private Bundle expectedBundle;
    private Bundle realBundle;
    private Boolean bundleIsCorrect;

    public CheckAnswer(Integer age, Boolean isStudent, Integer income, Bundle expectedBundle, Bundle realBundle,
            Boolean bundleIsCorrect) {
        this.age = age;
        this.isStudent = isStudent;
        this.income = income;
        this.expectedBundle = expectedBundle;
        this.realBundle = realBundle;
        this.bundleIsCorrect = bundleIsCorrect;
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

    public Bundle getExpectedBundle() {
        return expectedBundle;
    }

    public void setExpectedBundle(Bundle expectedBundle) {
        this.expectedBundle = expectedBundle;
    }

    public Bundle getRealBundle() {
        return realBundle;
    }

    public void setRealBundle(Bundle realBundle) {
        this.realBundle = realBundle;
    }

    public Boolean getBundleIsCorrect() {
        return bundleIsCorrect;
    }

    public void setBundleIsCorrect(Boolean bundleIsCorrect) {
        this.bundleIsCorrect = bundleIsCorrect;
    }

}
