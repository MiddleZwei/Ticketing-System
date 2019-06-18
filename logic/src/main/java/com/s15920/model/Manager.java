package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
    private int managerId;
    private String education;
    private Double yearsOfExperience;

    @Id
    @Column(name = "manager_id", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "education", nullable = true, length = 300)
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "years_of_experience", nullable = true, precision = 0)
    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (managerId != manager.managerId) return false;
        if (education != null ? !education.equals(manager.education) : manager.education != null) return false;
        if (yearsOfExperience != null ? !yearsOfExperience.equals(manager.yearsOfExperience) : manager.yearsOfExperience != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = managerId;
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (yearsOfExperience != null ? yearsOfExperience.hashCode() : 0);
        return result;
    }
}
