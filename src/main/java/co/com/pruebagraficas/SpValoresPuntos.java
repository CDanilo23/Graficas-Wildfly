/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.pruebagraficas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cristian.ordonez
 */
@Entity
@Table(name = "sp_valores_puntos")
@NamedQueries({
    @NamedQuery(name = "SpValoresPuntos.findAll", query = "SELECT s FROM SpValoresPuntos s"),
    @NamedQuery(name = "SpValoresPuntos.findByVela", query = "SELECT s FROM SpValoresPuntos s WHERE s.vela = :vela"),
    @NamedQuery(name = "SpValoresPuntos.findByOpen", query = "SELECT s FROM SpValoresPuntos s WHERE s.open = :open"),
    @NamedQuery(name = "SpValoresPuntos.findByMaximo", query = "SELECT s FROM SpValoresPuntos s WHERE s.maximo = :maximo"),
    @NamedQuery(name = "SpValoresPuntos.findByMinimo", query = "SELECT s FROM SpValoresPuntos s WHERE s.minimo = :minimo"),
    @NamedQuery(name = "SpValoresPuntos.findByClose", query = "SELECT s FROM SpValoresPuntos s WHERE s.close = :close")})
public class SpValoresPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "vela")
    private String vela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "open")
    private String open;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "maximo")
    private String maximo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "minimo")
    private String minimo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "close")
    private String close;

    public SpValoresPuntos() {
    }

    public SpValoresPuntos(String vela) {
        this.vela = vela;
    }

    public SpValoresPuntos(String vela, String open, String maximo, String minimo, String close) {
        this.vela = vela;
        this.open = open;
        this.maximo = maximo;
        this.minimo = minimo;
        this.close = close;
    }

    public String getVela() {
        return vela;
    }

    public void setVela(String vela) {
        this.vela = vela;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vela != null ? vela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpValoresPuntos)) {
            return false;
        }
        SpValoresPuntos other = (SpValoresPuntos) object;
        if ((this.vela == null && other.vela != null) || (this.vela != null && !this.vela.equals(other.vela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.pruebagraficas.SpValoresPuntos[ vela=" + vela + " ]";
    }
    
}
