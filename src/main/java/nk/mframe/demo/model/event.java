package nk.mframe.demo.model;

import javax.persistence.*;

@Table(name = "event")
@Entity
public class event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name="event_seq", sequenceName="SEQ_EVENT")
    @Column(name = "idEvent", nullable = false)
    private Long idEvent;

    private Integer idMatch;

    private Byte gamePeriod;
    private Integer bettingLine;
    private Integer occasion;

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public Integer getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Integer idMatch) {
        this.idMatch = idMatch;
    }

    public Byte getGamePeriod() {
        return gamePeriod;
    }

    public void setGamePeriod(Byte gamePeriod) {
        this.gamePeriod = gamePeriod;
    }

    public Integer getBettingLine() {
        return bettingLine;
    }

    public void setBettingLine(Integer bettingLine) {
        this.bettingLine = bettingLine;
    }

    public Integer getOccasion() {
        return occasion;
    }

    public void setOccasion(Integer occasion) {
        this.occasion = occasion;
    }

    public event() {
    }

    public event(Integer idMatch, Byte gamePeriod, Integer bettingLine, Integer occasion) {
        this.idMatch = idMatch;
        this.gamePeriod = gamePeriod;
        this.bettingLine = bettingLine;
        this.occasion = occasion;
    }
}
