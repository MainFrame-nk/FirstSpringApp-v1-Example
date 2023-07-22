package nk.mframe.demo.model;

import javax.persistence.*;

@Table(name = "league")
@Entity
public class league {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "league_seq")
    @SequenceGenerator(name="league_seq", sequenceName="SEQ_LEAGUE")
    @Column(name = "idLeague", nullable = false)
    private Integer idLeague;

    private String nameLeague;
    private String countryLeague;
    private String logotypeLeague;

    public Integer getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(Integer idLeague) {
        this.idLeague = idLeague;
    }

    public String getNameLeague() {
        return nameLeague;
    }

    public void setNameLeague(String nameLeague) {
        this.nameLeague = nameLeague;
    }

    public String getCountryLeague() {
        return countryLeague;
    }

    public void setCountryLeague(String countryLeague) {
        this.countryLeague = countryLeague;
    }

    public league() {
    }

    public league(String nameLeague, String countryLeague) {
        this.nameLeague = nameLeague;
        this.countryLeague = countryLeague;
    }
}
