/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Message")

public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    
    private Integer idMessage;
    @Column(name = "messageText",length = 250,nullable = false)
    private String messageText;

    @ManyToOne 
    @JoinColumn(name="cinemas")
    @JsonIgnoreProperties({"messages","reservations"})
    private Cinema cinema;
    
    @ManyToOne
    @JoinColumn(name = "clients")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Message() {
    }

    public Message(Integer idMessage, String messageText, Cinema cinema, Client client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.cinema = cinema;
        this.client = client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    }

    

      
        
    