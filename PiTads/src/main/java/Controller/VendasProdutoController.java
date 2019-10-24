/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendasProdutoDao;
import Model.VendasProduto;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class VendasProdutoController {

    public ArrayList<VendasProduto> listaVendasProduto(int idVenda) {
        VendasProdutoDao vendasProdutodao = new VendasProdutoDao();
        return vendasProdutodao.pesquisar(idVenda);
    }

    public VendasProduto buscaVendaProduto(int id) {
        VendasProdutoDao vendasProdutodao = new VendasProdutoDao();
        return vendasProdutodao.pesquisarId(id);
    }

    public boolean vendaSalvar(VendasProduto venda) {
        VendasProdutoDao vendasProdutodao = new VendasProdutoDao();
        return vendasProdutodao.salvar(venda);
    }

    public boolean vendaEditar(VendasProduto venda) {
        VendasProdutoDao vendasProdutodao = new VendasProdutoDao();
        return vendasProdutodao.editar(venda);
    }

    public boolean vendaExcluir(int id) {
        VendasProdutoDao vendasProdutodao = new VendasProdutoDao();
        return vendasProdutodao.excluir(id);
    }
}
