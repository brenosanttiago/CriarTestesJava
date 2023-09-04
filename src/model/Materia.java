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
public class Materia extends Disciplina {

    private String nome;
    private String descricao;
    private int serie;
    private int materiaID;

    public Materia(String nome, String descricao, int serie, int materiaID) {
        this.nome = nome;
        this.descricao = descricao;
        this.serie = serie;
        this.materiaID = materiaID;
    }

    public Materia(int materiaID) {
        this.materiaID = materiaID;
    }

    public Materia(String matematica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    public int getMateriaID() {
        return materiaID;
    }

    public void setMateriaID(int materiaID) {
        this.materiaID = materiaID;
    }
    
    public Materia() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }
  
}
