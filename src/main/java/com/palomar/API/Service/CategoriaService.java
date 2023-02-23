/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.Service;

import com.palomar.API.model.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.palomar.API.repository.CategoriaRepository;

/**
 *
 * @author ericpaldor
 */
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository CRepository;
    
    public List <Categoria> listCategorias(){
        return CRepository.findAll();
    }
    public void saveCategoria (Categoria product){
        CRepository.save(product);
    }
    public Categoria getCategoriaById(Integer id){
        return CRepository.findById(id).get();
    }
    public void deleteCategoria (Integer id){
        CRepository.deleteById(id);
    }
}