/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teshis.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nuri
 */
@Entity
@Table(name = "SYMPTOM_QUESTION_ANSWER")
@NamedQueries({
    @NamedQuery(name = "SymptomQuestionAnswer.findAll", query = "SELECT s FROM SymptomQuestionAnswer s")})
public class SymptomQuestionAnswer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ANSWER")
    private String answer;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "ENABLED")
    private boolean enabled;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROBABILITY")
    private Double probability;
    @JoinColumn(name = "DISEASE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Disease disease;
    @JoinColumn(name = "SYMPTOM_QUESTION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SymptomQuestion symptomQuestion;

    public SymptomQuestionAnswer() {
    }

    public SymptomQuestionAnswer(Integer id) {
        this.id = id;
    }

    public SymptomQuestionAnswer(Integer id, String answer, String description, boolean enabled) {
        this.id = id;
        this.answer = answer;
        this.description = description;
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public SymptomQuestion getSymptomQuestion() {
        return symptomQuestion;
    }

    public void setSymptomQuestion(SymptomQuestion symptomQuestion) {
        this.symptomQuestion = symptomQuestion;
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
        if (!(object instanceof SymptomQuestionAnswer)) {
            return false;
        }
        SymptomQuestionAnswer other = (SymptomQuestionAnswer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teshis.model.SymptomQuestionAnswer[ id=" + id + " ]";
    }
    
}
