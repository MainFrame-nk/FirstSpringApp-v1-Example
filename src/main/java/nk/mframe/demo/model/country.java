package nk.mframe.demo.model;


import javax.persistence.*;

@Table(name = "country")
@Entity
public class country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq")
    @SequenceGenerator(name="country_seq", sequenceName="SEQ_COUNTRY")
    @Column(name = "idCountry", nullable = false)
    private Integer idCountry;

    private String nameCountry;
    private String flagCountry;

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getFlagCountry() {
        return flagCountry;
    }

    public void setFlagCountry(String flagCountry) {
        this.flagCountry = flagCountry;
    }

    public country() {
    }

    public country(String nameCountry) {
        this.nameCountry = nameCountry;
    }
}
