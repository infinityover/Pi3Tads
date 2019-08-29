package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author gabrielavsmarques
 */
public class ProdutoController {
    
    public static boolean Salvar(String nome, String descricao, double preco_compra, double preco_venda, int quantidade, boolean disponivel) {

        Produto p = new Produto(nome, descricao, preco_compra, preco_venda,quantidade,disponivel,new Timestamp(System.currentTimeMillis()));
        return ProdutoDAO.salvar(p);
    }
    
    public static boolean Atualizar(int id ,String nomeProduto, String descricaoProduto, double precoCompra, double precoVenda, int quantidade, boolean disponivel) {

        Produto p = new Produto(id, nomeProduto, descricaoProduto, precoCompra, precoVenda, quantidade,disponivel);
        return ProdutoDAO.atualizar(p);
    }
    
     public static boolean Excluir(int idProduto) {
        return ProdutoDAO.excluir(idProduto);
    }
     
     
    public static ArrayList<String[]> Pesquisar(int idProduto, String nomeProduto, String descricaoProduto, double precoCompra, double precoVenda, int quantidade, boolean disponivel, String categoria) throws SQLException {
        
        Produto p  = new Produto();
        p.setId(idProduto);
        p.setNome(nomeProduto);
        p.setDescricao(descricaoProduto);
        p.setPreco_compra(precoCompra);
        p.setPreco_venda(precoVenda);
        p.setQuantidade(quantidade);
        p.setDisponivel(disponivel);
        //p.set(categoria);
        
        ArrayList<Produto> retorno = ProdutoDAO.pesquisar(p);
        
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < retorno.size(); i++) {
            listaProdutos.add(new String[]{String.valueOf(retorno.get(i).getId()),
                retorno.get(i).getNome(),
                retorno.get(i).getDescricao(),
                String.valueOf(retorno.get(i).getPreco_compra()),
                String.valueOf(retorno.get(i).getPreco_venda()),
                String.valueOf(retorno.get(i).getQuantidade()),
                //retorno.get(i).getCategoria()
            });
        }
        return listaProdutos;

    }
    
        public static ArrayList<Produto> PesquisarPorID(int idProduto) throws SQLException {
        
        Produto p  = new Produto();
        p.setId(idProduto);
        //p.set(categoria);
        
        ArrayList<Produto> retorno = ProdutoDAO.pesquisar(p);
        
        return retorno;

    }
    
    public static ArrayList<String[]> getProdutos() {
        ArrayList<Produto> p = ProdutoDAO.getProdutos();
        ArrayList<String[]> listaProdutos = new ArrayList<>();

        for (int i = 0; i < p.size(); i++) {
            listaProdutos.add(new String[]{
                String.valueOf(p.get(i).getId()),
                p.get(i).getDescricao(),
                String.valueOf(p.get(i).getQuantidade()),
                String.valueOf(p.get(i).getPreco_venda()),
                //String.valueOf(p.get(i).getCategoriaProduto())
            });
        }

        return listaProdutos;

    }
    
}
