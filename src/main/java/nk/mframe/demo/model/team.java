package nk.mframe.demo.model;

import javax.persistence.*;


@Table(name = "team")
@Entity
public class team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    @SequenceGenerator(name="team_seq", sequenceName="SEQ_TEAM")
    @Column(name = "idTeam", nullable = false)
    private int idTeam;

    private String nameTeam;

    private Integer leagueTeam;

    private String logotypeTeam;

    private Byte levelTeam;

    private Byte formTeam;

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

    public String getLogotypeTeam() {
        return logotypeTeam;
    }

    public void setLogotypeTeam(String logotypeTeam) {
        this.logotypeTeam = logotypeTeam;
    }

    public Byte getFormTeam() {
        return formTeam;
    }

    public void setFormTeam(Byte formTeam) {
        this.formTeam = formTeam;
    }

    public team(String nameTeam, Integer leagueTeam, Byte levelTeam, Byte formTeam) {
        this.nameTeam = nameTeam;
        this.leagueTeam = leagueTeam;
        this.levelTeam = levelTeam;
        this.formTeam = formTeam;
    }

    public team() {
    }

}
