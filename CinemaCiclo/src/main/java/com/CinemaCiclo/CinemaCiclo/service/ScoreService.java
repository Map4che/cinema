/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.CinemaCiclo.CinemaCiclo.service;

import com.CinemaCiclo.CinemaCiclo.model.Score;
import com.CinemaCiclo.CinemaCiclo.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return (List<Score>)scoreRepository.getAll();
    }
    public Optional<Score> getScore (int id){
        return scoreRepository.getScore(id);
    }
    public Score save (Score s){
        if (s.getIdScore()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> saux=scoreRepository.getScore(s.getIdScore());
            if (saux.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return (s);
            }
        }
    }
    
    public Score update (Score s){
        if(s.getIdScore()!=null){
            Optional<Score> c= scoreRepository.getScore(s.getIdScore());
            if(!c.isEmpty()){
                if(s.getScore()!=null){
                    c.get().setScore(s.getScore());
                }
                return scoreRepository.save(c.get());
            }
        }return s;
    }
    
    public boolean deleteScore (int id){
        Optional<Score> s= getScore(id);
        if(!s.isEmpty()){
            scoreRepository.delete(s.get());
            return true;
        }
            return false;
        }
    }

