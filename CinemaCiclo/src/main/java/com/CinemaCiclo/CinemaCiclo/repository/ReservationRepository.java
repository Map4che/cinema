/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.repository;

import com.CinemaCiclo.CinemaCiclo.model.Cinema;
import com.CinemaCiclo.CinemaCiclo.model.Client;
import com.CinemaCiclo.CinemaCiclo.model.Reservation;
import com.CinemaCiclo.CinemaCiclo.model.custome.countCinema;
import com.CinemaCiclo.CinemaCiclo.model.custome.countClient;
import com.CinemaCiclo.CinemaCiclo.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation (int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }
    public void delete (Reservation r){
        reservationCrudRepository.delete(r);
    }
    public List<countCinema> getTopCinema(){
        List<countCinema> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByRoom();
        for (int i = 0; i < report.size(); i++) {
            res.add(new countCinema((Long)report.get(i)[1],(Cinema)report.get(i)[0]));
        }
        return res;
    }    
    
    public List<countClient> getTopClients(){
        List<countClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new countClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return res;
    }
    
    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }   

}
