package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paulo
 */
public class VendasProduto {

    private int id;
    private int idVenda;
    private int idProduto;
    private Float valor;
    private int quantidade;
    private Float desconto;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    

    public VendasProduto(int id, int idVenda, int idProduto, Float valor, int quantidade, Float desconto) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.valor = valor;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }
    
}
