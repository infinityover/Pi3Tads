/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProdutoDao;
import DAO.VendasProdutoDao;
import Model.VendasProduto;
import Model.Produto;
import Model.VendasProdutoUserView;
import java.text.DecimalFormat;
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
    
        public ArrayList<VendasProdutoUserView> listaVendasProdutoComNome(int idVenda) {
        VendasProdutoDao vendasProdutodao = new VendasProdutoDao();
        ProdutoDao produtodao = new ProdutoDao();
        ArrayList<VendasProduto> itens = vendasProdutodao.pesquisar(idVenda);
        ArrayList<VendasProdutoUserView> retorno = new ArrayList<>();
            for (VendasProduto iten : itens) {
                Produto prod = produtodao.pesquisarId(iten.getIdProduto());
                DecimalFormat df = new DecimalFormat("##.##");
                retorno.add(new VendasProdutoUserView(iten.getId(),
                        iten.getIdVenda(),
                        iten.getIdProduto(),
                        prod.getNome(),
                        iten.getValor(),
                        Math.round(iten.getValor()*((100-iten.getDesconto())/100)*iten.getQuantidade() *100) /100f,
                        iten.getQuantidade(),
                        iten.getDesconto()));
            }
        return retorno;
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
