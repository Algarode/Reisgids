/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smhtml.reisgids;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fhict
 */
@Entity
@Table(name = "USERFOTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userfoto.findAll", query = "SELECT u FROM Userfoto u"),
    @NamedQuery(name = "Userfoto.findById", query = "SELECT u FROM Userfoto u WHERE u.id = :id"),
    @NamedQuery(name = "Userfoto.findByImage", query = "SELECT u FROM Userfoto u WHERE u.image = :image")})
public class Userfoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Lob
    @Size(max = 32700)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "IMAGE")
    private String image;
    @JoinColumn(name = "BEZIENSWAARDIGHEIDID", referencedColumnName = "ID")
    @ManyToOne
    private Bezienswaardigheid bezienswaardigheidid;
    @JoinColumn(name = "USEREMAIL", referencedColumnName = "EMAIL")
    @ManyToOne
    private Appuser useremail;

    public Userfoto() {
    }

    public Userfoto(Integer id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Bezienswaardigheid getBezienswaardigheidid() {
        return bezienswaardigheidid;
    }

    public void setBezienswaardigheidid(Bezienswaardigheid bezienswaardigheidid) {
        this.bezienswaardigheidid = bezienswaardigheidid;
    }

    public Appuser getUseremail() {
        return useremail;
    }

    public void setUseremail(Appuser useremail) {
        this.useremail = useremail;
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
        if (!(object instanceof Userfoto)) {
            return false;
        }
        Userfoto other = (Userfoto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smhtml.reisgids.Userfoto[ id=" + id + " ]";
    }
    
}
