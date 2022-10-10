/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.service;

import com.CinemaCiclo.CinemaCiclo.model.Message;
import com.CinemaCiclo.CinemaCiclo.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage (int id){
        return messageRepository.getMessage(id);
    }
    public Message save (Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
            if (maux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return (m);
            }
        }
    }
    
    public Message update (Message m){
        if(m.getIdMessage()!=null){
            Optional<Message> e= messageRepository.getMessage(m.getIdMessage());
            if(!e.isEmpty()){
                if(m.getMessageText()!=null){
                    e.get().setMessageText(m.getMessageText());
            }
                return messageRepository.save(e.get());
        }
    }return m;
}
    
    public boolean deleteMessage(int id){
        Optional<Message> m= getMessage(id);
        if(!m.isEmpty()){
            messageRepository.delete(m.get());
            return true;
        }
            return false;
        }
        }
    

