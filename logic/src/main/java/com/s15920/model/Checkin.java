package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Checkin {
    private int checkInId;
    private Date hireDate;
    private Date fireDate;
    private Integer employmentId;

    @Id
    @Column(name = "check_in_id", nullable = false)
    public int getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(int checkInId) {
        this.checkInId = checkInId;
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
    @Column(name = "employment_id", nullable = true)
    public Integer getEmploymentId() {
        return employmentId;
    }

    public void setEmploymentId(Integer employmentId) {
        this.employmentId = employmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Checkin checkin = (Checkin) o;

        if (checkInId != checkin.checkInId) return false;
        if (hireDate != null ? !hireDate.equals(checkin.hireDate) : checkin.hireDate != null) return false;
        if (fireDate != null ? !fireDate.equals(checkin.fireDate) : checkin.fireDate != null) return false;
        if (employmentId != null ? !employmentId.equals(checkin.employmentId) : checkin.employmentId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkInId;
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (fireDate != null ? fireDate.hashCode() : 0);
        result = 31 * result + (employmentId != null ? employmentId.hashCode() : 0);
        return result;
    }
}
