/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.UsuarioController;
import Model.Usuario;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //UsuarioController usuarioController = new UsuarioController();
        Object cpf = request.getParameter("Cpf");
        Object senha = request.getParameter("Senha");
        RequestDispatcher dispatcher;
        boolean error = false;
        if (cpf.toString().isEmpty()) {
            error = true;
            request.setAttribute("cpfError", true);
            request.setAttribute("cpf", cpf.toString());
        }
        if (senha.toString().isEmpty()) {
            error = true;
            request.setAttribute("senhaError", true);
        }

        if (error) {
            dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            dispatcher.forward(request, response);
        } else {
            UsuarioController usuarioController = new UsuarioController();
            try {
                Usuario usuario = usuarioController.loginUsuario(cpf.toString(), senha.toString());
                if (usuario != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", cpf);
                    session.setAttribute("perfil", usuario.getPerfil());
                    processRequest(request, response);
                } else {
                    request.setAttribute("loginError", true);
                    dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
