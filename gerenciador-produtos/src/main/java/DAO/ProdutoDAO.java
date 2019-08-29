package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author gabrielavsmarques
 */
public class ProdutoDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVIDOR = "localhost";
    private static final String BASEDADOS = "PRODUTOBD";
    private static final String PORTA = "3306";
    private static final String LOGIN = "root";
    private static final String SENHA = "121296Pk!";
    private static String url = "";
    private static Connection conexao;
    
    
    private static Connection conectaBanco() throws SQLException{

            url = "jdbc:mysql://"+SERVIDOR+":"+PORTA+ "/PRODUTOBD?useTimezone=true&serverTimezone=UTC";
            //System.out.print(url);
            return DriverManager.getConnection(url, LOGIN, SENHA);
    }
    
    public static boolean salvar(Produto p) {

        boolean retorno = false;
        int lastID = 0;
        try {
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO PRODUTO(NOME,DESCRICAO,PRECO_COMPRA,PRECO_VENDA,QUANTIDADE,DISPONIVEL,DT_CADASTRO)VALUES(?, ?, ?, ?, ?, ?,?);",Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, p.getNome());
            comando.setString(2, p.getDescricao());
            comando.setDouble(3, p.getPreco_compra());
            comando.setDouble(4, p.getPreco_venda());
            comando.setInt(5,p.getQuantidade());
            comando.setBoolean(6, p.getDisponivel());
            comando.setTimestamp(7, p.getDt_cadastro());

            int linhasAfetadas = comando.executeUpdate();
            
            ResultSet rs = comando.getGeneratedKeys();
            if (rs.next()){
                lastID=rs.getInt(1);
            }
            
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                
            }
            
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            System.out.print(ex.getMessage());
                retorno = false;
            }
        }

        return retorno;
    }    
    
    public static boolean atualizar(Produto p) {

        boolean retorno = false;

        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, PRECO_COMPRA = ?, PRECO_VENDA = ?, QUANTIDADE = ?, DISPONIVEL = ? WHERE ID = ?;");
            comando.setString(1, p.getNome());
            comando.setString(2, p.getDescricao());
            comando.setDouble(3, p.getPreco_compra());
            comando.setDouble(4, p.getPreco_venda());
            comando.setInt(5, p.getQuantidade());
            comando.setBoolean(6, p.getDisponivel());
            comando.setInt(7, p.getId());

            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException e) {
            System.out.print(e.getMessage());
            retorno = true;
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            System.out.print(ex.getMessage());
                retorno = false;
            }
        }

        return retorno;

    }  
     
    public static boolean excluir(int ID) {


        boolean retorno = false;

        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
            comando.setInt(1, ID);

            int linhasAfetadas = comando.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException ex) {
            retorno = true;
        } catch (SQLException ex) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }

        return retorno;

    } 
    
    public static ArrayList<Produto> pesquisar(Produto p) throws SQLException {

        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        try {

            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM PRODUTO WHERE ID = ?;");
            comando.setInt(1, p.getId());


            ResultSet rs = comando.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setPreco_compra(rs.getDouble("PRECO_COMPRA"));
                produto.setPreco_venda(rs.getDouble("PRECO_VENDA"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setDisponivel(rs.getBoolean("DISPONIVEL"));
                produto.setDt_cadastro(rs.getTimestamp("DT_CADASTRO"));
                listaProdutos.add(produto);
            }
            

        } catch (ClassNotFoundException | SQLException ex) {
            listaProdutos = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                listaProdutos = null;
            }
        }

        return listaProdutos;
    }
    
    public static ArrayList<Produto> getProdutos() {
        ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

        try {

            Class.forName(DRIVER);
            conexao = conectaBanco();
            Statement comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM PRODUTO;");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setPreco_compra(rs.getDouble("PRECO_COMPRA"));
                produto.setPreco_venda(rs.getDouble("PRECO_VENDA"));
                produto.setQuantidade(rs.getInt("QUANTIDADE"));
                produto.setDisponivel(rs.getBoolean("DISPONIVEL"));
                produto.setDt_cadastro(rs.getTimestamp("DT_CADASTRO"));
                listaProdutos.add(produto);
            }

        } catch (ClassNotFoundException ex) {
            listaProdutos = null;
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            listaProdutos = null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            System.out.print(ex.getMessage());
                listaProdutos = null;
            }
        }

        return listaProdutos;
    }

    public static void pesquisar(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
    
}
