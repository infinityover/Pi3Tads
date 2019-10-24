/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.VendasProduto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class VendasProdutoDao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVIDOR = "localhost";
    private static final String PORTA = "3306";
    private static final String LOGIN = "root";
    private static final String SENHA = "121296Pk!";
    private static String url = "";
    private static Connection conexao;

    private static Connection conectaBanco() throws SQLException {

        url = "jdbc:mysql://" + SERVIDOR + ":" + PORTA + "/Pi3Tads?useTimezone=true&serverTimezone=UTC&useSSL=false";
        //System.out.print(url);
        return DriverManager.getConnection(url, LOGIN, SENHA);
    }

    /**
     *
     * @return
     */
    public ArrayList<VendasProduto> pesquisar(int idVenda ) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM vendaProduto where idVenda = ?;");
            comando.setInt(1, idVenda);
            ResultSet rs = comando.executeQuery();

            ArrayList<VendasProduto> listaVenda = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String idProduto = rs.getString("idProduto");
                Float valor = rs.getFloat("valor");
                int quantidade = rs.getInt("quantidade");
                Float desconto = rs.getFloat("desconto");
                listaVenda.add(new VendasProduto(id, idVenda, idProduto, valor, quantidade, desconto));
            }
            return listaVenda;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public VendasProduto pesquisarId(int idVendaProduto) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM vendaProduto where id = ?;");
            comando.setInt(1, idVendaProduto);
            ResultSet rs = comando.executeQuery();
            VendasProduto vendaProduto =null; 
            while (rs.next()) {
                int id = rs.getInt("id");
                String idProduto = rs.getString("idProduto");
                int idVenda = rs.getInt("idVenda");
                Float valor = rs.getFloat("valor");
                int quantidade = rs.getInt("quantidade");
                Float desconto = rs.getFloat("desconto");
                vendaProduto =  new VendasProduto(id, idVenda, idProduto, valor, quantidade, desconto);
            }
            return vendaProduto;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    public boolean salvar(VendasProduto vendaProduto) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO vendaProduto(idVenda ,idProduto ,valor ,quantidade ,desconto) values (?,?,?,?,?);");
            comando.setInt(1, vendaProduto.getIdVenda());
            comando.setString(2, vendaProduto.getIdProduto());
            comando.setFloat(3, vendaProduto.getValor());
            comando.setInt(4, vendaProduto.getQuantidade());
            comando.setFloat(5, vendaProduto.getDesconto());
            if (comando.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean editar(VendasProduto vendaProduto) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("UPDATE vendaProduto set idVenda  = ? ,idProduto  = ? ,valor  = ? ,quantidade  = ? ,desconto = ? where id = ?");
            comando.setInt(1, vendaProduto.getId());
            comando.setInt(2, vendaProduto.getIdVenda());
            comando.setString(3, vendaProduto.getIdProduto());
            comando.setFloat(4, vendaProduto.getValor());
            comando.setInt(5, vendaProduto.getQuantidade());
            comando.setFloat(6, vendaProduto.getDesconto());
            if (comando.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean excluir(int id) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM vendaProduto where id = ?;");
            comando.setInt(1, id);
            if (comando.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
    
        public boolean excluirVenda(int id) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM vendaProduto where idVenda = ?;");
            comando.setInt(1, id);
            if (comando.executeUpdate() > 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

}
