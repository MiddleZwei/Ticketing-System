package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employmenttype {
    private int employmentTypeId;
    private String title;

    @Id
    @Column(name = "employment_type_id", nullable = false)
    public int getEmploymentTypeId() {
        return employmentTypeId;
    }

    public void setEmploymentTypeId(int employmentTypeId) {
        this.employmentTypeId = employmentTypeId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employmenttype that = (Employmenttype) o;

        if (employmentTypeId != that.employmentTypeId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employmentTypeId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
