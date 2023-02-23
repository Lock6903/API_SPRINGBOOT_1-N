
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.Service;

import com.palomar.API.model.Product;
import com.palomar.API.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ericpaldor
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository PRepository;
    
    public List <Product> listProducts(){
        return PRepository.findAll();
    }
    public void saveProduct (Product product){
        PRepository.save(product);
    }
    public Product getProductById(Integer id){
        return PRepository.findById(id).get();
    }
    public void deleteProduct (Integer id){
        PRepository.deleteById(id);
    }
    public List<Product> listProductCategorias(Integer id){
        return PRepository.findByCategoriaId(id);
        
        
    }
}
