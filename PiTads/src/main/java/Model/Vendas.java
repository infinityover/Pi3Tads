package Model;

import java.sql.Timestamp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo
 */
public class Vendas {

    private int id;
    private String idFilial;
    private Timestamp dataOp;
    private Float valor;
    private boolean vendaFinalizada;

    public Vendas(int id, String idFilial, Timestamp dataOp, Float valor, boolean vendaFinalizada) {
        this.id = id;
        this.idFilial = idFilial;
        this.dataOp = dataOp;
        this.valor = valor;
        this.vendaFinalizada = vendaFinalizada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(String idFilial) {
        this.idFilial = idFilial;
    }

    public Timestamp getDataOp() {
        return dataOp;
    }

    public void setDataOp(Timestamp dataOp) {
        this.dataOp = dataOp;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public boolean isVendaFinalizada() {
        return vendaFinalizada;
    }

    public void setVendaFinalizada(boolean vendaFinalizada) {
        this.vendaFinalizada = vendaFinalizada;
    }

    
}
