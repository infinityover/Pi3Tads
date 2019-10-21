/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProdutoDao;
import Model.Produto;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class ProdutoController {

    public ArrayList<Produto> listaProdutos() {
        ProdutoDao produtodao = new ProdutoDao();
        return produtodao.pesquisar();
    }

    public Produto buscaProduto(String id) {
        ProdutoDao produtodao = new ProdutoDao();
        return produtodao.pesquisarId(id);
    }

    public boolean produtoSalvar(Produto produto) {
        ProdutoDao produtodao = new ProdutoDao();
        return produtodao.salvar(produto);
    }

    public boolean produtoEditar(Produto produto) {
        ProdutoDao produtodao = new ProdutoDao();
        return produtodao.editar(produto);
    }

    public boolean produtoExcluir(String id) {
        ProdutoDao produtodao = new ProdutoDao();
        return produtodao.excluir(id);
    }
}
