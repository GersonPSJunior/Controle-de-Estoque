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
@Table(name = "det_saida", catalog = "junior", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetSaida.findAll", query = "SELECT d FROM DetSaida d"),
    @NamedQuery(name = "DetSaida.findByProdutoCodProduto", query = "SELECT d FROM DetSaida d WHERE d.detSaidaPK.produtoCodProduto = :produtoCodProduto"),
    @NamedQuery(name = "DetSaida.findByVendaCodSaida", query = "SELECT d FROM DetSaida d WHERE d.detSaidaPK.vendaCodSaida = :vendaCodSaida"),
    @NamedQuery(name = "DetSaida.findByDescricao", query = "SELECT d FROM DetSaida d WHERE d.descricao = :descricao"),
    @NamedQuery(name = "DetSaida.findByQtdeSaida", query = "SELECT d FROM DetSaida d WHERE d.qtdeSaida = :qtdeSaida"),
    @NamedQuery(name = "DetSaida.findByVlrSaida", query = "SELECT d FROM DetSaida d WHERE d.vlrSaida = :vlrSaida"),
    @NamedQuery(name = "DetSaida.findByTamanho", query = "SELECT d FROM DetSaida d WHERE d.tamanho = :tamanho")})
public class DetSaida implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetSaidaPK detSaidaPK;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "qtde_saida")
    private Integer qtdeSaida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlr_saida")
    private Double vlrSaida;
    @Column(name = "tamanho")
    private String tamanho;
    @JoinColumn(name = "venda_cod_saida", referencedColumnName = "cod_saida", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SaidaDeProduto saidaDeProduto;

    public DetSaida() {
    }

    public DetSaida(DetSaidaPK detSaidaPK) {
        this.detSaidaPK = detSaidaPK;
    }

    public DetSaida(int produtoCodProduto, int vendaCodSaida) {
        this.detSaidaPK = new DetSaidaPK(produtoCodProduto, vendaCodSaida);
    }

    public DetSaidaPK getDetSaidaPK() {
        return detSaidaPK;
    }

    public void setDetSaidaPK(DetSaidaPK detSaidaPK) {
        this.detSaidaPK = detSaidaPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Integer getQtdeSaida() {
        return qtdeSaida;
    }

    public void setQtdeSaida(Integer qtdeSaida) {
        Integer oldQtdeSaida = this.qtdeSaida;
        this.qtdeSaida = qtdeSaida;
        changeSupport.firePropertyChange("qtdeSaida", oldQtdeSaida, qtdeSaida);
    }

    public Double getVlrSaida() {
        return vlrSaida;
    }

    public void setVlrSaida(Double vlrSaida) {
        Double oldVlrSaida = this.vlrSaida;
        this.vlrSaida = vlrSaida;
        changeSupport.firePropertyChange("vlrSaida", oldVlrSaida, vlrSaida);
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        String oldTamanho = this.tamanho;
        this.tamanho = tamanho;
        changeSupport.firePropertyChange("tamanho", oldTamanho, tamanho);
    }

    public SaidaDeProduto getSaidaDeProduto() {
        return saidaDeProduto;
    }

    public void setSaidaDeProduto(SaidaDeProduto saidaDeProduto) {
        SaidaDeProduto oldSaidaDeProduto = this.saidaDeProduto;
        this.saidaDeProduto = saidaDeProduto;
        changeSupport.firePropertyChange("saidaDeProduto", oldSaidaDeProduto, saidaDeProduto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detSaidaPK != null ? detSaidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetSaida)) {
            return false;
        }
        DetSaida other = (DetSaida) object;
        if ((this.detSaidaPK == null && other.detSaidaPK != null) || (this.detSaidaPK != null && !this.detSaidaPK.equals(other.detSaidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.DetSaida[ detSaidaPK=" + detSaidaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
