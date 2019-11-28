/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.ProdutoController;
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
@WebServlet(name = "produtoExcluir", urlPatterns = {"/ProdutoExcluir"})
public class produtoExcluir extends HttpServlet {

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
            ProdutoController produtoController = new ProdutoController();
            produtoController.produtoExcluir(id);
        }
        response.sendRedirect(contextPath + "/produtos");
    }
}
