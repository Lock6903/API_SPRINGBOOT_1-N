/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author ericpaldor
 */
@Entity
@Data   @NoArgsConstructor  @AllArgsConstructor
public class Categoria {
    @Id @GeneratedValue
    private Integer id; //Usamos la clase Integer en lugar del tipo primitivo int 
                        //ya que asi ide puede valer null
    private String name;
    
    @OneToMany(mappedBy= "categoria")
    private List<Product> product;
}