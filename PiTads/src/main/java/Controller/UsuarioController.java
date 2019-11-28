/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuariosDao;
import Model.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class UsuarioController {

    public Usuario loginUsuario(String cpf, String senha) throws NoSuchAlgorithmException {
        UsuariosDao usuariosDao = new UsuariosDao();
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(senha.getBytes(),0,senha.length());
        senha = new BigInteger(1,m.digest()).toString(16);
        return usuariosDao.login(cpf, senha);
    }

    public Usuario buscaUsuario(int id) {
        UsuariosDao usuariosDao = new UsuariosDao();
        return usuariosDao.pesquisarId(id);
    }
    
    public ArrayList<Usuario> listaUsuario() {
        UsuariosDao usuariosDao = new UsuariosDao();
        return usuariosDao.listaUsuario();
    }

    public boolean usuarioSalvar(Usuario usuario) throws NoSuchAlgorithmException {
        UsuariosDao usuariosDao = new UsuariosDao();
        
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(usuario.getSenha().getBytes(),0,usuario.getSenha().length());
        usuario.setSenha(new BigInteger(1,m.digest()).toString(16));
        return usuariosDao.salvar(usuario);
    }

    public boolean usuarioEditar(Usuario usuario) throws NoSuchAlgorithmException {
        UsuariosDao usuariosDao = new UsuariosDao();
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(usuario.getSenha().getBytes(),0,usuario.getSenha().length());
        usuario.setSenha(new BigInteger(1,m.digest()).toString(16));
        return usuariosDao.editar(usuario);
    }

    public boolean usuarioExcluir(int id) {
        UsuariosDao usuariosDao = new UsuariosDao();
        return usuariosDao.excluir(id);
    }
}
