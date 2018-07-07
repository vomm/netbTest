/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootJpaH2.dao;

import com.example.SpringBootJpaH2.model.Alien;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vomm
 */
public interface AlienRepo extends JpaRepository<Alien, Integer>{
    List<Alien> findByTech(String tech);
    
    List<Alien> findByAidGreaterThan(int aid);
    
    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSorted(String tech);
}
