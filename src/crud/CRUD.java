/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dao.DisciplinaDAO;
import dao.MateriaDAO;
import dao.QuestaoDAO;
import dao.TesteDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import model.Disciplina;
import model.Materia;
import model.Questoes;
import model.Teste;
/**
 *
 * @author aluno
 */
public class CRUD {
    public static void main(String[]args) throws ClassNotFoundException{
        
        
       /*INSERIR DISCIPLINA
        Disciplina d1 = new Disciplina("Matematica");
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        disciplinaDAO.inserir(d1);
        */
       
       
        
       //Calendar c = Calendar.getInstance();
     
        Teste teste1 =  new Teste();
        
        
        //CALENDARIO
        /*
        c.set(Calendar.YEAR, 2023);
        c.set(Calendar.MONTH, Calendar.APRIL);
        c.set(Calendar.DAY_OF_MONTH, 10);
        java.sql.Date data = new java.sql.Date(c.getTimeInMillis());
        
        teste1.setDataGeracao(data);
        */
        
      
        //ADICIONAR QUESTOES
        Questoes questoa1 = new Questoes(1,"enunciado","gabarito",2);
        QuestaoDAO questaoDAO =  new QuestaoDAO();
        
        //LISTAR QUESTOES DO TESTE
        ArrayList<Questoes> listaQuestoes = new ArrayList<Questoes>();
        listaQuestoes.add(questoa1);
        
        teste1.setListaQuestoes(listaQuestoes);
        
        TesteDAO testeDAO =  new TesteDAO();
       // testeDAO.listar();
       
        //INSERIR TESTE
        //teste1 = testeDAO.inserir(teste1);
        //testeDAO.InserirQuestoes(teste1);
        
       
       //LISTAR TESTE
       for(Teste teste:testeDAO.listar()){
            
                   System.out.println(teste.getTesteID());
                   System.out.println(teste.getListaQuestoes());
                   System.out.println(teste.getDataGeracao());
        }
        
        /*LISTAR QUESTOES
        QuestaoDAO questaoDAO = new QuestaoDAO();
               for(Questoes m:questaoDAO.listar()){
                
                   System.out.println(m.getQuestaoID());
                   System.out.println(m.getEnunciado());
                   System.out.println(m.getGabarito());  
                   System.out.println(m.getBimestre());
        
       EXCLUIR TESTE
       testeDAO.excluir(teste1);
        */
       
        //CONSTRUTOR QUESTAO
        //int questaoID, String enunciado, String gabarito, int bimestre, Materia materia*/
        
        //CONSTRUTOR MATERIA
        //String nome, String descricao, int serie, int materiaID
       
       // DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
       
        //INSERIR QUESTAO
        // QuestaoDAO questaoDAO = new QuestaoDAO();
        /*Questao q1 = new Questao(1,"enunciado","gabarito",2);
        QuestaoDAO QuestaoDAO = new QuestaoDAO();
               
            questaoDAO.inserir(q1);
        */
       
       //EXCLUIR MATERIA
       /*Materia m1 = new Materia(1);
        MateriaDAO materiaDAO = new MateriaDAO();
       materiaDAO.excluir(m1);
       */ 
        
        //BUSCAR MATERIA
        /*Materia m1 = new Materia(2);
             MateriaDAO materiaDAO = new MateriaDAO();
             m1 = materiaDAO.buscarID(m1);
             System.out.println(m1.getNome());
             System.out.println(m1.getMateriaID());
             System.out.println(m1.getDescricao());
             System.out.println(m1.getSerie());
        */
        
        //LISTAR DISCIPLINA
        /*DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        for(Disciplina d:disciplinaDAO.listar()){
                
                  
                   System.out.println(d.getNome());
                  
                   System.out.println(d.getDisciplinaID());
        }
        
        */
        
        
        //BUSCAR DISCIPLINA
             /*Disciplina d1 = new Disciplina(1);
             DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
             d1 = disciplinaDAO.buscarID(d1);
             
             System.out.println(d1.getNome());
             System.out.println(d1.getDisciplinaID());
            */
             
             
              //INSERIR MATERIA
               /*Materia m1 = new Materia("Subtracao","sub dos numeros",4,2);
               MateriaDAO materiaDAO = new MateriaDAO();
               
               materiaDAO.inserir(m1);
              */
               
               /*Vegetais vegetal = new Vegetais("PERA");
                
                VegetalDAO vegetalDAO = new VegetalDAO();
                vegetalDAO.inserir(m1);
               */
                //String nome, String descricao, int serie
                
                
                //LISTAR MATERIA
               /* MateriaDAO materiaDAO = new MateriaDAO();
               for(Materia m:materiaDAO.listar()){
                
                   System.out.println(m.getDescricao());
                   System.out.println(m.getNome());
                   System.out.println(m.getSerie());  
                   System.out.println(m.getMateriaID());
                 */  
               }
    }
               
                
                
               
    

