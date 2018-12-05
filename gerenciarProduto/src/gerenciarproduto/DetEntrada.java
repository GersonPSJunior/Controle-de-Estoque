/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarproduto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Juninho
 */
@Entity
@Table(name = "det_entrada", catalog = "junior", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetEntrada.findAll", query = "SELECT d FROM DetEntrada d"),
    @NamedQuery(name = "DetEntrada.findByProdutoCodProduto", query = "SELECT d FROM DetEntrada d WHERE d.detEntradaPK.produtoCodProduto = :produtoCodProduto"),
    @NamedQuery(name = "DetEntrada.findByCompraCodEntrada", query = "SELECT d FROM DetEntrada d WHERE d.detEntradaPK.compraCodEntrada = :compraCodEntrada"),
    @NamedQuery(name = "DetEntrada.findByDescricao", query = "SELECT d FROM DetEntrada d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "DetEntrada.findByQtdeCompra", query = "SELECT d FROM DetEntrada d WHERE d.qtdeCompra = :qtdeCompra"),
    @NamedQuery(name = "DetEntrada.findByVlrCompra", query = "SELECT d FROM DetEntrada d WHERE d.vlrCompra = :vlrCompra"),
    @NamedQuery(name = "DetEntrada.findByTamanho", query = "SELECT d FROM DetEntrada d WHERE d.tamanho = :tamanho")})
public class DetEntrada implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetEntradaPK detEntradaPK;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "qtde_compra")
    private Integer qtdeCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlr_compra")
    private Double vlrCompra;
    @Column(name = "tamanho")
    private String tamanho;
    @JoinColumn(name = "compra_cod_entrada", referencedColumnName = "cod_entrada", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EntradaDeProduto entradaDeProduto;

    public DetEntrada() {
    }

    public DetEntrada(DetEntradaPK detEntradaPK) {
        this.detEntradaPK = detEntradaPK;
    }

    public DetEntrada(int produtoCodProduto, int compraCodEntrada) {
        this.detEntradaPK = new DetEntradaPK(produtoCodProduto, compraCodEntrada);
    }

    public DetEntradaPK getDetEntradaPK() {
        return detEntradaPK;
    }

    public void setDetEntradaPK(DetEntradaPK detEntradaPK) {
        this.detEntradaPK = detEntradaPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Integer getQtdeCompra() {
        return qtdeCompra;
    }

    public void setQtdeCompra(Integer qtdeCompra) {
        Integer oldQtdeCompra = this.qtdeCompra;
        this.qtdeCompra = qtdeCompra;
        changeSupport.firePropertyChange("qtdeCompra", oldQtdeCompra, qtdeCompra);
    }

    public Double getVlrCompra() {
        return vlrCompra;
    }

    public void setVlrCompra(Double vlrCompra) {
        Double oldVlrCompra = this.vlrCompra;
        this.vlrCompra = vlrCompra;
        changeSupport.firePropertyChange("vlrCompra", oldVlrCompra, vlrCompra);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        String oldTamanho = this.tamanho;
        this.tamanho = tamanho;
        changeSupport.firePropertyChange("tamanho", oldTamanho, tamanho);
    }

    public EntradaDeProduto getEntradaDeProduto() {
        return entradaDeProduto;
    }

    public void setEntradaDeProduto(EntradaDeProduto entradaDeProduto) {
        EntradaDeProduto oldEntradaDeProduto = this.entradaDeProduto;
        this.entradaDeProduto = entradaDeProduto;
        changeSupport.firePropertyChange("entradaDeProduto", oldEntradaDeProduto, entradaDeProduto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detEntradaPK != null ? detEntradaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEntrada)) {
            return false;
        }
        DetEntrada other = (DetEntrada) object;
        if ((this.detEntradaPK == null && other.detEntradaPK != null) || (this.detEntradaPK != null && !this.detEntradaPK.equals(other.detEntradaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.DetEntrada[ detEntradaPK=" + detEntradaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
