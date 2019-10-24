/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.ProdutoController;
import Controller.VendasController;
import Model.Vendas;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "vendasEfetuar", urlPatterns = {"/VendasEfetuar"})
public class vendasEfetuar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        VendasController vendasController = new VendasController();
        ArrayList<Vendas> vendas = vendasController.listaVendas();
        request.setAttribute("Vendas", vendas);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendasEfetuar.jsp");
        dispatcher.forward(request, response);
        
    }

}
