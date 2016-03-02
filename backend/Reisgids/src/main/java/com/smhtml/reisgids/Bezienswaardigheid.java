/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smhtml.reisgids;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fhict
 */
@Entity
@Table(name = "BEZIENSWAARDIGHEID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bezienswaardigheid.findAll", query = "SELECT b FROM Bezienswaardigheid b"),
    @NamedQuery(name = "Bezienswaardigheid.findById", query = "SELECT b FROM Bezienswaardigheid b WHERE b.id = :id"),
    @NamedQuery(name = "Bezienswaardigheid.findByName", query = "SELECT b FROM Bezienswaardigheid b WHERE b.name = :name"),
    @NamedQuery(name = "Bezienswaardigheid.findByLong1", query = "SELECT b FROM Bezienswaardigheid b WHERE b.long1 = :long1"),
    @NamedQuery(name = "Bezienswaardigheid.findByLat", query = "SELECT b FROM Bezienswaardigheid b WHERE b.lat = :lat"),
    @NamedQuery(name = "Bezienswaardigheid.findByWeb", query = "SELECT b FROM Bezienswaardigheid b WHERE b.web = :web"),
    @NamedQuery(name = "Bezienswaardigheid.findByImg", query = "SELECT b FROM Bezienswaardigheid b WHERE b.img = :img")})
public class Bezienswaardigheid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Column(name = "LONG")
    private String long1;
    @Column(name = "LAT")
    private String lat;
    @Size(max = 255)
    @Column(name = "WEB")
    private String web;
    @Size(max = 255)
    @Column(name = "IMG")
    private String img;
    @JoinTable(name = "FAVORIETEN", joinColumns = {
        @JoinColumn(name = "BEZIENSWAARDIGHEIDID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USEREMAIL", referencedColumnName = "EMAIL")})
    @ManyToMany
    private Collection<Appuser> appuserCollection;
    @OneToMany(mappedBy = "bezienswaardigheidid")
    private Collection<Userfoto> userfotoCollection;

    public Bezienswaardigheid() {
    }

    public Bezienswaardigheid(Integer id) {
        this.id = id;
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

    public String getLong1() {
        return long1;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @XmlTransient
    public Collection<Appuser> getAppuserCollection() {
        return appuserCollection;
    }

    public void setAppuserCollection(Collection<Appuser> appuserCollection) {
        this.appuserCollection = appuserCollection;
    }

    @XmlTransient
    public Collection<Userfoto> getUserfotoCollection() {
        return userfotoCollection;
    }

    public void setUserfotoCollection(Collection<Userfoto> userfotoCollection) {
        this.userfotoCollection = userfotoCollection;
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
        if (!(object instanceof Bezienswaardigheid)) {
            return false;
        }
        Bezienswaardigheid other = (Bezienswaardigheid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smhtml.reisgids.Bezienswaardigheid[ id=" + id + " ]";
    }
    
}
