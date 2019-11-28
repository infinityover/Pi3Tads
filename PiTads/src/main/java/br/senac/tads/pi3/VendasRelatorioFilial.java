/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.FiliaisController;
import Controller.VendasController;
import Model.Vendas;
import Model.Filial;
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
@WebServlet(name = "VendasRelatorioFilial", urlPatterns = {"/VendasRelatorioFilial"})
public class VendasRelatorioFilial extends HttpServlet {

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

        String filial = request.getParameter("filial");

        FiliaisController filiaisController = new FiliaisController();
        ArrayList<Filial> filiais = filiaisController.listaFiliais();
        request.setAttribute("Filiais", filiais);
        VendasController vendasController = new VendasController();
        if (filial != null) {
            ArrayList<Vendas> produtoVendas = vendasController.listaVendasPorFilial(new Filial(filial.toString(), "", "", ""));
            request.setAttribute("Vendas", produtoVendas);
        } else {
            ArrayList<Vendas> produtoVendas = vendasController.listaVendas();
            request.setAttribute("Vendas", produtoVendas);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendasRelatorioFilial.jsp");
        dispatcher.forward(request, response);

    }

}
