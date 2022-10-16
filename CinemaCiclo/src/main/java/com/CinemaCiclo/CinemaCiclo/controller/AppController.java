/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    
 @GetMapping({"/","/login"})
   public String index(){
       return "index";
   }
   
   @GetMapping("/admin")
   public String admin(){
       return "admin";
   }
   
   @GetMapping("/clientes")
   public String clientes(){
       return "clientes";
   }
   
   @GetMapping("/registroclientes")
   public String registroclientes(){
       return "registroclientes";
   }
  
}