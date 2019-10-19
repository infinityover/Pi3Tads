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
    private static final String SENHA = "root";
    private static String url = "";
    private static Connection conexao;
    
    private static Connection conectaBanco() throws SQLException{

            url = "jdbc:mysql://"+SERVIDOR+":"+PORTA+ "/Pi3Tads?useTimezone=true&serverTimezone=UTC&useSSL=false";
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
               produtos.add(new Produto(id,nome,valor));
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
}
