
package dots;
//responsavel por 
// conectar com o banco

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoBD {
    //definir a url do banco
    //tipo do banco + endereço + porta 
    //private String timezone = "?useTimezone=true&serverTimezone+UTC";
    private String url = "jdbc:mysql://localhost:3306/bancodedados?user=root&password=rootQAZxsw2&serverTimezone=UTC";
    private String usuario = "root";
    private String senha = "root";
     
   
    //driver para conectar com o Banco
    //private String driver = "com.mysql.cj.jdbc.Driver";
    
    //criando a classe chamada conection
    public Connection conexao;
    
    public void conectarComDB(){
        try {
            //criar o gerenciador  de drivers
            //realizar conexao com Banco
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro "+ex+" ao conectar com o Banco de Dados");
        }
        
    }
    public void desconectarBD(){
        try {
            conexao.close();
            System.out.println("Banco desconectado com segurança");
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex+"ao tentar desconectar com o Banco");
        }
    }
     
    
}
