/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoriaProdutoDAO;
import Model.Categoria;
import java.util.ArrayList;

/**
 *
 * @author paulobelfi
 */
public class CategoriaProdutoController {
    
    public static ArrayList<Categoria> Pesquisar(int id) {
        return CategoriaProdutoDAO.pesquisarPorProduto(id);
    }
    public static boolean Salvar(ArrayList<Categoria> cat,int id) {
       return CategoriaProdutoDAO.salvar(cat,id);
    }
}
