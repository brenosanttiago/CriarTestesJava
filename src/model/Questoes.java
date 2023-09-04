/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Questoes{
   
   private int questaoID;
   private String enunciado;
   private String gabarito;
   private int bimestre;
   private Materia materia;

    public Questoes() {
    }

    public Questoes(String enunciado, String gabarito, int bimestre, Materia materia) {
       
        this.enunciado = enunciado;
        this.gabarito = gabarito;
        this.bimestre = bimestre;
        this.materia = materia;
    }

    public Questoes(int questaoID, String enunciado, String gabarito, int bimestre) {
        this.questaoID = questaoID;
        this.enunciado = enunciado;
        this.gabarito = gabarito;
        this.bimestre = bimestre;
    }
    
    public int getQuestaoID() {
        return questaoID;
    }

    public void setQuestaoID(int questaoID) {
        this.questaoID = questaoID;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getBimestre() {
        return bimestre;
    }

    public void setBimestre(int bimestre) {
        this.bimestre = bimestre;
    }

    public String getGabarito() {
        return gabarito;
    }

    public void setGabarito(String gabarito) {
        this.gabarito = gabarito;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
     
}
