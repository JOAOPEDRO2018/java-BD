
package model;
public class Cliente {
    private int id;
    private String nome;
    
    //CONSTRUTORES
    public Cliente(){
        
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    //GETS SETS

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}
