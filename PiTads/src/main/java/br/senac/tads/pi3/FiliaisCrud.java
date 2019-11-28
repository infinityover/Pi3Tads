/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.FiliaisController;
import Model.Filial;
import java.io.IOException;
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
@WebServlet(name = "FiliaisCrud", urlPatterns = {"/FiliaisCrud"})
public class FiliaisCrud extends HttpServlet {

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
        String id = request.getParameter("id");
        if (id != null) {
            FiliaisController filaisController = new FiliaisController();
            Filial filial = filaisController.buscaFilial(id);

            request.setAttribute("id", filial.getId());
            request.setAttribute("apelido", filial.getApelido());
            request.setAttribute("estado", filial.getEstado());
            request.setAttribute("cidade", filial.getCidade());
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/filiaisCrud.jsp");
        dispatcher.forward(request, response);
    }
}
