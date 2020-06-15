/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dots.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class produtosBD {
ConexaoBD conectar = new ConexaoBD();

    public List<Produtos> listarProdutos(){
        conectar.conectarComDB();
        List<Produtos> pro = new ArrayList<>();
        
        String sql = "select * from produto";
        PreparedStatement pst;
        ResultSet rs;
    try {
        pst = conectar.conexao.prepareStatement(sql);
        //pst = conectar.conexao.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,
                //ResultSet.CONCUR_UPDATABLE); 
                
        rs = pst.executeQuery();
        
        while(rs.next()){
            Produtos a = new Produtos();
            a.setNome(rs.getString("nomeprod"));
            a.setIdprod(rs.getInt("idpro"));
            pro.add(a);
            
        }
        
    } catch (SQLException ex) {
        System.out.println("erro "+ex);
    }
    return pro;
    }
    
    public void excluirProduto(Produtos p){
        //conectar com o BD
        conectar.conectarComDB();
        String sql = "Delete from produto where idpro=?";
        PreparedStatement pst;
    try {
        pst = conectar.conexao.prepareStatement(sql);
        pst.setInt(1, p.getIdprod());
        //executar
        pst.execute();
        JOptionPane.showMessageDialog(null,"produto apagado da face da Terra!");
    } catch (SQLException ex) {
        System.out.println("Algo de errado não está certo! Codigo: "+ex);
    }
        
    }
    
    
    
    public void addProduto(Produtos p){
        //conecto com o banco
        conectar.conectarComDB();        
        //preparando a consulta em SQL
        //!!!!O SEGREDO ESTA AQUI!!!!
        String sql = "insert into produto (idpro, nomeprod, preco,fk_Idfor) values(?, ?, ?, ?)";
        //convertendo String em consulta
        PreparedStatement pst;
        try {
            pst = conectar.conexao.prepareStatement(sql);
            //substituindo os campos em ? ?
            pst.setInt(1, p.getIdprod());
            pst.setString(2, p.getNome());  
            pst.setDouble(3, p.getPreco());
            pst.setObject(4, p.getFornecedor().getId());
            //executar
            pst.execute();
            System.out.println("produto inserido");
            //JOptionPane.showMessageDialog(null,"Fornecedor inserido com sucesso!");
            conectar.desconectarBD();
            
        } catch (SQLException ex) {
            System.out.println("Erro ao enviar as instruções para SQL "+ex);
        }
     }
    
}
