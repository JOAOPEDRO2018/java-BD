
package model;
public class Fornecedor {
    //atributos
    private int id;
    private String nome;
    private String senha; 
    int CpfRef;

    
    
    
    //construtor
   
    
    public Fornecedor(int cpf, String senha){
        this.id = cpf;
        this.senha = senha;
        this.CpfRef = cpf;
        
    }

    public Fornecedor() {
    }

    public Fornecedor(int id) {
        this.id = id;
        this.CpfRef = id;
    }
    
    
    
    

    public Fornecedor(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
    
    
    
    
    //gets e sets
    public int getCpfRef() {
        return CpfRef;
    }

    public void setCpfRef(int CpfRef) {
        this.CpfRef = id;
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

    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
    
    
    
    
    
    
    
}
