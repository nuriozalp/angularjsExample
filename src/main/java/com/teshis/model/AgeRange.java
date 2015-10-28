/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teshis.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nuri
 */
@Entity
@Table(name = "AGE_RANGE")
@NamedQueries({
    @NamedQuery(name = "AgeRange.findAll", query = "SELECT a FROM AgeRange a")})
public class AgeRange implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @JoinTable(name = "DISEASE_AGE_RANGE", joinColumns = {
        @JoinColumn(name = "AGE_RANGE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "DISEASE_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Disease> diseaseList;
    @JoinTable(name = "SYMPTOM_AGE_RANGE", joinColumns = {
        @JoinColumn(name = "AGE_RANGE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SYMPTOM_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Symptom> symptomList;

    public AgeRange() {
    }

    public AgeRange(Integer id) {
        this.id = id;
    }

    public AgeRange(Integer id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgeRange)) {
            return false;
        }
        AgeRange other = (AgeRange) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teshis.model.AgeRange[ id=" + id + " ]";
    }
    
}
