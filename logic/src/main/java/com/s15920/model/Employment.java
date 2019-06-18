package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Employment {
    private int employmentId;
    private Date hireDate;
    private Date fireDate;
    private String title;
    private Double wage;
    private Double total;
    private byte refunded;
    private Integer employmentTypeId;
    private Integer personId;

    @Id
    @Column(name = "employment_id", nullable = false)
    public int getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(int employmentId) {
        this.employmentId = employmentId;
    }

    @Basic
    @Column(name = "hire_date", nullable = true)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "fire_date", nullable = true)
    public Date getFireDate() {
        return fireDate;
    }

    public void setFireDate(Date fireDate) {
        this.fireDate = fireDate;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "wage", nullable = true, precision = 0)
    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    @Basic
    @Column(name = "total", nullable = true, precision = 0)
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "refunded", nullable = false)
    public byte getRefunded() {
        return refunded;
    }

    public void setRefunded(byte refunded) {
        this.refunded = refunded;
    }

    @Basic
    @Column(name = "employment_type_id", nullable = true)
    public Integer getEmploymentTypeId() {
        return employmentTypeId;
    }

    public void setEmploymentTypeId(Integer employmentTypeId) {
        this.employmentTypeId = employmentTypeId;
    }

    @Basic
    @Column(name = "person_id", nullable = true)
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employment that = (Employment) o;

        if (employmentId != that.employmentId) return false;
        if (refunded != that.refunded) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;
        if (fireDate != null ? !fireDate.equals(that.fireDate) : that.fireDate != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (wage != null ? !wage.equals(that.wage) : that.wage != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (employmentTypeId != null ? !employmentTypeId.equals(that.employmentTypeId) : that.employmentTypeId != null)
            return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employmentId;
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (fireDate != null ? fireDate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (wage != null ? wage.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (int) refunded;
        result = 31 * result + (employmentTypeId != null ? employmentTypeId.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        return result;
    }
}
