/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teshis.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nuri
 */
@Entity
@Table(name = "SYMPTOM")
@NamedQueries({
    @NamedQuery(name = "Symptom.findAll", query = "SELECT s FROM Symptom s")})
public class Symptom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "UID")
    private String uid;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "MEDICONAME")
    private String mediconame;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ALERT_MESSAGE")
    private String alertMessage;
    @Basic(optional = false)
    @Column(name = "ENABLED")
    private boolean enabled;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROBABILITY")
    private Double probability;
    @Column(name = "TOTAL_DISPLAY")
    private Integer totalDisplay;
    @Column(name = "RISK_SEVERNITY")
    private Integer riskSevernity;
    @Column(name = "GENDER_ID")
    private Integer genderId;
    @Basic(optional = false)
    @Lob
    @Column(name = "REFERANCES")
    private String referances;
    @ManyToMany(mappedBy = "symptomList", fetch = FetchType.LAZY)
    private List<BodyPart> bodyPartList;
    @ManyToMany(mappedBy = "symptomList", fetch = FetchType.LAZY)
    private List<AgeRange> ageRangeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "symptom", fetch = FetchType.LAZY)
    private List<SymptomQuestion> symptomQuestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "symptom", fetch = FetchType.LAZY)
    private List<DiseaseSymptom> diseaseSymptomList;

    public Symptom() {
    }

    public Symptom(Integer id) {
        this.id = id;
    }

    public Symptom(Integer id, String name, boolean enabled, String referances) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
        this.referances = referances;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Integer getTotalDisplay() {
        return totalDisplay;
    }

    public void setTotalDisplay(Integer totalDisplay) {
        this.totalDisplay = totalDisplay;
    }

    public Integer getRiskSevernity() {
        return riskSevernity;
    }

    public void setRiskSevernity(Integer riskSevernity) {
        this.riskSevernity = riskSevernity;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getReferances() {
        return referances;
    }

    public void setReferances(String referances) {
        this.referances = referances;
    }

    public List<BodyPart> getBodyPartList() {
        return bodyPartList;
    }

    public void setBodyPartList(List<BodyPart> bodyPartList) {
        this.bodyPartList = bodyPartList;
    }

    public List<AgeRange> getAgeRangeList() {
        return ageRangeList;
    }

    public void setAgeRangeList(List<AgeRange> ageRangeList) {
        this.ageRangeList = ageRangeList;
    }

    public List<SymptomQuestion> getSymptomQuestionList() {
        return symptomQuestionList;
    }

    public void setSymptomQuestionList(List<SymptomQuestion> symptomQuestionList) {
        this.symptomQuestionList = symptomQuestionList;
    }

    public List<DiseaseSymptom> getDiseaseSymptomList() {
        return diseaseSymptomList;
    }

    public void setDiseaseSymptomList(List<DiseaseSymptom> diseaseSymptomList) {
        this.diseaseSymptomList = diseaseSymptomList;
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
        if (!(object instanceof Symptom)) {
            return false;
        }
        Symptom other = (Symptom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teshis.model.Symptom[ id=" + id + " ]";
    }
    
}
