/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.UsuarioController;
import Controller.VendasController;
import DAO.VendasProdutoDao;
import Model.Usuario;
import Model.VendasProduto;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulobelfi
 */
@WebServlet(name = "usuarios", urlPatterns = {"/Usuarios"})
public class Usuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        String contextPath = request.getContextPath();
        if (sessao == null) {
            response.sendRedirect(contextPath);
            return;
        }
        UsuarioController usuarioController = new UsuarioController();
        ArrayList<Usuario> usuarios = usuarioController.listaUsuario();
        request.setAttribute("Usuarios", usuarios);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/usuariosLista.jsp");
        dispatcher.forward(request, response);

    }

}
