/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Vendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class VendasDao {

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
    public ArrayList<Vendas> pesquisar() {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM Vendas;");

            ResultSet rs = comando.executeQuery();

            ArrayList<Vendas> vendas = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String idFilial = rs.getString("idFilial");
                Timestamp dataOp = rs.getTimestamp("dataOp");
                Float valor = rs.getFloat("valor");
                vendas.add(new Vendas(id, idFilial,dataOp,valor));
            }
            return vendas;
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

    public Vendas pesquisarId(int id) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM vendas where id = ?;");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();
            Vendas vendas = null;
            while (rs.next()) {
                vendas = new Vendas(rs.getInt("id"), rs.getString("idFilial"), rs.getTimestamp("dataOp"), rs.getFloat("valor"));
            }
            return vendas;
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

    public boolean salvar(Vendas venda) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO vendas(idFilial ,dataOp ,valor) values (?,?,?);");
            comando.setString(1, venda.getIdFilial());
            comando.setTimestamp(2, venda.getDataOp());
            comando.setFloat(3, venda.getValor());
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

    public boolean editar(Vendas venda) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("UPDATE vendas set idFilial = ?, dataOp = ?, valor= ? where id = ?");
            comando.setString(1, venda.getIdFilial());
            comando.setTimestamp(2, venda.getDataOp());
            comando.setFloat(3, venda.getValor());
            comando.setInt(4, venda.getId());
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
            VendasProdutoDao vendasDao = new VendasProdutoDao();
            vendasDao.excluirVenda(id);
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM vendas where id = ?;");
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
