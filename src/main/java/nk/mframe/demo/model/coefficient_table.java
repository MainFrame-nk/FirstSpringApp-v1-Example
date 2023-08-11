package nk.mframe.demo.model;

import javax.persistence.*;

@Table(name = "coefficient_table")
@Entity
public class coefficient_table {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coefficient_table_seq")
    @SequenceGenerator(name="coefficient_table_seq", sequenceName="SEQ_COEFFICIENT_TABLE")
    @Column(name = "idCoefficient", nullable = false)
    private Long idCoefficient;

    private Long idEvent;
    private Integer bookmakerId;
    private Double outcomeValue;
    private Double coefficient;

    public Long getIdCoefficient() {
        return idCoefficient;
    }

    public void setIdCoefficient(Long idCoefficient) {
        this.idCoefficient = idCoefficient;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public Integer getBookmakerId() {
        return bookmakerId;
    }

    public void setBookmakerId(Integer bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    public Double getOutcomeValue() {
        return outcomeValue;
    }

    public void setOutcomeValue(Double outcomeValue) {
        this.outcomeValue = outcomeValue;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public coefficient_table() {
    }

    public coefficient_table(Long idEvent, Integer bookmakerId, Double outcomeValue, Double coefficient) {
        this.idEvent = idEvent;
        this.bookmakerId = bookmakerId;
        this.outcomeValue = outcomeValue;
        this.coefficient = coefficient;
    }
}
