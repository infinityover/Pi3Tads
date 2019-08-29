/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author paulo
 */
public class CategoriaProduto {
    
    private int idProduto;
    private int idCategoria;

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public CategoriaProduto(int idProduto, int idCategoria) {
        this.idProduto = idProduto;
        this.idCategoria = idCategoria;
    }
    
    
}
