/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarproduto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Juninho
 */
@Embeddable
public class DetSaidaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "produto_cod_produto")
    private int produtoCodProduto;
    @Basic(optional = false)
    @Column(name = "venda_cod_saida")
    private int vendaCodSaida;

    public DetSaidaPK() {
    }

    public DetSaidaPK(int produtoCodProduto, int vendaCodSaida) {
        this.produtoCodProduto = produtoCodProduto;
        this.vendaCodSaida = vendaCodSaida;
    }

    public int getProdutoCodProduto() {
        return produtoCodProduto;
    }

    public void setProdutoCodProduto(int produtoCodProduto) {
        this.produtoCodProduto = produtoCodProduto;
    }

    public int getVendaCodSaida() {
        return vendaCodSaida;
    }

    public void setVendaCodSaida(int vendaCodSaida) {
        this.vendaCodSaida = vendaCodSaida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoCodProduto;
        hash += (int) vendaCodSaida;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetSaidaPK)) {
            return false;
        }
        DetSaidaPK other = (DetSaidaPK) object;
        if (this.produtoCodProduto != other.produtoCodProduto) {
            return false;
        }
        if (this.vendaCodSaida != other.vendaCodSaida) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.DetSaidaPK[ produtoCodProduto=" + produtoCodProduto + ", vendaCodSaida=" + vendaCodSaida + " ]";
    }
    
}
