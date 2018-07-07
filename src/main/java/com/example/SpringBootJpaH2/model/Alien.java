/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootJpaH2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
    
    @Id
    private int aid;
    private String aname;
    private String tech;

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Alien{" + "aid=" + aid + ", aname=" + aname + ", tech=" + tech + '}';
    }


    
    
}
