package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class match_table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMatch;

    private Integer teamHome;

    private Integer teamGuest;

    private Integer scoreHome, scoreGuest;

    //private Date dateMatch;
    //private Time timeMatch;
    private Integer shotFirstHalfHome, shotSecondHalfHome, shotExtraTimeHome;

    private Integer shotFirstHalfGuest, shotSecondHalfGuest, shotExtraTimeGuest;

    private Integer shotOnTargetFirstHalfHome, shotOnTargetSecondHalfHome, shotOnTargetExtraTimeHome;

    private Integer shotOnTargetFirstHalfGuest, shotOnTargetSecondHalfGuest, shotOnTargetExtraTimeGuest;

    private Integer possessionFirstHalfHome, possessionSecondHalfHome, possessionExtraTimeHome;

    private Integer possessionFirstHalfGuest, possessionSecondHalfGuest, possessionExtraTimeGuest;

    private Integer cornerFirstHalfHome, cornerSecondHalfHome, cornerExtraTimeHome;

    private Integer cornerFirstHalfGuest, cornerSecondHalfGuest, cornerExtraTimeGuest;

    private Integer yellowCardFirstHalfHome, yellowCardSecondHalfHome, yellowCardExtraTimeHome;

    private Integer yellowCardFirstHalfGuest, yellowCardSecondHalfGuest, yellowCardExtraTimeGuest;
    private Integer redCardFirstHalfHome, redCardSecondHalfHome, redCardExtraTimeHome;
    private Integer redCardFirstHalfGuest, redCardSecondHalfGuest, redCardExtraTimeGuest;
    private Integer freeKickFirstHalfHome, freeKickSecondHalfHome, freeKickExtraTimeHome;
    private Integer freeKickFirstHalfGuest, freeKickSecondHalfGuest, freeKickExtraTimeGuest;
    private Integer offsideFirstHalfHome, offsideSecondHalfHome, offsideExtraTimeHome;
    private Integer offsideFirstHalfGuest, offsideSecondHalfGuest, offsideExtraTimeGuest;
    private Integer foulFirstHalfHome, foulSecondHalfHome, foulExtraTimeHome;
    private Integer foulFirstHalfGuest, foulSecondHalfGuest, foulExtraTimeGuest;

    public Long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Long id) {
        this.idMatch = id;
    }

    public int getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(int teamHome) {
        this.teamHome = teamHome;
    }

    public int getTeamGuest() {
        return teamGuest;
    }

    public void setTeamGuest(int teamGuest) {
        this.teamGuest = teamGuest;
    }

    public Integer getShotFirstHalfHome() {
        return shotFirstHalfHome;
    }

    public void setShotFirstHalfHome(Integer shotFirstHalfHome) {
        this.shotFirstHalfHome = shotFirstHalfHome;
    }

    public Integer getShotSecondHalfHome() {
        return shotSecondHalfHome;
    }

    public void setShotSecondHalfHome(Integer shotSecondHalfHome) {
        this.shotSecondHalfHome = shotSecondHalfHome;
    }

    public Integer getShotExtraTimeHome() {
        return shotExtraTimeHome;
    }

    public void setShotExtraTimeHome(Integer shotExtraTimeHome) {
        this.shotExtraTimeHome = shotExtraTimeHome;
    }

    public Integer getShotFirstHalfGuest() {
        return shotFirstHalfGuest;
    }

    public void setShotFirstHalfGuest(Integer shotFirstHalfGuest) {
        this.shotFirstHalfGuest = shotFirstHalfGuest;
    }

    public Integer getShotSecondHalfGuest() {
        return shotSecondHalfGuest;
    }

    public void setShotSecondHalfGuest(Integer shotSecondHalfGuest) {
        this.shotSecondHalfGuest = shotSecondHalfGuest;
    }

    public Integer getShotExtraTimeGuest() {
        return shotExtraTimeGuest;
    }

    public void setShotExtraTimeGuest(Integer shotExtraTimeGuest) {
        this.shotExtraTimeGuest = shotExtraTimeGuest;
    }

    public Integer getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(Integer scoreHome) {
        this.scoreHome = scoreHome;
    }

    public Integer getScoreGuest() {
        return scoreGuest;
    }

    public void setScoreGuest(Integer scoreGuest) {
        this.scoreGuest = scoreGuest;
    }

    public Integer getPossessionFirstHalfHome() {
        return possessionFirstHalfHome;
    }

    public void setPossessionFirstHalfHome(Integer possessionFirstHalfHome) {
        this.possessionFirstHalfHome = possessionFirstHalfHome;
    }

    public Integer getPossessionSecondHalfHome() {
        return possessionSecondHalfHome;
    }

    public void setPossessionSecondHalfHome(Integer possessionSecondHalfHome) {
        this.possessionSecondHalfHome = possessionSecondHalfHome;
    }

    public Integer getPossessionExtraTimeHome() {
        return possessionExtraTimeHome;
    }

    public void setPossessionExtraTimeHome(Integer possessionExtraTimeHome) {
        this.possessionExtraTimeHome = possessionExtraTimeHome;
    }

    public Integer getPossessionFirstHalfGuest() {
        return possessionFirstHalfGuest;
    }

    public void setPossessionFirstHalfGuest(Integer possessionFirstHalfGuest) {
        this.possessionFirstHalfGuest = possessionFirstHalfGuest;
    }

    public Integer getPossessionSecondHalfGuest() {
        return possessionSecondHalfGuest;
    }

    public void setPossessionSecondHalfGuest(Integer possessionSecondHalfGuest) {
        this.possessionSecondHalfGuest = possessionSecondHalfGuest;
    }

    public Integer getPossessionExtraTimeGuest() {
        return possessionExtraTimeGuest;
    }

    public void setPossessionExtraTimeGuest(Integer possessionExtraTimeGuest) {
        this.possessionExtraTimeGuest = possessionExtraTimeGuest;
    }

    public Integer getShotOnTargetFirstHalfHome() {
        return shotOnTargetFirstHalfHome;
    }

    public void setShotOnTargetFirstHalfHome(Integer shotOnTargetFirstHalfHome) {
        this.shotOnTargetFirstHalfHome = shotOnTargetFirstHalfHome;
    }

    public Integer getShotOnTargetSecondHalfHome() {
        return shotOnTargetSecondHalfHome;
    }

    public void setShotOnTargetSecondHalfHome(Integer shotOnTargetSecondHalfHome) {
        this.shotOnTargetSecondHalfHome = shotOnTargetSecondHalfHome;
    }

    public Integer getShotOnTargetExtraTimeHome() {
        return shotOnTargetExtraTimeHome;
    }

    public void setShotOnTargetExtraTimeHome(Integer shotOnTargetExtraTimeHome) {
        this.shotOnTargetExtraTimeHome = shotOnTargetExtraTimeHome;
    }

    public Integer getShotOnTargetFirstHalfGuest() {
        return shotOnTargetFirstHalfGuest;
    }

    public void setShotOnTargetFirstHalfGuest(Integer shotOnTargetFirstHalfGuest) {
        this.shotOnTargetFirstHalfGuest = shotOnTargetFirstHalfGuest;
    }

    public Integer getShotOnTargetSecondHalfGuest() {
        return shotOnTargetSecondHalfGuest;
    }

    public void setShotOnTargetSecondHalfGuest(Integer shotOnTargetSecondHalfGuest) {
        this.shotOnTargetSecondHalfGuest = shotOnTargetSecondHalfGuest;
    }

    public Integer getShotOnTargetExtraTimeGuest() {
        return shotOnTargetExtraTimeGuest;
    }

    public void setShotOnTargetExtraTimeGuest(Integer shotOnTargetExtraTimeGuest) {
        this.shotOnTargetExtraTimeGuest = shotOnTargetExtraTimeGuest;
    }

    public Integer getCornerFirstHalfHome() {
        return cornerFirstHalfHome;
    }

    public void setCornerFirstHalfHome(Integer cornerFirstHalfHome) {
        this.cornerFirstHalfHome = cornerFirstHalfHome;
    }

    public Integer getCornerSecondHalfHome() {
        return cornerSecondHalfHome;
    }

    public void setCornerSecondHalfHome(Integer cornerSecondHalfHome) {
        this.cornerSecondHalfHome = cornerSecondHalfHome;
    }

    public Integer getCornerExtraTimeHome() {
        return cornerExtraTimeHome;
    }

    public void setCornerExtraTimeHome(Integer cornerExtraTimeHome) {
        this.cornerExtraTimeHome = cornerExtraTimeHome;
    }

    public Integer getCornerFirstHalfGuest() {
        return cornerFirstHalfGuest;
    }

    public void setCornerFirstHalfGuest(Integer cornerFirstHalfGuest) {
        this.cornerFirstHalfGuest = cornerFirstHalfGuest;
    }

    public Integer getCornerSecondHalfGuest() {
        return cornerSecondHalfGuest;
    }

    public void setCornerSecondHalfGuest(Integer cornerSecondHalfGuest) {
        this.cornerSecondHalfGuest = cornerSecondHalfGuest;
    }

    public Integer getCornerExtraTimeGuest() {
        return cornerExtraTimeGuest;
    }

    public void setCornerExtraTimeGuest(Integer cornerExtraTimeGuest) {
        this.cornerExtraTimeGuest = cornerExtraTimeGuest;
    }

    public Integer getYellowCardFirstHalfHome() {
        return yellowCardFirstHalfHome;
    }

    public void setYellowCardFirstHalfHome(Integer yellowCardFirstHalfHome) {
        this.yellowCardFirstHalfHome = yellowCardFirstHalfHome;
    }

    public Integer getYellowCardSecondHalfHome() {
        return yellowCardSecondHalfHome;
    }

    public void setYellowCardSecondHalfHome(Integer yellowCardSecondHalfHome) {
        this.yellowCardSecondHalfHome = yellowCardSecondHalfHome;
    }

    public Integer getYellowCardExtraTimeHome() {
        return yellowCardExtraTimeHome;
    }

    public void setYellowCardExtraTimeHome(Integer yellowCardExtraTimeHome) {
        this.yellowCardExtraTimeHome = yellowCardExtraTimeHome;
    }

    public Integer getYellowCardFirstHalfGuest() {
        return yellowCardFirstHalfGuest;
    }

    public void setYellowCardFirstHalfGuest(Integer yellowCardFirstHalfGuest) {
        this.yellowCardFirstHalfGuest = yellowCardFirstHalfGuest;
    }

    public Integer getYellowCardSecondHalfGuest() {
        return yellowCardSecondHalfGuest;
    }

    public void setYellowCardSecondHalfGuest(Integer yellowCardSecondHalfGuest) {
        this.yellowCardSecondHalfGuest = yellowCardSecondHalfGuest;
    }

    public Integer getYellowCardExtraTimeGuest() {
        return yellowCardExtraTimeGuest;
    }

    public void setYellowCardExtraTimeGuest(Integer yellowCardExtraTimeGuest) {
        this.yellowCardExtraTimeGuest = yellowCardExtraTimeGuest;
    }

    public Integer getRedCardFirstHalfHome() {
        return redCardFirstHalfHome;
    }

    public void setRedCardFirstHalfHome(Integer redCardFirstHalfHome) {
        this.redCardFirstHalfHome = redCardFirstHalfHome;
    }

    public Integer getRedCardSecondHalfHome() {
        return redCardSecondHalfHome;
    }

    public void setRedCardSecondHalfHome(Integer redCardSecondHalfHome) {
        this.redCardSecondHalfHome = redCardSecondHalfHome;
    }

    public Integer getRedCardExtraTimeHome() {
        return redCardExtraTimeHome;
    }

    public void setRedCardExtraTimeHome(Integer redCardExtraTimeHome) {
        this.redCardExtraTimeHome = redCardExtraTimeHome;
    }

    public Integer getRedCardFirstHalfGuest() {
        return redCardFirstHalfGuest;
    }

    public void setRedCardFirstHalfGuest(Integer redCardFirstHalfGuest) {
        this.redCardFirstHalfGuest = redCardFirstHalfGuest;
    }

    public Integer getRedCardSecondHalfGuest() {
        return redCardSecondHalfGuest;
    }

    public void setRedCardSecondHalfGuest(Integer redCardSecondHalfGuest) {
        this.redCardSecondHalfGuest = redCardSecondHalfGuest;
    }

    public Integer getRedCardExtraTimeGuest() {
        return redCardExtraTimeGuest;
    }

    public void setRedCardExtraTimeGuest(Integer redCardExtraTimeGuest) {
        this.redCardExtraTimeGuest = redCardExtraTimeGuest;
    }

    public Integer getFreeKickFirstHalfHome() {
        return freeKickFirstHalfHome;
    }

    public void setFreeKickFirstHalfHome(Integer freeKickFirstHalfHome) {
        this.freeKickFirstHalfHome = freeKickFirstHalfHome;
    }

    public Integer getFreeKickSecondHalfHome() {
        return freeKickSecondHalfHome;
    }

    public void setFreeKickSecondHalfHome(Integer freeKickSecondHalfHome) {
        this.freeKickSecondHalfHome = freeKickSecondHalfHome;
    }

    public Integer getFreeKickExtraTimeHome() {
        return freeKickExtraTimeHome;
    }

    public void setFreeKickExtraTimeHome(Integer freeKickExtraTimeHome) {
        this.freeKickExtraTimeHome = freeKickExtraTimeHome;
    }

    public Integer getFreeKickFirstHalfGuest() {
        return freeKickFirstHalfGuest;
    }

    public void setFreeKickFirstHalfGuest(Integer freeKickFirstHalfGuest) {
        this.freeKickFirstHalfGuest = freeKickFirstHalfGuest;
    }

    public Integer getFreeKickSecondHalfGuest() {
        return freeKickSecondHalfGuest;
    }

    public void setFreeKickSecondHalfGuest(Integer freeKickSecondHalfGuest) {
        this.freeKickSecondHalfGuest = freeKickSecondHalfGuest;
    }

    public Integer getFreeKickExtraTimeGuest() {
        return freeKickExtraTimeGuest;
    }

    public void setFreeKickExtraTimeGuest(Integer freeKickExtraTimeGuest) {
        this.freeKickExtraTimeGuest = freeKickExtraTimeGuest;
    }

    public Integer getOffsideFirstHalfHome() {
        return offsideFirstHalfHome;
    }

    public void setOffsideFirstHalfHome(Integer offsideFirstHalfHome) {
        this.offsideFirstHalfHome = offsideFirstHalfHome;
    }

    public Integer getOffsideSecondHalfHome() {
        return offsideSecondHalfHome;
    }

    public void setOffsideSecondHalfHome(Integer offsideSecondHalfHome) {
        this.offsideSecondHalfHome = offsideSecondHalfHome;
    }

    public Integer getOffsideExtraTimeHome() {
        return offsideExtraTimeHome;
    }

    public void setOffsideExtraTimeHome(Integer offsideExtraTimeHome) {
        this.offsideExtraTimeHome = offsideExtraTimeHome;
    }

    public Integer getOffsideFirstHalfGuest() {
        return offsideFirstHalfGuest;
    }

    public void setOffsideFirstHalfGuest(Integer offsideFirstHalfGuest) {
        this.offsideFirstHalfGuest = offsideFirstHalfGuest;
    }

    public Integer getOffsideSecondHalfGuest() {
        return offsideSecondHalfGuest;
    }

    public void setOffsideSecondHalfGuest(Integer offsideSecondHalfGuest) {
        this.offsideSecondHalfGuest = offsideSecondHalfGuest;
    }

    public Integer getOffsideExtraTimeGuest() {
        return offsideExtraTimeGuest;
    }

    public void setOffsideExtraTimeGuest(Integer offsideExtraTimeGuest) {
        this.offsideExtraTimeGuest = offsideExtraTimeGuest;
    }

    public Integer getFoulFirstHalfHome() {
        return foulFirstHalfHome;
    }

    public void setFoulFirstHalfHome(Integer foulFirstHalfHome) {
        this.foulFirstHalfHome = foulFirstHalfHome;
    }

    public Integer getFoulSecondHalfHome() {
        return foulSecondHalfHome;
    }

    public void setFoulSecondHalfHome(Integer foulSecondHalfHome) {
        this.foulSecondHalfHome = foulSecondHalfHome;
    }

    public Integer getFoulExtraTimeHome() {
        return foulExtraTimeHome;
    }

    public void setFoulExtraTimeHome(Integer foulExtraTimeHome) {
        this.foulExtraTimeHome = foulExtraTimeHome;
    }

    public Integer getFoulFirstHalfGuest() {
        return foulFirstHalfGuest;
    }

    public void setFoulFirstHalfGuest(Integer foulFirstHalfGuest) {
        this.foulFirstHalfGuest = foulFirstHalfGuest;
    }

    public Integer getFoulSecondHalfGuest() {
        return foulSecondHalfGuest;
    }

    public void setFoulSecondHalfGuest(Integer foulSecondHalfGuest) {
        this.foulSecondHalfGuest = foulSecondHalfGuest;
    }

    public Integer getFoulExtraTimeGuest() {
        return foulExtraTimeGuest;
    }

    public void setFoulExtraTimeGuest(Integer foulExtraTimeGuest) {
        this.foulExtraTimeGuest = foulExtraTimeGuest;
    }

    public match_table() {
    }

    public match_table(Integer teamHome, Integer teamGuest, Integer shotFirstHalfHome, Integer shotSecondHalfHome, Integer shotExtraTimeHome, Integer shotFirstHalfGuest, Integer shotSecondHalfGuest, Integer shotExtraTimeGuest, Integer scoreHome, Integer scoreGuest, Integer possessionFirstHalfHome, Integer possessionSecondHalfHome, Integer possessionExtraTimeHome, Integer possessionFirstHalfGuest, Integer possessionSecondHalfGuest, Integer possessionExtraTimeGuest, Integer shotOnTargetFirstHalfHome, Integer shotOnTargetSecondHalfHome, Integer shotOnTargetExtraTimeHome, Integer shotOnTargetFirstHalfGuest, Integer shotOnTargetSecondHalfGuest, Integer shotOnTargetExtraTimeGuest, Integer cornerFirstHalfHome, Integer cornerSecondHalfHome, Integer cornerExtraTimeHome, Integer cornerFirstHalfGuest, Integer cornerSecondHalfGuest, Integer cornerExtraTimeGuest, Integer yellowCardFirstHalfHome, Integer yellowCardSecondHalfHome, Integer yellowCardExtraTimeHome, Integer yellowCardFirstHalfGuest, Integer yellowCardSecondHalfGuest, Integer yellowCardExtraTimeGuest, Integer redCardFirstHalfHome, Integer redCardSecondHalfHome, Integer redCardExtraTimeHome, Integer redCardFirstHalfGuest, Integer redCardSecondHalfGuest, Integer redCardExtraTimeGuest, Integer freeKickFirstHalfHome, Integer freeKickSecondHalfHome, Integer freeKickExtraTimeHome, Integer freeKickFirstHalfGuest, Integer freeKickSecondHalfGuest, Integer freeKickExtraTimeGuest, Integer offsideFirstHalfHome, Integer offsideSecondHalfHome, Integer offsideExtraTimeHome, Integer offsideFirstHalfGuest, Integer offsideSecondHalfGuest, Integer offsideExtraTimeGuest, Integer foulFirstHalfHome, Integer foulSecondHalfHome, Integer foulExtraTimeHome, Integer foulFirstHalfGuest, Integer foulSecondHalfGuest, Integer foulExtraTimeGuest) {
        this.teamHome = teamHome;
        this.teamGuest = teamGuest;
        this.shotFirstHalfHome = shotFirstHalfHome;
        this.shotSecondHalfHome = shotSecondHalfHome;
        this.shotExtraTimeHome = shotExtraTimeHome;
        this.shotFirstHalfGuest = shotFirstHalfGuest;
        this.shotSecondHalfGuest = shotSecondHalfGuest;
        this.shotExtraTimeGuest = shotExtraTimeGuest;
        this.scoreHome = scoreHome;
        this.scoreGuest = scoreGuest;
        this.possessionFirstHalfHome = possessionFirstHalfHome;
        this.possessionSecondHalfHome = possessionSecondHalfHome;
        this.possessionExtraTimeHome = possessionExtraTimeHome;
        this.possessionFirstHalfGuest = possessionFirstHalfGuest;
        this.possessionSecondHalfGuest = possessionSecondHalfGuest;
        this.possessionExtraTimeGuest = possessionExtraTimeGuest;
        this.shotOnTargetFirstHalfHome = shotOnTargetFirstHalfHome;
        this.shotOnTargetSecondHalfHome = shotOnTargetSecondHalfHome;
        this.shotOnTargetExtraTimeHome = shotOnTargetExtraTimeHome;
        this.shotOnTargetFirstHalfGuest = shotOnTargetFirstHalfGuest;
        this.shotOnTargetSecondHalfGuest = shotOnTargetSecondHalfGuest;
        this.shotOnTargetExtraTimeGuest = shotOnTargetExtraTimeGuest;
        this.cornerFirstHalfHome = cornerFirstHalfHome;
        this.cornerSecondHalfHome = cornerSecondHalfHome;
        this.cornerExtraTimeHome = cornerExtraTimeHome;
        this.cornerFirstHalfGuest = cornerFirstHalfGuest;
        this.cornerSecondHalfGuest = cornerSecondHalfGuest;
        this.cornerExtraTimeGuest = cornerExtraTimeGuest;
        this.yellowCardFirstHalfHome = yellowCardFirstHalfHome;
        this.yellowCardSecondHalfHome = yellowCardSecondHalfHome;
        this.yellowCardExtraTimeHome = yellowCardExtraTimeHome;
        this.yellowCardFirstHalfGuest = yellowCardFirstHalfGuest;
        this.yellowCardSecondHalfGuest = yellowCardSecondHalfGuest;
        this.yellowCardExtraTimeGuest = yellowCardExtraTimeGuest;
        this.redCardFirstHalfHome = redCardFirstHalfHome;
        this.redCardSecondHalfHome = redCardSecondHalfHome;
        this.redCardExtraTimeHome = redCardExtraTimeHome;
        this.redCardFirstHalfGuest = redCardFirstHalfGuest;
        this.redCardSecondHalfGuest = redCardSecondHalfGuest;
        this.redCardExtraTimeGuest = redCardExtraTimeGuest;
        this.freeKickFirstHalfHome = freeKickFirstHalfHome;
        this.freeKickSecondHalfHome = freeKickSecondHalfHome;
        this.freeKickExtraTimeHome = freeKickExtraTimeHome;
        this.freeKickFirstHalfGuest = freeKickFirstHalfGuest;
        this.freeKickSecondHalfGuest = freeKickSecondHalfGuest;
        this.freeKickExtraTimeGuest = freeKickExtraTimeGuest;
        this.offsideFirstHalfHome = offsideFirstHalfHome;
        this.offsideSecondHalfHome = offsideSecondHalfHome;
        this.offsideExtraTimeHome = offsideExtraTimeHome;
        this.offsideFirstHalfGuest = offsideFirstHalfGuest;
        this.offsideSecondHalfGuest = offsideSecondHalfGuest;
        this.offsideExtraTimeGuest = offsideExtraTimeGuest;
        this.foulFirstHalfHome = foulFirstHalfHome;
        this.foulSecondHalfHome = foulSecondHalfHome;
        this.foulExtraTimeHome = foulExtraTimeHome;
        this.foulFirstHalfGuest = foulFirstHalfGuest;
        this.foulSecondHalfGuest = foulSecondHalfGuest;
        this.foulExtraTimeGuest = foulExtraTimeGuest;
    }
}
