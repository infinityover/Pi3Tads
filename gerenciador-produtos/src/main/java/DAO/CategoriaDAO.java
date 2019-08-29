/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import Model.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author paulobelfi
 */
public class CategoriaDAO {
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
    
    public static int pesquisar(String p) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT ID FROM CATEGORIA WHERE NOME = ?;");
            comando.setString(1, p);
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next()) {
                return rs.getInt("ID");
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        }
        return -1;
    }
    
    
    public static String pesquisarPorId(int p) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM CATEGORIA WHERE ID = ?;");
            comando.setInt(1, p);
            
            ResultSet rs = comando.executeQuery();
            
            while (rs.next()) {
                return rs.getString("NOME");
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        }
        return null;
    }
    
     public static ArrayList<Categoria> pesquisar() {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM CATEGORIA;");
            
            ResultSet rs = comando.executeQuery();
            
            ArrayList<Categoria> categorias = new ArrayList<Categoria>();
            while (rs.next()) {
               categorias.add(new Categoria(rs.getInt("ID"),rs.getString("NOME")));
            }
            return categorias;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
