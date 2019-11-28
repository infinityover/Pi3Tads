/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.VendasController;
import Model.Vendas;
import java.io.IOException;
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
@WebServlet(name = "VendasRelatorio", urlPatterns = {"/VendasRelatorio"})
public class VendasRelatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        if (sessao == null) {
            response.sendRedirect("/PiTads");
            return;
        }
        VendasController vendasController = new VendasController();
        ArrayList<Vendas> produtoVendas = vendasController.listaVendas();
        request.setAttribute("Vendas", produtoVendas);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendasRelatorio.jsp");
        dispatcher.forward(request, response);

    }

}
