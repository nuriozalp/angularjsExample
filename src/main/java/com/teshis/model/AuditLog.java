/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teshis.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nuri
 */
@Entity
@Table(name = "AUDIT_LOG")
@NamedQueries({
    @NamedQuery(name = "AuditLog.findAll", query = "SELECT a FROM AuditLog a")})
public class AuditLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TABLE_NAME")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "ACTION_NAME")
    private String actionName;
    @Basic(optional = false)
    @Column(name = "ACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;
    @Basic(optional = false)
    @Column(name = "MODEL_ID")
    private int modelId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    public AuditLog() {
    }

    public AuditLog(Integer id) {
        this.id = id;
    }

    public AuditLog(Integer id, String tableName, String actionName, Date actionDate, int modelId) {
        this.id = id;
        this.tableName = tableName;
        this.actionName = actionName;
        this.actionDate = actionDate;
        this.modelId = modelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof AuditLog)) {
            return false;
        }
        AuditLog other = (AuditLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teshis.model.AuditLog[ id=" + id + " ]";
    }
    
}
