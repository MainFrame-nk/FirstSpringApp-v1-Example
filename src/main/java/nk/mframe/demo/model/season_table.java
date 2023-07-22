package nk.mframe.demo.model;

import javax.persistence.*;

@Table(name = "season_table")
@Entity
public class season_table {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="season_table_seq")
    @SequenceGenerator(name="season_table_seq", sequenceName="SEQ_SEASON_TABLE")
    @Column(name = "idSeason", nullable = false)
    private Integer idSeason;

    private Integer idLeague;

    private String nameSeason;

    private int firstPlace, secondPlace, thirdPlace, fouthPlace, fifthPlace, sixthPlace, seventhPlace, eighthPlace, ninthPlace, tenthPlace, eleventhPlace
            , twelfthPlace, thirteenthPlace, fourteenthPlace, fifteenthPlace, sixteenthPlace, seventeenthPlace, eighteenthPlace, nineteenthPlace, twentiethPlace;

    private int scoreFirstPlace, scoreSecondPlace, scoreThirdPlace, scoreFouthPlace, scoreFifthPlace, scoreSixthPlace, scoreSeventhPlace, scoreEighthPlace
            , scoreNinthPlace, scoreTenthPlace, scoreEleventhPlace, scoreTwelfthPlace, scoreThirteenthPlace, scoreFourteenthPlace, scoreFifteenthPlace
            , scoreSixteenthPlace, scoreSeventeenthPlace, scoreEighteenthPlace, scoreNineteenthPlace, scoreTwentiethPlace;

    private int formFirstPlace, formSecondPlace, formThirdPlace, formFouthPlace, formFifthPlace, formSixthPlace, formSeventhPlace, formEighthPlace
            , formNinthPlace, formTenthPlace, formEleventhPlace, formTwelfthPlace, formThirteenthPlace, formFourteenthPlace, formFifteenthPlace
            , formSixteenthPlace, formSeventeenthPlace, formEighteenthPlace, formNineteenthPlace, formTwentiethPlace;

    private int levelFirstPlace, levelSecondPlace, levelThirdPlace, levelFouthPlace, levelFifthPlace, levelSixthPlace, levelSeventhPlace, levelEighthPlace
            , levelNinthPlace, levelTenthPlace, levelEleventhPlace, levelTwelfthPlace, levelThirteenthPlace, levelFourteenthPlace, levelFifteenthPlace
            , levelSixteenthPlace, levelSeventeenthPlace, levelEighteenthPlace, levelNineteenthPlace, levelTwentiethPlace;

    public Integer getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(Integer idSeason) {
        this.idSeason = idSeason;
    }

    public Integer getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(Integer idLeague) {
        this.idLeague = idLeague;
    }

    public String getNameSeason() {
        return nameSeason;
    }

    public void setNameSeason(String nameSeason) {
        this.nameSeason = nameSeason;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(int firstPlace) {
        this.firstPlace = firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(int secondPlace) {
        this.secondPlace = secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public void setThirdPlace(int thirdPlace) {
        this.thirdPlace = thirdPlace;
    }

    public int getFouthPlace() {
        return fouthPlace;
    }

    public void setFouthPlace(int fouthPlace) {
        this.fouthPlace = fouthPlace;
    }

    public int getFifthPlace() {
        return fifthPlace;
    }

    public void setFifthPlace(int fifthPlace) {
        this.fifthPlace = fifthPlace;
    }

    public int getSixthPlace() {
        return sixthPlace;
    }

    public void setSixthPlace(int sixthPlace) {
        this.sixthPlace = sixthPlace;
    }

    public int getSeventhPlace() {
        return seventhPlace;
    }

    public void setSeventhPlace(int seventhPlace) {
        this.seventhPlace = seventhPlace;
    }

    public int getEighthPlace() {
        return eighthPlace;
    }

    public void setEighthPlace(int eighthPlace) {
        this.eighthPlace = eighthPlace;
    }

    public int getNinthPlace() {
        return ninthPlace;
    }

    public void setNinthPlace(int ninthPlace) {
        this.ninthPlace = ninthPlace;
    }

    public int getTenthPlace() {
        return tenthPlace;
    }

    public void setTenthPlace(int tenthPlace) {
        this.tenthPlace = tenthPlace;
    }

    public int getEleventhPlace() {
        return eleventhPlace;
    }

    public void setEleventhPlace(int eleventhPlace) {
        this.eleventhPlace = eleventhPlace;
    }

    public int getTwelfthPlace() {
        return twelfthPlace;
    }

    public void setTwelfthPlace(int twelfthPlace) {
        this.twelfthPlace = twelfthPlace;
    }

    public int getThirteenthPlace() {
        return thirteenthPlace;
    }

    public void setThirteenthPlace(int thirteenthPlace) {
        this.thirteenthPlace = thirteenthPlace;
    }

    public int getFourteenthPlace() {
        return fourteenthPlace;
    }

    public void setFourteenthPlace(int fourteenthPlace) {
        this.fourteenthPlace = fourteenthPlace;
    }

    public int getFifteenthPlace() {
        return fifteenthPlace;
    }

    public void setFifteenthPlace(int fifteenthPlace) {
        this.fifteenthPlace = fifteenthPlace;
    }

    public int getSixteenthPlace() {
        return sixteenthPlace;
    }

    public void setSixteenthPlace(int sixteenthPlace) {
        this.sixteenthPlace = sixteenthPlace;
    }

    public int getSeventeenthPlace() {
        return seventeenthPlace;
    }

    public void setSeventeenthPlace(int seventeenthPlace) {
        this.seventeenthPlace = seventeenthPlace;
    }

    public int getEighteenthPlace() {
        return eighteenthPlace;
    }

    public void setEighteenthPlace(int eighteenthPlace) {
        this.eighteenthPlace = eighteenthPlace;
    }

    public int getNineteenthPlace() {
        return nineteenthPlace;
    }

    public void setNineteenthPlace(int nineteenthPlace) {
        this.nineteenthPlace = nineteenthPlace;
    }

    public int getTwentiethPlace() {
        return twentiethPlace;
    }

    public void setTwentiethPlace(int twentiethPlace) {
        this.twentiethPlace = twentiethPlace;
    }

    public int getScoreFirstPlace() {
        return scoreFirstPlace;
    }

    public void setScoreFirstPlace(int scoreFirstPlace) {
        this.scoreFirstPlace = scoreFirstPlace;
    }

    public int getScoreSecondPlace() {
        return scoreSecondPlace;
    }

    public void setScoreSecondPlace(int scoreSecondPlace) {
        this.scoreSecondPlace = scoreSecondPlace;
    }

    public int getScoreThirdPlace() {
        return scoreThirdPlace;
    }

    public void setScoreThirdPlace(int scoreThirdPlace) {
        this.scoreThirdPlace = scoreThirdPlace;
    }

    public int getScoreFouthPlace() {
        return scoreFouthPlace;
    }

    public void setScoreFouthPlace(int scoreFouthPlace) {
        this.scoreFouthPlace = scoreFouthPlace;
    }

    public int getScoreFifthPlace() {
        return scoreFifthPlace;
    }

    public void setScoreFifthPlace(int scoreFifthPlace) {
        this.scoreFifthPlace = scoreFifthPlace;
    }

    public int getScoreSixthPlace() {
        return scoreSixthPlace;
    }

    public void setScoreSixthPlace(int scoreSixthPlace) {
        this.scoreSixthPlace = scoreSixthPlace;
    }

    public int getScoreSeventhPlace() {
        return scoreSeventhPlace;
    }

    public void setScoreSeventhPlace(int scoreSeventhPlace) {
        this.scoreSeventhPlace = scoreSeventhPlace;
    }

    public int getScoreEighthPlace() {
        return scoreEighthPlace;
    }

    public void setScoreEighthPlace(int scoreEighthPlace) {
        this.scoreEighthPlace = scoreEighthPlace;
    }

    public int getScoreNinthPlace() {
        return scoreNinthPlace;
    }

    public void setScoreNinthPlace(int scoreNinthPlace) {
        this.scoreNinthPlace = scoreNinthPlace;
    }

    public int getScoreTenthPlace() {
        return scoreTenthPlace;
    }

    public void setScoreTenthPlace(int scoreTenthPlace) {
        this.scoreTenthPlace = scoreTenthPlace;
    }

    public int getScoreEleventhPlace() {
        return scoreEleventhPlace;
    }

    public void setScoreEleventhPlace(int scoreEleventhPlace) {
        this.scoreEleventhPlace = scoreEleventhPlace;
    }

    public int getScoreTwelfthPlace() {
        return scoreTwelfthPlace;
    }

    public void setScoreTwelfthPlace(int scoreTwelfthPlace) {
        this.scoreTwelfthPlace = scoreTwelfthPlace;
    }

    public int getScoreThirteenthPlace() {
        return scoreThirteenthPlace;
    }

    public void setScoreThirteenthPlace(int scoreThirteenthPlace) {
        this.scoreThirteenthPlace = scoreThirteenthPlace;
    }

    public int getScoreFourteenthPlace() {
        return scoreFourteenthPlace;
    }

    public void setScoreFourteenthPlace(int scoreFourteenthPlace) {
        this.scoreFourteenthPlace = scoreFourteenthPlace;
    }

    public int getScoreFifteenthPlace() {
        return scoreFifteenthPlace;
    }

    public void setScoreFifteenthPlace(int scoreFifteenthPlace) {
        this.scoreFifteenthPlace = scoreFifteenthPlace;
    }

    public int getScoreSixteenthPlace() {
        return scoreSixteenthPlace;
    }

    public void setScoreSixteenthPlace(int scoreSixteenthPlace) {
        this.scoreSixteenthPlace = scoreSixteenthPlace;
    }

    public int getScoreSeventeenthPlace() {
        return scoreSeventeenthPlace;
    }

    public void setScoreSeventeenthPlace(int scoreSeventeenthPlace) {
        this.scoreSeventeenthPlace = scoreSeventeenthPlace;
    }

    public int getScoreEighteenthPlace() {
        return scoreEighteenthPlace;
    }

    public void setScoreEighteenthPlace(int scoreEighteenthPlace) {
        this.scoreEighteenthPlace = scoreEighteenthPlace;
    }

    public int getScoreNineteenthPlace() {
        return scoreNineteenthPlace;
    }

    public void setScoreNineteenthPlace(int scoreNineteenthPlace) {
        this.scoreNineteenthPlace = scoreNineteenthPlace;
    }

    public int getScoreTwentiethPlace() {
        return scoreTwentiethPlace;
    }

    public void setScoreTwentiethPlace(int scoreTwentiethPlace) {
        this.scoreTwentiethPlace = scoreTwentiethPlace;
    }

    public int getFormFirstPlace() {
        return formFirstPlace;
    }

    public void setFormFirstPlace(int formFirstPlace) {
        this.formFirstPlace = formFirstPlace;
    }

    public int getFormSecondPlace() {
        return formSecondPlace;
    }

    public void setFormSecondPlace(int formSecondPlace) {
        this.formSecondPlace = formSecondPlace;
    }

    public int getFormThirdPlace() {
        return formThirdPlace;
    }

    public void setFormThirdPlace(int formThirdPlace) {
        this.formThirdPlace = formThirdPlace;
    }

    public int getFormFouthPlace() {
        return formFouthPlace;
    }

    public void setFormFouthPlace(int formFouthPlace) {
        this.formFouthPlace = formFouthPlace;
    }

    public int getFormFifthPlace() {
        return formFifthPlace;
    }

    public void setFormFifthPlace(int formFifthPlace) {
        this.formFifthPlace = formFifthPlace;
    }

    public int getFormSixthPlace() {
        return formSixthPlace;
    }

    public void setFormSixthPlace(int formSixthPlace) {
        this.formSixthPlace = formSixthPlace;
    }

    public int getFormSeventhPlace() {
        return formSeventhPlace;
    }

    public void setFormSeventhPlace(int formSeventhPlace) {
        this.formSeventhPlace = formSeventhPlace;
    }

    public int getFormEighthPlace() {
        return formEighthPlace;
    }

    public void setFormEighthPlace(int formEighthPlace) {
        this.formEighthPlace = formEighthPlace;
    }

    public int getFormNinthPlace() {
        return formNinthPlace;
    }

    public void setFormNinthPlace(int formNinthPlace) {
        this.formNinthPlace = formNinthPlace;
    }

    public int getFormTenthPlace() {
        return formTenthPlace;
    }

    public void setFormTenthPlace(int formTenthPlace) {
        this.formTenthPlace = formTenthPlace;
    }

    public int getFormEleventhPlace() {
        return formEleventhPlace;
    }

    public void setFormEleventhPlace(int formEleventhPlace) {
        this.formEleventhPlace = formEleventhPlace;
    }

    public int getFormTwelfthPlace() {
        return formTwelfthPlace;
    }

    public void setFormTwelfthPlace(int formTwelfthPlace) {
        this.formTwelfthPlace = formTwelfthPlace;
    }

    public int getFormThirteenthPlace() {
        return formThirteenthPlace;
    }

    public void setFormThirteenthPlace(int formThirteenthPlace) {
        this.formThirteenthPlace = formThirteenthPlace;
    }

    public int getFormFourteenthPlace() {
        return formFourteenthPlace;
    }

    public void setFormFourteenthPlace(int formFourteenthPlace) {
        this.formFourteenthPlace = formFourteenthPlace;
    }

    public int getFormFifteenthPlace() {
        return formFifteenthPlace;
    }

    public void setFormFifteenthPlace(int formFifteenthPlace) {
        this.formFifteenthPlace = formFifteenthPlace;
    }

    public int getFormSixteenthPlace() {
        return formSixteenthPlace;
    }

    public void setFormSixteenthPlace(int formSixteenthPlace) {
        this.formSixteenthPlace = formSixteenthPlace;
    }

    public int getFormSeventeenthPlace() {
        return formSeventeenthPlace;
    }

    public void setFormSeventeenthPlace(int formSeventeenthPlace) {
        this.formSeventeenthPlace = formSeventeenthPlace;
    }

    public int getFormEighteenthPlace() {
        return formEighteenthPlace;
    }

    public void setFormEighteenthPlace(int formEighteenthPlace) {
        this.formEighteenthPlace = formEighteenthPlace;
    }

    public int getFormNineteenthPlace() {
        return formNineteenthPlace;
    }

    public void setFormNineteenthPlace(int formNineteenthPlace) {
        this.formNineteenthPlace = formNineteenthPlace;
    }

    public int getFormTwentiethPlace() {
        return formTwentiethPlace;
    }

    public void setFormTwentiethPlace(int formTwentiethPlace) {
        this.formTwentiethPlace = formTwentiethPlace;
    }

    public int getLevelFirstPlace() {
        return levelFirstPlace;
    }

    public void setLevelFirstPlace(int levelFirstPlace) {
        this.levelFirstPlace = levelFirstPlace;
    }

    public int getLevelSecondPlace() {
        return levelSecondPlace;
    }

    public void setLevelSecondPlace(int levelSecondPlace) {
        this.levelSecondPlace = levelSecondPlace;
    }

    public int getLevelThirdPlace() {
        return levelThirdPlace;
    }

    public void setLevelThirdPlace(int levelThirdPlace) {
        this.levelThirdPlace = levelThirdPlace;
    }

    public int getLevelFouthPlace() {
        return levelFouthPlace;
    }

    public void setLevelFouthPlace(int levelFouthPlace) {
        this.levelFouthPlace = levelFouthPlace;
    }

    public int getLevelFifthPlace() {
        return levelFifthPlace;
    }

    public void setLevelFifthPlace(int levelFifthPlace) {
        this.levelFifthPlace = levelFifthPlace;
    }

    public int getLevelSixthPlace() {
        return levelSixthPlace;
    }

    public void setLevelSixthPlace(int levelSixthPlace) {
        this.levelSixthPlace = levelSixthPlace;
    }

    public int getLevelSeventhPlace() {
        return levelSeventhPlace;
    }

    public void setLevelSeventhPlace(int levelSeventhPlace) {
        this.levelSeventhPlace = levelSeventhPlace;
    }

    public int getLevelEighthPlace() {
        return levelEighthPlace;
    }

    public void setLevelEighthPlace(int levelEighthPlace) {
        this.levelEighthPlace = levelEighthPlace;
    }

    public int getLevelNinthPlace() {
        return levelNinthPlace;
    }

    public void setLevelNinthPlace(int levelNinthPlace) {
        this.levelNinthPlace = levelNinthPlace;
    }

    public int getLevelTenthPlace() {
        return levelTenthPlace;
    }

    public void setLevelTenthPlace(int levelTenthPlace) {
        this.levelTenthPlace = levelTenthPlace;
    }

    public int getLevelEleventhPlace() {
        return levelEleventhPlace;
    }

    public void setLevelEleventhPlace(int levelEleventhPlace) {
        this.levelEleventhPlace = levelEleventhPlace;
    }

    public int getLevelTwelfthPlace() {
        return levelTwelfthPlace;
    }

    public void setLevelTwelfthPlace(int levelTwelfthPlace) {
        this.levelTwelfthPlace = levelTwelfthPlace;
    }

    public int getLevelThirteenthPlace() {
        return levelThirteenthPlace;
    }

    public void setLevelThirteenthPlace(int levelThirteenthPlace) {
        this.levelThirteenthPlace = levelThirteenthPlace;
    }

    public int getLevelFourteenthPlace() {
        return levelFourteenthPlace;
    }

    public void setLevelFourteenthPlace(int levelFourteenthPlace) {
        this.levelFourteenthPlace = levelFourteenthPlace;
    }

    public int getLevelFifteenthPlace() {
        return levelFifteenthPlace;
    }

    public void setLevelFifteenthPlace(int levelFifteenthPlace) {
        this.levelFifteenthPlace = levelFifteenthPlace;
    }

    public int getLevelSixteenthPlace() {
        return levelSixteenthPlace;
    }

    public void setLevelSixteenthPlace(int levelSixteenthPlace) {
        this.levelSixteenthPlace = levelSixteenthPlace;
    }

    public int getLevelSeventeenthPlace() {
        return levelSeventeenthPlace;
    }

    public void setLevelSeventeenthPlace(int levelSeventeenthPlace) {
        this.levelSeventeenthPlace = levelSeventeenthPlace;
    }

    public int getLevelEighteenthPlace() {
        return levelEighteenthPlace;
    }

    public void setLevelEighteenthPlace(int levelEighteenthPlace) {
        this.levelEighteenthPlace = levelEighteenthPlace;
    }

    public int getLevelNineteenthPlace() {
        return levelNineteenthPlace;
    }

    public void setLevelNineteenthPlace(int levelNineteenthPlace) {
        this.levelNineteenthPlace = levelNineteenthPlace;
    }

    public int getLevelTwentiethPlace() {
        return levelTwentiethPlace;
    }

    public void setLevelTwentiethPlace(int levelTwentiethPlace) {
        this.levelTwentiethPlace = levelTwentiethPlace;
    }

    public season_table() {
    }

    public season_table(Integer idLeague, String nameSeason, int firstPlace, int secondPlace, int thirdPlace, int fouthPlace, int fifthPlace, int sixthPlace, int seventhPlace, int eighthPlace, int ninthPlace, int tenthPlace, int eleventhPlace, int twelfthPlace, int thirteenthPlace, int fourteenthPlace, int fifteenthPlace, int sixteenthPlace, int seventeenthPlace, int eighteenthPlace, int nineteenthPlace, int twentiethPlace) {
        this.idLeague = idLeague;
        this.nameSeason = nameSeason;
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
        this.fouthPlace = fouthPlace;
        this.fifthPlace = fifthPlace;
        this.sixthPlace = sixthPlace;
        this.seventhPlace = seventhPlace;
        this.eighthPlace = eighthPlace;
        this.ninthPlace = ninthPlace;
        this.tenthPlace = tenthPlace;
        this.eleventhPlace = eleventhPlace;
        this.twelfthPlace = twelfthPlace;
        this.thirteenthPlace = thirteenthPlace;
        this.fourteenthPlace = fourteenthPlace;
        this.fifteenthPlace = fifteenthPlace;
        this.sixteenthPlace = sixteenthPlace;
        this.seventeenthPlace = seventeenthPlace;
        this.eighteenthPlace = eighteenthPlace;
        this.nineteenthPlace = nineteenthPlace;
        this.twentiethPlace = twentiethPlace;
    }
}
