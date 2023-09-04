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
public class Disciplina {

    private String nome;
    private int disciplinaID;

    
    
    public int getDisciplinaID() {
        return disciplinaID;
    }

    public void setDisciplinaID(int disciplinaID) {
        this.disciplinaID = disciplinaID;
    }

    public Disciplina(String nome, int disciplinaID) {
        this.nome = nome;
        this.disciplinaID = disciplinaID;
    }

    public Disciplina(int disciplinaID) {
        this.disciplinaID = disciplinaID;
    }
    
    public Disciplina() {
    }

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
