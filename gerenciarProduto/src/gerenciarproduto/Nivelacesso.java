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

/**
 *
 * @author Juninho
 */
@Entity
@Table(name = "nivelacesso", catalog = "junior", schema = "")
@NamedQueries({
    @NamedQuery(name = "Nivelacesso.findAll", query = "SELECT n FROM Nivelacesso n"),
    @NamedQuery(name = "Nivelacesso.findByCodAcesso", query = "SELECT n FROM Nivelacesso n WHERE n.codAcesso = :codAcesso"),
    @NamedQuery(name = "Nivelacesso.findByCodFuncionario", query = "SELECT n FROM Nivelacesso n WHERE n.codFuncionario = :codFuncionario"),
    @NamedQuery(name = "Nivelacesso.findByNomeModulo", query = "SELECT n FROM Nivelacesso n WHERE n.nomeModulo = :nomeModulo"),
    @NamedQuery(name = "Nivelacesso.verifiqueAcesso", query = "SELECT n FROM Nivelacesso n WHERE n.codFuncionario = :codFuncionario and n.nomeModulo = :nomeModulo")})
public class Nivelacesso implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_acesso")
    private Integer codAcesso;
    @Column(name = "cod_funcionario")
    private Integer codFuncionario;
    @Column(name = "nome_modulo")
    private String nomeModulo;

    public Nivelacesso() {
    }

    public Nivelacesso(Integer codAcesso) {
        this.codAcesso = codAcesso;
    }

    public Integer getCodAcesso() {
        return codAcesso;
    }

    public void setCodAcesso(Integer codAcesso) {
        Integer oldCodAcesso = this.codAcesso;
        this.codAcesso = codAcesso;
        changeSupport.firePropertyChange("codAcesso", oldCodAcesso, codAcesso);
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        Integer oldCodFuncionario = this.codFuncionario;
        this.codFuncionario = codFuncionario;
        changeSupport.firePropertyChange("codFuncionario", oldCodFuncionario, codFuncionario);
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        String oldNomeModulo = this.nomeModulo;
        this.nomeModulo = nomeModulo;
        changeSupport.firePropertyChange("nomeModulo", oldNomeModulo, nomeModulo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAcesso != null ? codAcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivelacesso)) {
            return false;
        }
        Nivelacesso other = (Nivelacesso) object;
        if ((this.codAcesso == null && other.codAcesso != null) || (this.codAcesso != null && !this.codAcesso.equals(other.codAcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.Nivelacesso[ codAcesso=" + codAcesso + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
