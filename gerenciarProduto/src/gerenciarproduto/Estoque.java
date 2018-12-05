/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarproduto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juninho
 */
@Entity
@Table(name = "estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findByCodEstoque", query = "SELECT e FROM Estoque e WHERE e.codEstoque = :codEstoque"),
    @NamedQuery(name = "Estoque.findByDescricaoEstoque", query = "SELECT e FROM Estoque e WHERE e.descricaoEstoque = :descricaoEstoque"),
    @NamedQuery(name = "Estoque.findByQtdeEstoque", query = "SELECT e FROM Estoque e WHERE e.qtdeEstoque = :qtdeEstoque"),
    @NamedQuery(name = "Estoque.findByData", query = "SELECT e FROM Estoque e WHERE e.data = :data"),
    @NamedQuery(name = "Estoque.findByTipo", query = "SELECT e FROM Estoque e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Estoque.findByValor", query = "SELECT e FROM Estoque e WHERE e.valor = :valor"),
    @NamedQuery(name = "Estoque.findBySaldoEstoque", query = "SELECT e FROM Estoque e WHERE e.saldoEstoque = :saldoEstoque"),
    @NamedQuery(name = "Estoque.findByTamanho", query = "SELECT e FROM Estoque e WHERE e.tamanho = :tamanho"),
    @NamedQuery(name = "Estoque.findByLocal", query = "SELECT e FROM Estoque e WHERE e.local = :local"),
    @NamedQuery(name = "Estoque.findByVerificaEstoque", query = "SELECT e FROM Estoque e WHERE e.descricaoEstoque = :descricaoEstoque and e.tamanho = :tamanho ORDER BY e.codEstoque DESC")})
public class Estoque implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_estoque")
    private Integer codEstoque;
    @Column(name = "descricao_estoque")
    private String descricaoEstoque;
    @Column(name = "qtde_estoque")
    private Integer qtdeEstoque;
    @Column(name = "data")
    private String data;
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "saldo_estoque")
    private Integer saldoEstoque;
    @Column(name = "tamanho")
    private String tamanho;
    @Column(name = "local")
    private String local;

    public Estoque() {
    }

    public Estoque(Integer codEstoque) {
        this.codEstoque = codEstoque;
    }

    public Integer getCodEstoque() {
        return codEstoque;
    }

    public void setCodEstoque(Integer codEstoque) {
        Integer oldCodEstoque = this.codEstoque;
        this.codEstoque = codEstoque;
        changeSupport.firePropertyChange("codEstoque", oldCodEstoque, codEstoque);
    }

    public String getDescricaoEstoque() {
        return descricaoEstoque;
    }

    public void setDescricaoEstoque(String descricaoEstoque) {
        String oldDescricaoEstoque = this.descricaoEstoque;
        this.descricaoEstoque = descricaoEstoque;
        changeSupport.firePropertyChange("descricaoEstoque", oldDescricaoEstoque, descricaoEstoque);
    }

    public Integer getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(Integer qtdeEstoque) {
        Integer oldQtdeEstoque = this.qtdeEstoque;
        this.qtdeEstoque = qtdeEstoque;
        changeSupport.firePropertyChange("qtdeEstoque", oldQtdeEstoque, qtdeEstoque);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        String oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        Double oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public Integer getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(Integer saldoEstoque) {
        Integer oldSaldoEstoque = this.saldoEstoque;
        this.saldoEstoque = saldoEstoque;
        changeSupport.firePropertyChange("saldoEstoque", oldSaldoEstoque, saldoEstoque);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        String oldTamanho = this.tamanho;
        this.tamanho = tamanho;
        changeSupport.firePropertyChange("tamanho", oldTamanho, tamanho);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        String oldLocal = this.local;
        this.local = local;
        changeSupport.firePropertyChange("local", oldLocal, local);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstoque != null ? codEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.codEstoque == null && other.codEstoque != null) || (this.codEstoque != null && !this.codEstoque.equals(other.codEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.Estoque[ codEstoque=" + codEstoque + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
