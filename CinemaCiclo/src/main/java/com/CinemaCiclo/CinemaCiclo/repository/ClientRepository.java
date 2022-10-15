/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.repository;

import com.CinemaCiclo.CinemaCiclo.model.Client;
import com.CinemaCiclo.CinemaCiclo.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient (int id){
        return clientCrudRepository.findById(id);
    }
    public Client save (Client c){
        return clientCrudRepository.save(c);
    }
    
    public void delete (Client c){
        clientCrudRepository.delete(c);
    }
   
}
