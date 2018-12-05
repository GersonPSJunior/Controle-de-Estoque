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
public class DetEntradaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "produto_cod_produto")
    private int produtoCodProduto;
    @Basic(optional = false)
    @Column(name = "compra_cod_entrada")
    private int compraCodEntrada;

    public DetEntradaPK() {
    }

    public DetEntradaPK(int produtoCodProduto, int compraCodEntrada) {
        this.produtoCodProduto = produtoCodProduto;
        this.compraCodEntrada = compraCodEntrada;
    }

    public int getProdutoCodProduto() {
        return produtoCodProduto;
    }

    public void setProdutoCodProduto(int produtoCodProduto) {
        this.produtoCodProduto = produtoCodProduto;
    }

    public int getCompraCodEntrada() {
        return compraCodEntrada;
    }

    public void setCompraCodEntrada(int compraCodEntrada) {
        this.compraCodEntrada = compraCodEntrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoCodProduto;
        hash += (int) compraCodEntrada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetEntradaPK)) {
            return false;
        }
        DetEntradaPK other = (DetEntradaPK) object;
        if (this.produtoCodProduto != other.produtoCodProduto) {
            return false;
        }
        if (this.compraCodEntrada != other.compraCodEntrada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gerenciarproduto.DetEntradaPK[ produtoCodProduto=" + produtoCodProduto + ", compraCodEntrada=" + compraCodEntrada + " ]";
    }
    
}
