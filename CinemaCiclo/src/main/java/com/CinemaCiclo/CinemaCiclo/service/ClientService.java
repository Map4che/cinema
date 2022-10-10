/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.service;

import com.CinemaCiclo.CinemaCiclo.model.Client;
import com.CinemaCiclo.CinemaCiclo.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client c) {
        if (c.getIdClient() == null) {
            return clientRepository.save(c);
        } else {
            Optional<Client> caux = clientRepository.getClient(c.getIdClient());
            if (caux.isEmpty()) {
                return clientRepository.save(c);
            } else {
                return (c);
            }

        }
    }
    
    public Client update (Client c){
        if(c.getIdClient()!=null){
            Optional<Client> l= clientRepository.getClient(c.getIdClient());
            if(!l.isEmpty()){
                if(c.getName()!=null){
                    l.get().setName(c.getName());
                }
                if(c.getEmail()!=null){
                    l.get().setAge(c.getAge());
                }
                if(c.getAge()!=null){
                    l.get().setAge(c.getAge());
                }
                if(c.getPassword()!=null){
                    l.get().setPassword(c.getPassword());
                }
                return clientRepository.save(l.get());
            }
        }return c;
    }
    
    public boolean deleteClient (int id){
        Optional<Client> c= getClient(id);
        if(!c.isEmpty()){
            clientRepository.delete(c.get());
            return true;
        }
            return false;
        }
        }
    

