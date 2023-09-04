
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConexaoBanco {
    
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;
    
    public ConexaoBanco()
    {
        this.servidor = "localhost";
        this.banco = "projetofinal";
        this.usuario = "root";
        this.senha = "";
    }
    
    public boolean conectar() throws ClassNotFoundException{

            try {
                //string de conexão com banco de dados
                String url = "jdbc:mysql://localhost:3306/projetofinal";
                Properties info = new Properties();
               // adicionando propriendades chave-valor
               //usuário do Banco
                info.put("user",this.usuario);
                //Senha do Banco
                info.put("password", this.senha);
                
                //Configuração do Driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                //Passagem do caminho do banco e dos paramentros de autenticação
                //para o SQL Connection
                this.conexao = DriverManager.getConnection(url, info);

                if ( this.conexao != null) {
                   
                    return true;
                }else
                {
                    
                    return false;
                }
        
         }
        catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public Connection getConnection() {
        return conexao;
    }

}