
package model;

import dots.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Menu;

/**
 *
 * @author joaop
 */
public class FornecedorBD {
    int idReferencia;
    boolean logado = false;
    
    

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    

    public int getIdReferencia() {
        return idReferencia;
    }

    public void setIdReferencia(int idReferencia) {
        this.idReferencia = idReferencia;
    }
    
    
    ConexaoBD conectar = new ConexaoBD();
    
    
     public void cadastrarfornecedor(Fornecedor f){
        //conecto com o banco
        conectar.conectarComDB();        
        //preparando a consulta em SQL
        //!!!!O SEGREDO ESTA AQUI!!!!
        String sql = "insert into fornecedor(idfor, nome, senha) values(?, ?, ?)";
        //convertendo String em consulta
        PreparedStatement pst;
        try {
            pst = conectar.conexao.prepareStatement(sql);
            //substituindo os campos em ? ?
            pst.setInt(1, f.getId());
            pst.setString(2, f.getNome()); 
            pst.setString(3, f.getSenha());
            //executar
            pst.execute();
            System.out.println("Fornecedor inserido");
            //JOptionPane.showMessageDialog(null,"Fornecedor inserido com sucesso!");
            conectar.desconectarBD();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao enviar as instruções para SQL "+ex);
        }
     }
     
            
    
    
      public void editarFornecedor(Fornecedor f){
        //conecta com BD
        conectar.conectarComDB();
        //passa o comando SQL
        String sql = "update Cliente set nome=?, idfor=? where idfor=? ";
        PreparedStatement pst;
    try {
        pst = conectar.conexao.prepareStatement(sql);        
        pst.setString(1, f.getNome());
        pst.setInt(2, f.getId());
        pst.setInt(3, getIdReferencia());
        pst.execute();
        conectar.desconectarBD();
        JOptionPane.showMessageDialog(null,"Aluno Editado");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro: "+ex);
    }
        
    }
     
      
    public void buscarFornecedor(Fornecedor f){
         conectar.conectarComDB();
         String sql = "select * from fornecedor where idfor = ?";
         PreparedStatement pst; 
         ResultSet rs;         
         //Fornecedor f = new Fornecedor();
    try {
        
        pst = conectar.conexao.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        pst.setInt(1, f.getId());
        rs = pst.executeQuery();
        rs.first();
        
        f.setNome(rs.getString("nome"));
        
        JOptionPane.showMessageDialog(null,"'"+f.getNome()+"' Era quem você procurava?");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Fornecedor não cadastrado");
    }
   
    }
     
     
    public void excluirFornecedor(Fornecedor p){
        //conectar com o BD
        conectar.conectarComDB();
        String sql = "Delete from fornecedor where idfor=?";
        PreparedStatement pst;
    try {
        pst = conectar.conexao.prepareStatement(sql);
        pst.setInt(1, p.getId());
        //executar
        pst.execute();
        JOptionPane.showMessageDialog(null,"fornecedor apagado da face da Terra!");
    } catch (SQLException ex) {
        System.out.println("Algo de errado não está certo! Codigo: "+ex);
    }
        
    }
     
     public void logar(Fornecedor f){
         
         boolean logado;
         conectar.conectarComDB();
         String sql = "select * from fornecedor where idfor =? and senha =?";
         PreparedStatement pst;
         ResultSet rs;
        try {
            pst = conectar.conexao.prepareStatement(sql);
            pst.setInt(1, f.getId());
            pst.setString(2, f.getSenha());
            rs = pst.executeQuery();
            
            if(rs.next()){
                Menu menu = new Menu();
                menu.setVisible(true);
                setLogado(true); 
            }
            else{
                JOptionPane.showMessageDialog(null, "usuário e/ou senha errados: ");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "usuário e/ou senha errados: "+ex);
        }
         
         
     }

     
     
     
}
    
    
    
    
    
    
    
    
    
    
    

