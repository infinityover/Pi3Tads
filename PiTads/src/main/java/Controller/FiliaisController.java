/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FilialDao;
import Model.Filial;
import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class FiliaisController {

    public ArrayList<Filial> listaFiliais() {
        FilialDao filialdao = new FilialDao();
        return filialdao.pesquisar();
    }

    public Filial buscaFilial(String id) {
        FilialDao filialdao = new FilialDao();
        return filialdao.pesquisarId(id);
    }

    public boolean filialSalvar(Filial filial) {
        FilialDao filialdao = new FilialDao();
        return filialdao.salvar(filial);
    }

    public boolean filialEditar(Filial filial) {
        FilialDao filialdao = new FilialDao();
        return filialdao.editar(filial);
    }

    public boolean filialExcluir(String id) {
        FilialDao filialdao = new FilialDao();
        return filialdao.excluir(id);
    }
}
