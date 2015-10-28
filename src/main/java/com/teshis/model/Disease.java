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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "DISEASE")
@NamedQueries({
    @NamedQuery(name = "Disease.findAll", query = "SELECT d FROM Disease d")})
public class Disease implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "MEDICO_NAME")
    private String medicoName;
    @Basic(optional = false)
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Lob
    @Column(name = "TREATMENT")
    private String treatment;
    @Basic(optional = false)
    @Lob
    @Column(name = "RISKFACTOR")
    private String riskfactor;
    @Basic(optional = false)
    @Lob
    @Column(name = "SELFCARE")
    private String selfcare;
    @Basic(optional = false)
    @Lob
    @Column(name = "DIAGNOSEDBY")
    private String diagnosedby;
    @Basic(optional = false)
    @Lob
    @Column(name = "WHATTOEXPECT")
    private String whattoexpect;
    @Basic(optional = false)
    @Lob
    @Column(name = "HOWCOMMON")
    private String howcommon;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @Lob
    @Column(name = "REFERANCES")
    private String referances;
    @Basic(optional = false)
    @Column(name = "ENABLED")
    private boolean enabled;
    @Basic(optional = false)
    @Column(name = "APPROVALED")
    private boolean approvaled;
    @Basic(optional = false)
    @Column(name = "USEDRISK")
    private boolean usedrisk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PROBABILITY")
    private Double probability;
    @Column(name = "GENDER_ID")
    private Integer genderId;
    @Column(name = "UID")
    private String uid;
    @Column(name = "TOTAL_DISPLAY")
    private Integer totalDisplay;
    @ManyToMany(mappedBy = "diseaseList", fetch = FetchType.LAZY)
    private List<BloodTest> bloodTestList;
    @ManyToMany(mappedBy = "diseaseList", fetch = FetchType.LAZY)
    private List<AgeRange> ageRangeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease", fetch = FetchType.LAZY)
    private List<Medicane> medicaneList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease", fetch = FetchType.LAZY)
    private List<FirstAid> firstAidList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease", fetch = FetchType.LAZY)
    private List<SymptomQuestionAnswer> symptomQuestionAnswerList;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DiseaseCategory diseaseCategory;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease", fetch = FetchType.LAZY)
    private List<Article> articleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease", fetch = FetchType.LAZY)
    private List<DiseaseSymptom> diseaseSymptomList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disease", fetch = FetchType.LAZY)
    private List<Treatment> treatmentList;

    public Disease() {
    }

    public Disease(Integer id) {
        this.id = id;
    }

    public Disease(Integer id, String name, String medicoName, String description, String treatment, String riskfactor, String selfcare, String diagnosedby, String whattoexpect, String howcommon, String url, String referances, boolean enabled, boolean approvaled, boolean usedrisk) {
        this.id = id;
        this.name = name;
        this.medicoName = medicoName;
        this.description = description;
        this.treatment = treatment;
        this.riskfactor = riskfactor;
        this.selfcare = selfcare;
        this.diagnosedby = diagnosedby;
        this.whattoexpect = whattoexpect;
        this.howcommon = howcommon;
        this.url = url;
        this.referances = referances;
        this.enabled = enabled;
        this.approvaled = approvaled;
        this.usedrisk = usedrisk;
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

    public String getMedicoName() {
        return medicoName;
    }

    public void setMedicoName(String medicoName) {
        this.medicoName = medicoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getRiskfactor() {
        return riskfactor;
    }

    public void setRiskfactor(String riskfactor) {
        this.riskfactor = riskfactor;
    }

    public String getSelfcare() {
        return selfcare;
    }

    public void setSelfcare(String selfcare) {
        this.selfcare = selfcare;
    }

    public String getDiagnosedby() {
        return diagnosedby;
    }

    public void setDiagnosedby(String diagnosedby) {
        this.diagnosedby = diagnosedby;
    }

    public String getWhattoexpect() {
        return whattoexpect;
    }

    public void setWhattoexpect(String whattoexpect) {
        this.whattoexpect = whattoexpect;
    }

    public String getHowcommon() {
        return howcommon;
    }

    public void setHowcommon(String howcommon) {
        this.howcommon = howcommon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReferances() {
        return referances;
    }

    public void setReferances(String referances) {
        this.referances = referances;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getApprovaled() {
        return approvaled;
    }

    public void setApprovaled(boolean approvaled) {
        this.approvaled = approvaled;
    }

    public boolean getUsedrisk() {
        return usedrisk;
    }

    public void setUsedrisk(boolean usedrisk) {
        this.usedrisk = usedrisk;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getTotalDisplay() {
        return totalDisplay;
    }

    public void setTotalDisplay(Integer totalDisplay) {
        this.totalDisplay = totalDisplay;
    }

    public List<BloodTest> getBloodTestList() {
        return bloodTestList;
    }

    public void setBloodTestList(List<BloodTest> bloodTestList) {
        this.bloodTestList = bloodTestList;
    }

    public List<AgeRange> getAgeRangeList() {
        return ageRangeList;
    }

    public void setAgeRangeList(List<AgeRange> ageRangeList) {
        this.ageRangeList = ageRangeList;
    }

    public List<Medicane> getMedicaneList() {
        return medicaneList;
    }

    public void setMedicaneList(List<Medicane> medicaneList) {
        this.medicaneList = medicaneList;
    }

    public List<FirstAid> getFirstAidList() {
        return firstAidList;
    }

    public void setFirstAidList(List<FirstAid> firstAidList) {
        this.firstAidList = firstAidList;
    }

    public List<SymptomQuestionAnswer> getSymptomQuestionAnswerList() {
        return symptomQuestionAnswerList;
    }

    public void setSymptomQuestionAnswerList(List<SymptomQuestionAnswer> symptomQuestionAnswerList) {
        this.symptomQuestionAnswerList = symptomQuestionAnswerList;
    }

    public DiseaseCategory getDiseaseCategory() {
        return diseaseCategory;
    }

    public void setDiseaseCategory(DiseaseCategory diseaseCategory) {
        this.diseaseCategory = diseaseCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<DiseaseSymptom> getDiseaseSymptomList() {
        return diseaseSymptomList;
    }

    public void setDiseaseSymptomList(List<DiseaseSymptom> diseaseSymptomList) {
        this.diseaseSymptomList = diseaseSymptomList;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
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
        if (!(object instanceof Disease)) {
            return false;
        }
        Disease other = (Disease) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teshis.model.Disease[ id=" + id + " ]";
    }
    
}
