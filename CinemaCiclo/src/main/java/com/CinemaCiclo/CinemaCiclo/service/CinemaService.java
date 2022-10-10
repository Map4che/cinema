/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.service;

import com.CinemaCiclo.CinemaCiclo.model.Cinema;
import com.CinemaCiclo.CinemaCiclo.repository.CinemaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {
    
    @Autowired
    private CinemaRepository cinemaRepository;
    
    public List<Cinema> getAll() {
        return cinemaRepository.getAll();
}
    
    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }
    
    public Cinema save(Cinema c){
        if (c.getId() ==null){
            return cinemaRepository.save(c);
        }else{
            Optional<Cinema> caux=cinemaRepository.getCinema(c.getId());
            if(caux.isEmpty()){
                return cinemaRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    public Cinema update (Cinema c){
        if (c.getId()!=null){
            Optional<Cinema> i=cinemaRepository.getCinema(c.getId());
            if (!i.isEmpty()){
                if(c.getName()!=null){
                    i.get().setName(c.getName());
                }
                if(c.getOwner()!=null){
                    i.get().setOwner(c.getOwner());
                }
                if(c.getCapacity()!=null){
                    i.get().setCapacity(c.getCapacity());
                }
                if (c.getDescription()!=null){
                    i.get().setDescription(c.getDescription());
                }
                return cinemaRepository.save(i.get());
            }
        } return c;
    }
    
    public boolean deleteCinema (int id){
        Optional<Cinema> c= getCinema(id);
        if(!c.isEmpty()){
            cinemaRepository.delete(c.get());
            return true;
        }else
            return false;
        }
        }
    
