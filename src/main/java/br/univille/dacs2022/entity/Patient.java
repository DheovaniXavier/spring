package br.univille.dacs2022.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// POJO - Plain Old Java Object
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(length = 50)
    private String name;
    private String sex;

    @Temporal(value = TemporalType.DATE)
    private Date birthDate;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private City city;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private List<HealthPlan> healthPlan;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<HealthPlan> getPlans() {
        return healthPlan;
    }

    public void setPlans(List<HealthPlan> healthPlan) {
        this.healthPlan = healthPlan;
    }

}