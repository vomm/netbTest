/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootJpaH2.controller;

import com.example.SpringBootJpaH2.dao.AlienRepo;
import com.example.SpringBootJpaH2.model.Alien;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AlienController {
    
    @Autowired
    AlienRepo repo;
    
    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }
    
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home.jsp";
    }
    
    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid ){
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        
        System.out.println(repo.findByTech("Java"));
        System.out.println(repo.findByAidGreaterThan(102));
        System.out.println(repo.findByTechSorted("Java"));
        mv.addObject(alien);
        return mv;
    }   
    
    @GetMapping(path = "/aliens", produces = {"application/xml"})
    public List<Alien> getAliens(){
        return repo.findAll();
    }
    
    @RequestMapping("/oneAlien/{aid}")
    public Optional<Alien> getOneAlien(@PathVariable int aid){
        return repo.findById(aid);
    }

    @PostMapping("/addOneAlien")
    public Alien addOneAlien(Alien alien){
        repo.save(alien);
        return alien;
    }
    //accepts raw json and consumes only json
        @PostMapping(path = "/addOneAlien" , consumes = {"application/json"})
    public Alien addOneRawAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }
    
    @DeleteMapping("/alien/{aid}")
    public String  deleteAlien(@PathVariable int aid){
        Alien a = repo.getOne(aid);
        repo.delete(a);
        return "deleted";
    }
    
    @PutMapping(path = "/addOneAlien" , consumes = {"application/json"})
    public Alien saveOrUpdateAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }    

}
