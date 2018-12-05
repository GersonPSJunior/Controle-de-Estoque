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
@Table(name = "saida_de_produto", catalog = "junior", schema = "")
@NamedQueries({
    @NamedQuery(name = "SaidaDeProduto.findAll", query = "SELECT s FROM SaidaDeProduto s"),
    @NamedQuery(name = "SaidaDeProduto.findByCodSaida", query = "SELECT s FROM SaidaDeProduto s WHERE s.codSaida = :codSaida"),
    @NamedQuery(name = "SaidaDeProduto.findByLocal", query = "SELECT s FROM SaidaDeProduto s WHERE s.local = :local"),
    @NamedQuery(name = "SaidaDeProduto.findByDataDaSaida", query = "SELECT s FROM SaidaDeProduto s WHERE s.dataDaSaida = :dataDaSaida"),
    @NamedQuery(name = "SaidaDeProduto.findByFuncionarioCodFuncionario", query = "SELECT s FROM SaidaDeProduto s WHERE s.funcionarioCodFuncionario = :funcionarioCodFuncionario")})
public class SaidaDeProduto implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_saida")
    private Integer codSaida;
    @Column(name = "local")
    private String local;
    @Column(name = "data_da_saida")
    @Temporal(TemporalType.DATE)
    private Date dataDaSaida;
    @Basic(optional = false)
    @Column(name = "funcionario_cod_funcionario")
    private int funcionarioCodFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saidaDeProduto")
    private List<DetSaida> detSaidaList;

    public SaidaDeProduto() {
    }

    public SaidaDeProduto(Integer codSaida) {
        this.codSaida = codSaida;
    }

    public SaidaDeProduto(Integer codSaida, int funcionarioCodFuncionario) {
        this.codSaida = codSaida;
        this.funcionarioCodFuncionario = funcionarioCodFuncionario;
    }

    public Integer getCodSaida() {
        return codSaida;
    }

    public void setCodSaida(Integer codSaida) {
        Integer oldCodSaida = this.codSaida;
        this.codSaida = codSaida;
        changeSupport.firePropertyChange("codSaida", oldCodSaida, codSaida);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        String oldLocal = this.local;
        this.local = local;
        changeSupport.firePropertyChange("local", oldLocal, local);
    }

    public Date getDataDaSaida() {
        return dataDaSaida;
    }

    public void setDataDaSaida(Date dataDaSaida) {
        Date oldDataDaSaida = this.dataDaSaida;
        this.dataDaSaida = dataDaSaida;
        changeSupport.firePropertyChange("dataDaSaida", oldDataDaSaida, dataDaSaida);
    }

    public int getFuncionarioCodFuncionario() {
        return funcionarioCodFuncionario;
    }

    public void setFuncionarioCodFuncionario(int funcionarioCodFuncionario) {
        int oldFuncionarioCodFuncionario = this.funcionarioCodFuncionario;
        this.funcionarioCodFuncionario = funcionarioCodFuncionario;
        changeSupport.firePropertyChange("funcionarioCodFuncionario", oldFuncionarioCodFuncionario, funcionarioCodFuncionario);
    }

    public List<DetSaida> getDetSaidaList() {
        return detSaidaList;
    }

    public void setDetSaidaList(List<DetSaida> detSaidaList) {
        this.detSaidaList = detSaidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSaida != null ? codSaida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaidaDeProduto)) {
            return false;
        }
        SaidaDeProduto other = (SaidaDeProduto) object;
        if ((this.codSaida == null && other.codSaida != null) || (this.codSaida != null && !this.codSaida.equals(other.codSaida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.SaidaDeProduto[ codSaida=" + codSaida + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
