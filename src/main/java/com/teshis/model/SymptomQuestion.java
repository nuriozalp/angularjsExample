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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author nuri
 */
@Entity
@Table(name = "SYMPTOM_QUESTION")
@NamedQueries({
    @NamedQuery(name = "SymptomQuestion.findAll", query = "SELECT s FROM SymptomQuestion s")})
public class SymptomQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "QUESTION")
    private String question;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "ENABLED")
    private boolean enabled;
    @Basic(optional = false)
    @Column(name = "QUESTION_TYPE_ID")
    private int questionTypeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROBABILITY")
    private Double probability;
    @JoinColumn(name = "SYMPTOM_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Symptom symptom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "symptomQuestion", fetch = FetchType.LAZY)
    private List<SymptomQuestionAnswer> symptomQuestionAnswerList;

    public SymptomQuestion() {
    }

    public SymptomQuestion(Integer id) {
        this.id = id;
    }

    public SymptomQuestion(Integer id, String question, String description, boolean enabled, int questionTypeId) {
        this.id = id;
        this.question = question;
        this.description = description;
        this.enabled = enabled;
        this.questionTypeId = questionTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public List<SymptomQuestionAnswer> getSymptomQuestionAnswerList() {
        return symptomQuestionAnswerList;
    }

    public void setSymptomQuestionAnswerList(List<SymptomQuestionAnswer> symptomQuestionAnswerList) {
        this.symptomQuestionAnswerList = symptomQuestionAnswerList;
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
        if (!(object instanceof SymptomQuestion)) {
            return false;
        }
        SymptomQuestion other = (SymptomQuestion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teshis.model.SymptomQuestion[ id=" + id + " ]";
    }
    
}
