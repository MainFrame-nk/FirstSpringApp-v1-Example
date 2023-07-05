package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTeam;

    private String nameTeam;

    private Long league;

    private String logo;

    private Byte levelTeam;

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int id) {
        this.idTeam = id;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String name) {
        this.nameTeam = name;
    }

    public Byte getLevelTeam() {
        return levelTeam;
    }

    public void setLevelTeam(Byte levelTeam) {
        this.levelTeam = levelTeam;
    }


    public team(String name, Byte levelTeam) {
        this.nameTeam = name;
        this.levelTeam = levelTeam;
    }

    public team() {
    }

}
