
package model;
public class Fornecedor {
    //atributos
    private int id;
    private String nome; 
    
    //construtor
    
    public Fornecedor(){
        
        
    }
    
    public Fornecedor(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    //gets e sets
    
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

    
    
    
    
    
    
    
    
    
    
    
    
}
