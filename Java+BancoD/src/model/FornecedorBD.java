
package model;

import dots.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author joaop
 */
public class FornecedorBD {
    int idReferencia;

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
        String sql = "insert into fornecedor(idfor, nome) values(?, ?)";
        //convertendo String em consulta
        PreparedStatement pst;
        try {
            pst = conectar.conexao.prepareStatement(sql);
            //substituindo os campos em ? ?
            pst.setInt(1, f.getId());
            pst.setString(2, f.getNome());            
            //executar
            pst.execute();
            System.out.println("Fornecedor inserido");
            //JOptionPane.showMessageDialog(null,"Fornecedor inserido com sucesso!");
            conectar.desconectarBD();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao enviar as instruções para SQL "+ex);
        }
     }
     
     public void excluirFornecedor(Fornecedor f){
        //conectar com o BD
        conectar.conectarComDB();
        String sql = "Delete from Fornecedor where idfor=?";
        PreparedStatement pst;
    try {
        pst = conectar.conexao.prepareStatement(sql);
        pst.setInt(1, f.getId());
        //executar
        pst.execute();
        JOptionPane.showMessageDialog(null,"Fornecedor apagado da face da Terra!");
    } catch (SQLException ex) {
        System.out.println("Algo de errado não está certo! Codigo: "+ex);
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
     
     
     
     
     
     
     
     
}
    
    
    
    
    
    
    
    
    
    
    

