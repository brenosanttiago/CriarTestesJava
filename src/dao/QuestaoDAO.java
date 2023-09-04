/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import model.Materia;
import model.Questoes;
/**
 *
 * @author aluno
 */
public class QuestaoDAO implements GenericDAO<Questoes>{
    
    private ConexaoBanco conexao;
    
    public QuestaoDAO(){
        this.conexao = new ConexaoBanco();
    }

    @Override
    public Questoes inserir(Questoes questao) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO QUESTAO  (enunciado, bimestre, gabarito, questaoID) VALUES (?, ?, ?, ?)";

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setString(1, questao.getEnunciado());
                sentenca.setInt(2, questao.getBimestre());
                sentenca.setString(3, questao.getGabarito());
                sentenca.setInt(4, questao.getQuestaoID());


                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Questão Inserida com Sucesso");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return questao;
    }

    @Override
    public ArrayList<Questoes> listar() {
        ArrayList<Questoes> listaQuestoes = new ArrayList<Questoes>();
        String sql = "SELECT * FROM questao ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                Questoes questao = new Questoes();
                    questao.setQuestaoID(resultadoSentenca.getInt("questaoID"));
                    questao.setEnunciado(resultadoSentenca.getString("enunciado"));
                    questao.setGabarito(resultadoSentenca.getString("gabarito"));
                    questao.setBimestre(resultadoSentenca.getInt("bimestre"));
                    
                  //questao.setMateria(resultadoSentenca.getIncompleto(""));
           
                    listaQuestoes.add(questao);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaQuestoes;
    }

    @Override
    public Object buscarID(Questoes questao) {
    String sql = "SELECT * FROM questao where questaoID = ? ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, questao.getQuestaoID());
                ResultSet resultadoSentenca = sentenca.executeQuery();
                    if (resultadoSentenca.next()) {
                        questao.setQuestaoID(resultadoSentenca.getInt("questaoID"));
                        questao.setEnunciado(resultadoSentenca.getString("enunciado"));
                        questao.setBimestre(resultadoSentenca.getInt("bimestre"));
                        questao.setGabarito(resultadoSentenca.getString("gabarito"));
                    }
                sentenca.execute(); //executa o comando no banco
                sentenca.close();
                this.conexao.getConnection().close();
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return questao;    }
    

    @Override
    public void atualizar(Questoes questao) {
     String sql = "UPDATE questao SET questaoID = ? where enunciado = ?";
    try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setInt(1, questao.getQuestaoID());
                sentenca.setString(2, questao.getEnunciado());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Questao Atualizada com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Questoes questao) {
        
    String sql = "DELETE FROM questao where questaoID = ?";
    try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setInt(1, questao.getQuestaoID());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Questao Deletada com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuestaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
}
