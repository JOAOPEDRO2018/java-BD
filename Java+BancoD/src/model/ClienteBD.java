package model;

import com.mysql.cj.xdevapi.PreparableStatement;
import dots.ConexaoBD;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ClienteBD {
//metodos para cadastrar, alterar e excluir alunos 
//Conectar com o banco de dados
//realizar as consultas no BD
//sera enviado os dados para o Banco de dados 
ConexaoBD conectar = new ConexaoBD();
//pra que caralho isso mesmo?
int refCliente;

    public int getRefAluno() {
        return refCliente;
    }

    public void setRefAluno(int refCliente) {
        this.refCliente = refCliente;
    }

   public void cadastrarCliente(Cliente a){
        //conecto com o banco
        conectar.conectarComDB();        
        //preparando a consulta em SQL
        //!!!!O SEGREDO ESTA AQUI!!!!
        String sql = "insert into Cliente(cpd, nome) values(?, ?)";
        //convertendo String em consulta
        PreparedStatement pst;
        try {
            pst = conectar.conexao.prepareStatement(sql);
            //substituindo os campos em ? ?
            pst.setInt(1, a.getid());
            pst.setString(2, a.getNome());            
            //executar
            pst.execute();
            JOptionPane.showMessageDialog(null,"Cliente inserido com sucesso!");
            conectar.desconectarBD();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao enviar as instruções para SQL "+ex);
        }
        
        
    }
    
    public void excluirCliente(Cliente a){
        //conectar com o BD
        conectar.conectarComDB();
        String sql = "Delete from Cliente where cpd=?";
        PreparedStatement pst;
    try {
        pst = conectar.conexao.prepareStatement(sql);
        pst.setInt(1, a.getid());
        //executar
        pst.execute();
        JOptionPane.showMessageDialog(null,"Cliente apagado da face da Terra!");
    } catch (SQLException ex) {
        System.out.println("Algo de errado não está certo! Codigo: "+ex);
    }
        
    }
    
    
    public void editarCliente(Cliente a){
        //conecta com BD
        conectar.conectarComDB();
        //passa o comando SQL
        String sql = "update Cliente set nome=?, cpd=? where cpd=? ";
        PreparedStatement pst;
    try {
        pst = conectar.conexao.prepareStatement(sql);
        pst.setString(1, a.getNome());
        pst.setInt(2, a.getid());
        pst.setInt(3, getRefAluno());
        pst.execute();
        conectar.desconectarBD();
        JOptionPane.showMessageDialog(null,"Aluno Editado");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro: "+ex);
    }
        
    }
    
    public Cliente buscarCliente(int cpd){
         conectar.conectarComDB();
         String sql = "select * from Cliente where cpd = "+cpd;
         PreparedStatement pst; 
         ResultSet rs;
         
         Cliente a = new Cliente();
    try {
        pst = conectar.conexao.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        rs = pst.executeQuery();
        rs.first();
        
        a.setNome(rs.getString("nome"));
        
        System.out.println("nome: "+a.getNome());
    } catch (SQLException ex) {
        System.out.println("erro: "+ex);
    }
    
    return a;
    }
    
    public List<Cliente> listarClientes(){
        conectar.conectarComDB();
        List<Cliente> clien = new ArrayList<>();
        
        String sql = "select * from cliente";
        PreparedStatement pst;
        ResultSet rs;
    try {
        pst = conectar.conexao.prepareStatement(sql);
        //pst = conectar.conexao.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                //ResultSet.CONCUR_UPDATABLE); 
                
        rs = pst.executeQuery();
        
        while(rs.next()){
            Cliente a = new Cliente();
            a.setNome(rs.getString("nome"));
            a.setid(rs.getInt("idcli"));
            clien.add(a);
            
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    return clien;
    }

}











