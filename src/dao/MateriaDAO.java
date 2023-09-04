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

/**
 *
 * @author aluno
 */
public class MateriaDAO implements GenericDAO <Materia> {
    
    private ConexaoBanco conexao;
    
    public MateriaDAO(){
        this.conexao = new ConexaoBanco();
    }
    
    @Override
    public Materia inserir(Materia materia){
//string com a consulta que será executada no banco
//String nome, String descricao, int serie, int materiaID
        String sql = "INSERT INTO Materia  (nome, descricao, serie, materiaID) VALUES (?, ?, ?, ?)";

        try {
            //tenta realizar a conexão, se retornar verdadeiro entra no IF
            if (this.conexao.conectar()) {
                //prepara a sentença com a consulta da string
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograções da consulta, pelo valor específico
                sentenca.setString(1, materia.getNome());
                sentenca.setString(2, materia.getDescricao());
                sentenca.setInt(3, materia.getSerie());
                sentenca.setInt(4, materia.getMateriaID());


                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n Materia Inserida com Sucesso");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return materia;
    }

    @Override
    public ArrayList<Materia> listar() {
    ArrayList<Materia> listaMateria = new ArrayList<Materia>();
        String sql = "SELECT * FROM materia ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    Materia materia = new Materia();
                    materia.setMateriaID(resultadoSentenca.getInt("materiaID"));
                    materia.setMateriaID(resultadoSentenca.getInt("disciplinaID"));
                    materia.setNome(resultadoSentenca.getString("nome"));
                    materia.setDescricao(resultadoSentenca.getString("descricao"));
                    materia.setSerie(resultadoSentenca.getInt("serie"));
           
                    listaMateria.add(materia);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaMateria;
    }

    @Override
    public Materia buscarID(Materia materia) {
 String sql = "SELECT * FROM materia where materiaID = ? ";
        try {

            if (this.conexao.conectar()) {

                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setInt(1, materia.getMateriaID());
                ResultSet resultadoSentenca = sentenca.executeQuery();
                    if (resultadoSentenca.next()) {
                        materia.setMateriaID(resultadoSentenca.getInt("materiaID"));
                        materia.setNome(resultadoSentenca.getString("nome"));
                        materia.setDescricao(resultadoSentenca.getString("descricao"));
                        materia.setSerie(resultadoSentenca.getInt("serie"));
                    }
                sentenca.execute(); //executa o comando no banco
                sentenca.close();
                this.conexao.getConnection().close();
                
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materia;    }

    @Override
    //sdljdsdsfjksfkjfkj
    public void atualizar(Materia materia) {
 String sql = "UPDATE materia SET materiaID = ? where nome = ?";
    try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setInt(1, materia.getDisciplinaID());
                sentenca.setString(2, materia.getNome());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n materia Atualizada com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Materia materia) {
     String sql = "DELETE FROM materia WHERE materiaID = ?";
           
       try{
       if(this.conexao.conectar()) {
           PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                //subtitui as interrograçõ es da consulta, pelo valor específico
                sentenca.setInt(1, materia.getMateriaID());
  
                sentenca.execute(); //executa o comando no banco
                sentenca.close(); //fecha a sentença
                this.conexao.getConnection().close(); //fecha a conexão com o banco
                
                System.out.println("\n materia Deletada com Sucesso");
       }
    } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}

}

    