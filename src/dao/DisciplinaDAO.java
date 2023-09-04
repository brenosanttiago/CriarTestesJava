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
import model.Disciplina;
/**
 *
 * @author aluno
 */
public class DisciplinaDAO implements GenericDAO<Disciplina>{
    
    private ConexaoBanco conexao;
    
    public DisciplinaDAO(){
        this.conexao = new ConexaoBanco();
    }

    @Override
    public Disciplina inserir(Disciplina disciplina) {
    String sql = "INSERT INTO DISCIPLINA (nome) VALUES (?)";

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setString(1, disciplina.getNome());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Disciplina Inserida com Sucesso");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return disciplina;
    }

    @Override
    public void excluir(Disciplina disciplina) {
    String sql = "DELETE FROM disciplina where disciplinaID = ?";
    try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setInt(1, disciplina.getDisciplinaID());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Disciplina Deletada com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
    
    @Override
    public void atualizar(Disciplina disciplina) {
        String sql = "UPDATE disciplina SET nome = ? where disciplinaID = ? ";
    try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setInt(2, disciplina.getDisciplinaID());
                sentenca.setString(1, disciplina.getNome());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Disciplina Atualizada com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public ArrayList<Disciplina> listar() {
    ArrayList<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
        String sql = "SELECT * FROM disciplina ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    Disciplina  disciplina = new  Disciplina();
                    disciplina.setDisciplinaID(resultadoSentenca.getInt("disciplinaID"));
                      disciplina.setNome(resultadoSentenca.getString("nome"));
           
                    listaDisciplina.add(disciplina);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaDisciplina;    }
    
    @Override
    public Disciplina buscarID(Disciplina disciplina) {
        String sql = "SELECT * FROM disciplina where disciplinaID = ? ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, disciplina.getDisciplinaID());
                ResultSet resultadoSentenca = sentenca.executeQuery();
                    if (resultadoSentenca.next()) {
                        disciplina.setDisciplinaID(resultadoSentenca.getInt("disciplinaID"));
                        disciplina.setNome(resultadoSentenca.getString("nome"));
                    }
                sentenca.execute(); //executa o comando no banco
                sentenca.close();
                this.conexao.getConnection().close();
                System.out.println(disciplina.getDisciplinaID());
                System.out.println(disciplina.getNome());
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return disciplina;
    }

}
