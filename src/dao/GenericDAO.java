/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author smart
 */
public interface GenericDAO<ObjetoGenerico> {
    
    ObjetoGenerico inserir(ObjetoGenerico obj);
    ArrayList<ObjetoGenerico> listar();
    Object buscarID(ObjetoGenerico obj);
    void atualizar(ObjetoGenerico obj);
    void excluir(ObjetoGenerico obj);
    
    
}
