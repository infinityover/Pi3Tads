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

/**
 *
 * @author paulobelfi
 */
@WebServlet(name = "VendasListar", urlPatterns = {"/VendasListar"})
public class VendasListar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        VendasController vendasController =  new VendasController();
        ArrayList<Vendas> produtoVendas = vendasController.listaVendas();
        request.setAttribute("Vendas", produtoVendas);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendasLista.jsp");
        dispatcher.forward(request, response);
        
    }

}
