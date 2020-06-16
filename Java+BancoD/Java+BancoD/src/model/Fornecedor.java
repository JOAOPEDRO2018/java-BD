
package model;
public class Fornecedor {
    //atributos
    private int id;
    private String nome;
    private String senha; 
    private static int CpfRef;

    
    
    
    //construtor
   
    
    public Fornecedor(int cpf, String senha){
        this.CpfRef = cpf;
        this.senha = senha;

    }

    public Fornecedor() {
    }

    public Fornecedor(int id) {
        this.id = id;
   
    }
  
        
    
    
    

    public Fornecedor(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }
   
    
    
    public static int getCpfRef() {
        return CpfRef;
    }

    //gets e sets
    public static void setCpfRef(int CpfRef) {
        Fornecedor.CpfRef = CpfRef;
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
