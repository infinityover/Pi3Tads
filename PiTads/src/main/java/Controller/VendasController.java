/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VendasDao;
import Model.Filial;
import Model.Vendas;
import Model.VendasProdutoUserView;
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
    
    public ArrayList<Vendas> listaVendasPorFilial(Filial filial) {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.pesquisarPorFilial(filial);
    }

    public Vendas buscaVenda(int id) {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.pesquisarId(id);
    }

    public int vendaSalvar(Vendas venda) {
        VendasDao vendasdao = new VendasDao();
        return vendasdao.salvar(venda);
    }
    
    public boolean vendaSalvarProdutoFinalizar(Vendas venda) {
        VendasDao vendasdao = new VendasDao();
        VendasProdutoController vendas = new VendasProdutoController();
        ArrayList<VendasProdutoUserView> lista =  vendas.listaVendasProdutoComNome(venda.getId());
        Float total = 0f;
        for (VendasProdutoUserView item : lista) {
            total += item.getTotal();
        }
        venda.setValor(total);
        return vendasdao.vendasFinalizar(venda);
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
