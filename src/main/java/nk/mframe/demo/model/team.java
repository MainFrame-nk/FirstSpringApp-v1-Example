package nk.mframe.demo.model;

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

    private Integer leagueTeam;

    private String logotypeTeam;

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

    public Integer getLeagueTeam() {
        return leagueTeam;
    }

    public void setLeagueTeam(Integer league) {
        this.leagueTeam = league;
    }

    public team(String nameTeam, Integer leagueTeam, Byte levelTeam) {
        this.nameTeam = nameTeam;
        this.leagueTeam = leagueTeam;
        this.levelTeam = levelTeam;
    }

    public team() {
    }

}