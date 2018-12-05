/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarproduto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.Transient;

/**
 *
 * @author Juninho
 */
@Entity
@Table(name = "entrada_de_produto", catalog = "junior", schema = "")
@NamedQueries({
    @NamedQuery(name = "EntradaDeProduto.findAll", query = "SELECT e FROM EntradaDeProduto e"),
    @NamedQuery(name = "EntradaDeProduto.findByCodEntrada", query = "SELECT e FROM EntradaDeProduto e WHERE e.codEntrada = :codEntrada"),
    @NamedQuery(name = "EntradaDeProduto.findByLocal", query = "SELECT e FROM EntradaDeProduto e WHERE e.local = :local"),
    @NamedQuery(name = "EntradaDeProduto.findByDataEntrada", query = "SELECT e FROM EntradaDeProduto e WHERE e.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "EntradaDeProduto.findByFuncionarioCodFuncionario", query = "SELECT e FROM EntradaDeProduto e WHERE e.funcionarioCodFuncionario = :funcionarioCodFuncionario")})
public class EntradaDeProduto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_entrada")
    private Integer codEntrada;
    @Column(name = "local")
    private String local;
    @Column(name = "data_entrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Basic(optional = false)
    @Column(name = "funcionario_cod_funcionario")
    private int funcionarioCodFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaDeProduto")
    private List<DetEntrada> detEntradaList;

    public EntradaDeProduto() {
    }

    public EntradaDeProduto(Integer codEntrada) {
        this.codEntrada = codEntrada;
    }

    public EntradaDeProduto(Integer codEntrada, int funcionarioCodFuncionario) {
        this.codEntrada = codEntrada;
        this.funcionarioCodFuncionario = funcionarioCodFuncionario;
    }

    public Integer getCodEntrada() {
        return codEntrada;
    }

    public void setCodEntrada(Integer codEntrada) {
        Integer oldCodEntrada = this.codEntrada;
        this.codEntrada = codEntrada;
        changeSupport.firePropertyChange("codEntrada", oldCodEntrada, codEntrada);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        String oldLocal = this.local;
        this.local = local;
        changeSupport.firePropertyChange("local", oldLocal, local);
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        Date oldDataEntrada = this.dataEntrada;
        this.dataEntrada = dataEntrada;
        changeSupport.firePropertyChange("dataEntrada", oldDataEntrada, dataEntrada);
    }

    public int getFuncionarioCodFuncionario() {
        return funcionarioCodFuncionario;
    }

    public void setFuncionarioCodFuncionario(int funcionarioCodFuncionario) {
        int oldFuncionarioCodFuncionario = this.funcionarioCodFuncionario;
        this.funcionarioCodFuncionario = funcionarioCodFuncionario;
        changeSupport.firePropertyChange("funcionarioCodFuncionario", oldFuncionarioCodFuncionario, funcionarioCodFuncionario);
    }

    public List<DetEntrada> getDetEntradaList() {
        return detEntradaList;
    }

    public void setDetEntradaList(List<DetEntrada> detEntradaList) {
        this.detEntradaList = detEntradaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEntrada != null ? codEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaDeProduto)) {
            return false;
        }
        EntradaDeProduto other = (EntradaDeProduto) object;
        if ((this.codEntrada == null && other.codEntrada != null) || (this.codEntrada != null && !this.codEntrada.equals(other.codEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.EntradaDeProduto[ codEntrada=" + codEntrada + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
