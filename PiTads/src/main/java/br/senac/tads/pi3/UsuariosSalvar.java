/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.FiliaisController;
import Controller.UsuarioController;
import Model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulo
 */
@WebServlet(name = "UsuariosSalvar", urlPatterns = {"/UsuariosSalvar"})
public class UsuariosSalvar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        String contextPath = request.getContextPath();
        if (sessao == null) {
            response.sendRedirect(contextPath);
            return;
        }
        String id = request.getParameter("id");
        if (id != null) {
            try {
                UsuarioController usuarioController = new UsuarioController();

                if (!id.isEmpty()) {
                    Usuario usuario = usuarioController.buscaUsuario(Integer.valueOf(id));
                    usuario = new Usuario(Integer.valueOf(request.getParameter("id")), request.getParameter("cpf"), request.getParameter("senha"), request.getParameter("perfil"));
                    usuarioController.usuarioEditar(usuario);
                } else {
                    Usuario usuario = new Usuario(0, request.getParameter("cpf"), request.getParameter("senha"), request.getParameter("perfil"));
                    usuarioController.usuarioSalvar(usuario);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        response.sendRedirect(contextPath + "/Usuarios");
    }
}
