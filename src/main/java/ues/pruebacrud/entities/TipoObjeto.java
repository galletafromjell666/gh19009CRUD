/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.pruebacrud.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "tipo_objeto", schema = "public")
@NamedQueries({
    @NamedQuery(name = "TipoObjeto.findAll", query = "SELECT t FROM TipoObjeto t"),
    @NamedQuery(name = "TipoObjeto.findByIdTipoObjeto", query = "SELECT t FROM TipoObjeto t WHERE t.idTipoObjeto = :idTipoObjeto"),
    @NamedQuery(name = "TipoObjeto.findByActivo", query = "SELECT t FROM TipoObjeto t WHERE t.activo = :activo"),
    @NamedQuery(name = "TipoObjeto.findByFechaCreacion", query = "SELECT t FROM TipoObjeto t WHERE t.fechaCreacion = :fechaCreacion")})
public class TipoObjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_objeto", nullable = false)
    private Integer idTipoObjeto;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    //@OneToMany(mappedBy = "idTipoObjeto")
    //private List<Objeto> objetoList;

    public TipoObjeto() {
    }

    public TipoObjeto(Integer idTipoObjeto) {
        this.idTipoObjeto = idTipoObjeto;
    }

    public TipoObjeto(Integer idTipoObjeto, Boolean activo, Date fechaCreacion) {
        this.idTipoObjeto = idTipoObjeto;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdTipoObjeto() {
        return idTipoObjeto;
    }

    public void setIdTipoObjeto(Integer idTipoObjeto) {
        this.idTipoObjeto = idTipoObjeto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    //public List<Objeto> getObjetoList() {
    //    return objetoList;
    //}

    //public void setObjetoList(List<Objeto> objetoList) {
    //    this.objetoList = objetoList;
    //}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoObjeto != null ? idTipoObjeto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoObjeto)) {
            return false;
        }
        TipoObjeto other = (TipoObjeto) object;
        if ((this.idTipoObjeto == null && other.idTipoObjeto != null) || (this.idTipoObjeto != null && !this.idTipoObjeto.equals(other.idTipoObjeto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoObjeto[ idTipoObjeto=" + idTipoObjeto + " ]";
    }
    
}
