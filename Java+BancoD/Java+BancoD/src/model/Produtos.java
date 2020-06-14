
package model;
public class Produtos {
    private int idprod;
    private String nome;
    private double preco; 
    private Fornecedor fornecedor;

    public Produtos(int idprod) {
        this.idprod = idprod;
        
    }

    public Produtos() {
    }

    public Produtos(int idprod, String nome, double preco, Fornecedor fornecedor) {
        this.idprod = idprod;
        this.nome = nome;
        this.preco = preco;
        this.fornecedor = fornecedor;
    }
       
    
    
    
    
    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
