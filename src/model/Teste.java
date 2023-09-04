/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author aluno
 */
public class Teste {
    
    private Date dataGeracao;
    private int TesteID; 
    
    public int getTesteID() {
        return TesteID;
    }

    public void setTesteID(int TesteID) {
        this.TesteID = TesteID;
    }
    private ArrayList<Questoes> listaQuestoes;

    public Teste(int TesteID) {
        this.TesteID = TesteID;
    }
    
    public Teste() {
    }

    public Teste(Date dataGeracao, ArrayList<Questoes> listaQuestoes) {
        this.dataGeracao = dataGeracao;
        this.listaQuestoes = listaQuestoes;
    }
    
    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public ArrayList<Questoes> getListaQuestoes() {
        return listaQuestoes;
    }

    public void setListaQuestoes(ArrayList<Questoes> listaQuestoes) {
        this.listaQuestoes = listaQuestoes;
    }
    
}
