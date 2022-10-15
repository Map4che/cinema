/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.service;

import com.CinemaCiclo.CinemaCiclo.model.Reservation;
import com.CinemaCiclo.CinemaCiclo.model.custome.StatusAmount;
import com.CinemaCiclo.CinemaCiclo.model.custome.countCinema;
import com.CinemaCiclo.CinemaCiclo.model.custome.countClient;
import com.CinemaCiclo.CinemaCiclo.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> raux = reservationRepository.getReservation(r.getIdReservation());
            if (raux.isEmpty()) {
                return reservationRepository.save(r);
            } else {
                return (r);
            }
        }
    }

    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if (!e.isEmpty()) {
                if (r.getStartDate() != null) {
                    e.get().setStartDate(r.getStartDate());
                }
                if (!e.isEmpty()) {
                    if (r.getDevolutionDate() != null) {
                        e.get().setDevolutionDate(r.getDevolutionDate());
                    }
                    return reservationRepository.save(e.get());
                }
            }
        }
        return r;
    }

    public boolean deleteReservation(int id) {
        Optional<Reservation> r = getReservation(id);
        if (!r.isEmpty()) {
            reservationRepository.delete(r.get());
            return true;
        }
        return false;
    }

    public List<countCinema> getTopRoom() {
        return reservationRepository.getTopCinema();
    }

    public List<countClient> getTopClients() {
        return reservationRepository.getTopClients();
    }

    public List<Reservation> getReservationsPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)) {
            return reservationRepository.getReservationPeriod(a, b);
        } else {
            return new ArrayList<>();
        }
    }

    public StatusAmount getReservationsStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(), cancelled.size());

    }

}
