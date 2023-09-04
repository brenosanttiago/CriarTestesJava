/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import model.Materia;
import model.Questoes;
import model.Teste;
/**
 *
 * @author aluno
 */
public class TesteDAO implements GenericDAO <Teste>{

    private ConexaoBanco conexao;
    
    public TesteDAO(){
        this.conexao = new ConexaoBanco();
    }
    
    @Override
    public Teste inserir(Teste teste) {
    
        String sql = "INSERT INTO TESTE (dataGerao) VALUES (?)";

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setDate(1, (Date) teste.getDataGeracao());       
                sentenca.execute(); //executa o comando no banco
                
                ResultSet rs = sentenca.getGeneratedKeys();
                
                if(rs.next()){
                    
                    teste.setTesteID(rs.getInt(1));
                }
                
                
                sentenca.close(); //fecha a sentença
 
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Teste Inserido com Sucesso");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;
    }
    
    
    public void InserirQuestoes(Teste teste){
      
      
      try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
        if (this.conexao.conectar()) {   
       for(Questoes questoes:teste.getListaQuestoes()){
              
            String sql = "INSERT INTO TESTEQUESTOES(QUESTAOID,TESTEID) VALUES(?,?)";  
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     
              sentenca.setInt(1, questoes.getQuestaoID());
              sentenca.setInt(2, teste.getTesteID());
              sentenca.execute();
            
        }  
        }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    @Override
    public ArrayList<Teste> listar() {
      ArrayList<Teste> listaTeste = new ArrayList<Teste>();
        String sql = "SELECT * FROM teste ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    Teste teste = new Teste();
                    teste.setDataGeracao(resultadoSentenca.getDate("datagerao"));
                    teste.setListaQuestoes(teste.getListaQuestoes());
                    teste.setTesteID(resultadoSentenca.getInt("TesteID"));
           
                    listaTeste.add(teste);
                    
                }
               
                sentenca.close();
                this.conexao.getConnection().close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaTeste;
    }  
    

    @Override
    public Object buscarID(Teste teste) {
 String sql = "SELECT * FROM teste where TesteID = ? ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, teste.getTesteID());
                ResultSet resultadoSentenca = sentenca.executeQuery();
                    if (resultadoSentenca.next()) {
                        teste.setTesteID(resultadoSentenca.getInt("testeID"));
                        teste.setDataGeracao(resultadoSentenca.getDate("datagerao"));
                    }
                sentenca.execute(); //executa o comando no banco
                sentenca.close();
                this.conexao.getConnection().close();
                System.out.println(teste.getTesteID());
                
                System.out.println(teste.getDataGeracao());
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teste;   
    }

    @Override
    public void atualizar(Teste teste) {
String sql = "UPDATE teste SET datagerao = ? where testeID = ?";
    try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setDate(1, (Date) teste.getDataGeracao());
                sentenca.setInt(2, teste.getTesteID());
                
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Teste Atualizado com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Teste teste) {
String sql = "DELETE FROM teste where TesteID = ?";
    try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setInt(1, teste.getTesteID());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Teste Deletado com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TesteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

   
    
}
