/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendasDao;
import Model.Vendas;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class VendasController {

    public ArrayList<Vendas> listaVendas() {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.pesquisar();
    }

    public Vendas buscaVenda(int id) {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.pesquisarId(id);
    }

    public boolean vendaSalvar(Vendas venda) {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.salvar(venda);
    }

    public boolean vendaEditar(Vendas venda) {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.editar(venda);
    }

    public boolean vendaExcluir(int id) {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.excluir(id);
    }
}
