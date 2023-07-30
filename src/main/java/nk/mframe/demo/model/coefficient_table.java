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

    private Integer idEvent;
    private Integer bookmakerId;
    private Integer outcomeId;
    private Integer outcomeValue;
    private Double coefficient;

    public Long getIdCoefficient() {
        return idCoefficient;
    }

    public void setIdCoefficient(Long idCoefficient) {
        this.idCoefficient = idCoefficient;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Integer getBookmakerId() {
        return bookmakerId;
    }

    public void setBookmakerId(Integer bookmakerId) {
        this.bookmakerId = bookmakerId;
    }

    public Integer getOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(Integer outcomeId) {
        this.outcomeId = outcomeId;
    }

    public Integer getOutcomeValue() {
        return outcomeValue;
    }

    public void setOutcomeValue(Integer outcomeValue) {
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

    public coefficient_table(Integer idEvent, Integer bookmakerId, Integer outcomeId, Integer outcomeValue, Double coefficient) {
        this.idEvent = idEvent;
        this.bookmakerId = bookmakerId;
        this.outcomeId = outcomeId;
        this.outcomeValue = outcomeValue;
        this.coefficient = coefficient;
    }
}
