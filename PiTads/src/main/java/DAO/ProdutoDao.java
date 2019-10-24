/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
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
public class ProdutoDao {

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
    public ArrayList<Produto> pesquisar() {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM produto;");

            ResultSet rs = comando.executeQuery();

            ArrayList<Produto> produtos = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String nome = rs.getString("nome");
                Float valor = rs.getFloat("valor");
                produtos.add(new Produto(id, nome, valor));
            }
            return produtos;
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

    public Produto pesquisarId(String id) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM produto where id = ?;");
            comando.setString(1, id);
            ResultSet rs = comando.executeQuery();
            Produto prod = null;
            while (rs.next()) {
                prod = new Produto(rs.getString("id"), rs.getString("nome"), rs.getFloat("valor"));
            }
            return prod;
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

    public boolean salvar(Produto prod) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO PRODUTO(id, nome, valor) values (?,?,?);");
            comando.setString(1, prod.getId());
            comando.setString(2, prod.getNome());
            comando.setFloat(3, prod.getValor());
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

    public boolean editar(Produto prod) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("UPDATE Produto set nome = ?, valor = ? where id = ?");
            comando.setString(1, prod.getNome());
            comando.setFloat(2, prod.getValor());
            comando.setString(3, prod.getId());
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

    public boolean excluir(String id) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM produto where id = ?;");
            comando.setString(1, id);
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
