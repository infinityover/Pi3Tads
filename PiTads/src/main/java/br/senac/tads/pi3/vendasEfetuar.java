/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3;

import Controller.FiliaisController;
import Controller.VendasController;
import DAO.VendasProdutoDao;
import Model.Filial;
import Model.Vendas;
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
@WebServlet(name = "vendasEfetuar", urlPatterns = {"/VendasEfetuar"})
public class vendasEfetuar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessao = (String) session.getAttribute("usuario");
        if (sessao == null) {
            response.sendRedirect("/PiTads");
            return;
        }

//        
//        VendasController vendasController =  new VendasController();
//        int vendaId = Integer.valueOf(request.getParameter("VendaId"));
//        if(vendaId == 0){
//            vendaId = vendasController.vendaSalvar(new Vendas(0,"", new Timestamp(System.currentTimeMillis()), 0f));
//        }            
//        request.setAttribute("VendaId", vendaId);
//        
//        
//        VendasProdutoDao produtoVendasDao = new VendasProdutoDao();
//        
//        ArrayList<VendasProduto> produtoVendas = produtoVendasDao.pesquisar(vendaId);
//        request.setAttribute("Vendas", produtoVendas);
        FiliaisController filiaisController = new FiliaisController();
        ArrayList<Filial> filiais = filiaisController.listaFiliais();
        request.setAttribute("Filiais", filiais);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/vendasCriar.jsp");
        dispatcher.forward(request, response);

    }

}
