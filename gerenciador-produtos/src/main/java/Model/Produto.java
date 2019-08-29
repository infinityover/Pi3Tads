package Model;

import java.sql.Timestamp;

/**
 *
 * @author gabrielavsmarques
 */
public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private double preco_compra;
    private double preco_venda; 
    private int quantidade;
    private boolean disponivel;
    private Timestamp dt_cadastro;

    public Produto(){
    }
    
    public Produto(int id, String nome, String descricao, double preco_compra, double preco_venda, int quantidade, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        
        
    }
    
    public Produto( String nome, String descricao, double preco_compra, double preco_venda, int quantidade, boolean disponivel, Timestamp dt_cadastro) {
    
        this.nome = nome;
        this.descricao = descricao;
        this.preco_compra = preco_compra;
        this.preco_venda = preco_venda;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.dt_cadastro = dt_cadastro;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_compra() {
        return preco_compra;
    }

    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public double getPreco_venda() {
        return preco_venda;
    }


    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Timestamp getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Timestamp dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }
    

       
}
