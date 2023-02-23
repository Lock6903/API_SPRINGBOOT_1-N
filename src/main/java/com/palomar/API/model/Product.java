/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ericpaldor
 */
@Entity
@Data   @NoArgsConstructor  @AllArgsConstructor
public class Product {
    @Id @GeneratedValue
    private Integer id; //Usamos la clase Integer en lugar del tipo primitivo int 
                        //ya que asi ide puede valer null
    private String name;
    private float price;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @JsonProperty (access= JsonProperty.Access.WRITE_ONLY)
    
    private Categoria categoria;
}
