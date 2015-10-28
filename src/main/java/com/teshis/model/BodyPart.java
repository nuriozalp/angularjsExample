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
@Table(name = "BODY_PART")
@NamedQueries({
    @NamedQuery(name = "BodyPart.findAll", query = "SELECT b FROM BodyPart b")})
public class BodyPart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "MEDICONAME")
    private String mediconame;
    @JoinTable(name = "BODY_SYMPTOM", joinColumns = {
        @JoinColumn(name = "BODY_PART_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "SYMPTOM_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Symptom> symptomList;

    public BodyPart() {
    }

    public BodyPart(Integer id) {
        this.id = id;
    }

    public BodyPart(Integer id, String name, String mediconame) {
        this.id = id;
        this.name = name;
        this.mediconame = mediconame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMediconame() {
        return mediconame;
    }

    public void setMediconame(String mediconame) {
        this.mediconame = mediconame;
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
        if (!(object instanceof BodyPart)) {
            return false;
        }
        BodyPart other = (BodyPart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teshis.model.BodyPart[ id=" + id + " ]";
    }
    
}
