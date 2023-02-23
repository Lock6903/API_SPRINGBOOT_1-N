/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palomar.API.ProductController;

import com.palomar.API.Service.CategoriaService;
import com.palomar.API.model.Categoria;
import com.palomar.API.model.Product;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ericpaldor
 */
@RestController
@RequiredArgsConstructor
public class CategoriaController { 
    private final CategoriaService categoriaService;   
    
    @GetMapping("/categoria") 
    public List<Categoria> listCategoria(){
        return categoriaService.listCategorias();
    } 
    @GetMapping("/categoria/{id}") 
    public ResponseEntity<Categoria> getCategoria(@PathVariable Integer id){
        try{ 
            Categoria categoria = categoriaService.getCategoriaById(id);
            return ResponseEntity.ok(categoria); 
        } catch(Exception e){ 
            return ResponseEntity.notFound().build(); 
        } 
    } 
    
    @PostMapping("/categoria") 
    public void newCategoria(@RequestBody Categoria categoria){ 
        categoriaService.saveCategoria(categoria); 
    } 
    @PutMapping("/categoria/{id}") 
    public ResponseEntity<?> editCategoria(@RequestBody Categoria categoria, @PathVariable Integer id){
        try{ 
            Categoria categoriaExist = categoriaService.getCategoriaById(id);
            categoriaExist.setId(categoria.getId()); 
            categoriaExist.setName(categoria.getName());
            categoriaService.saveCategoria(categoriaExist); 
            return new ResponseEntity<Categoria>(categoria, HttpStatus.OK); 
        }catch(Exception e){ 
            return new ResponseEntity<Categoria>(HttpStatus.NOT_FOUND); 
        } 
    }
    @DeleteMapping("/categoria/{id}")
    public void deleteCategoria(@PathVariable Integer id){
        categoriaService.deleteCategoria(id);
    }
}
