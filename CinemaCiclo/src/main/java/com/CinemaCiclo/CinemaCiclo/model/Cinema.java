/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cinema")

public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "owner", length = 45, nullable = false)
    private String owner;
    private Integer capacity;
    @Column(name = "description", length = 250, nullable = false)
    private String description;

    //Interacciones:
    
    /*
    @OneToOne
    @JoinColumn(name = "category")
    private Category category;
    */
    
    @ManyToOne
    @JoinColumn(name = "nameCategory")
    @JsonIgnoreProperties("cinemas")
    private Category category;
    
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "idMessage")
    @JsonIgnoreProperties({"cinema","client"})
    private List<Message> messages;
    
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "idReservation")
    @JsonIgnoreProperties("cinema")
    private List<Reservation> reservations;

    
    
      

    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    

    public Cinema() {
    }

    public Cinema(Integer id, String name, String owner, Integer capacity, String description, Integer category) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.capacity = capacity;
        this.description = description;

    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservation(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
