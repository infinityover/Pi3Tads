/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Filial;
import Model.Usuario;
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
public class UsuariosDao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVIDOR = "pimysql.mysql.database.azure.com";
    private static final String PORTA = "3306";
    private static final String LOGIN = "infinityover@pimysql";
    private static final String SENHA = "Senha2019!";
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
    public Usuario login(String cpf, String senha) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM usuarios where cpf = ? and senha = ?;");
            comando.setString(1, cpf);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            Usuario usuario = null;
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("id"), rs.getString("cpf"), rs.getString("senha"), rs.getString("perfil"));
            }
            return usuario;
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
    
    
        public ArrayList<Usuario> listaUsuario() {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM usuarios;");

            ResultSet rs = comando.executeQuery();

            ArrayList<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String senha = rs.getString("senha");
                String perfil = rs.getString("perfil");
                usuarios.add(new Usuario(id, cpf , senha, perfil));
            }
            return usuarios;
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

    public Usuario pesquisarId(int id) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM usuarios where id = ?;");
            comando.setInt(1, id);
            ResultSet rs = comando.executeQuery();
            Usuario usuario = null;
            while (rs.next()) {
                usuario = new Usuario(rs.getInt("id"), rs.getString("cpf"), rs.getString("senha"), rs.getString("perfil"));
            }
            return usuario;
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

    public boolean salvar(Usuario usuario) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("INSERT INTO usuarios(cpf, perfil, senha) values (?,?,?);");
            comando.setString(1, usuario.getCpf());
            comando.setString(2, usuario.getPerfil());
            comando.setString(3, usuario.getSenha());
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

    public boolean editar(Usuario usuario) {
        try {
            Class.forName(DRIVER);
            conexao = conectaBanco();
            PreparedStatement comando = conexao.prepareStatement("UPDATE usuarios set cpf = ?, senha= ?, perfil = ? where id = ?");
            comando.setString(1, usuario.getCpf());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getPerfil());
            comando.setInt(4, usuario.getId());
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
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM usuarios where id = ?;");
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
