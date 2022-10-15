/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.model.custome;

import com.CinemaCiclo.CinemaCiclo.model.Cinema;

public class countCinema {
    
    private Long total;
    private Cinema cinema;
    
    public countCinema(Long total, Cinema cinema) {
        this.total = total;
        this.cinema = cinema;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    
    
    
}
