/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.service;

import com.CinemaCiclo.CinemaCiclo.model.Category;
import com.CinemaCiclo.CinemaCiclo.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory (int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category c){
        if (c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> caux= categoryRepository.getCategory(c.getId());
            if (caux.isEmpty()){
                return categoryRepository.save(c);
        }else{
                return (c);
            }
        }
    }
    
    public Category update (Category c){
        if (c.getId()!=null){
            Optional<Category> a=categoryRepository.getCategory(c.getId());
            if (!a.isEmpty()){
                if(c.getName()!=null){
                    a.get().setName(c.getName());
                }if (c.getDescription()!=null){
                    a.get().setDescription(c.getDescription());
                }
                return categoryRepository.save(a.get());
            }
        }
        return c;
    }
    
    public boolean deleteCategory (int id){
        Optional<Category> c= getCategory(id);
        if(!c.isEmpty()){
            categoryRepository.delete(c.get());
            return true;
        }
            return false;
        }
    }

