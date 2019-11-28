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
public class VendasProdutoUserView {

    private int id;
    private int idVenda;
    private String idProduto;
    private String nomeProduto;
    private Float valor;
    private Float total;
    private int quantidade;
    private Float desconto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float Total) {
        this.total = Total;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
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
    
    public VendasProdutoUserView(int id, int idVenda, String idProduto, String nomeProduto, Float valor, Float Total, int quantidade, Float desconto) {
        this.id = id;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.total = Total;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }
}
