package pe.edu.upc.DocSeekerTP.entities;

public class ChronicIllness {
    private int id_Illness;
    private boolean asthma;
    private boolean diabetes;
    private boolean arthritis;
    private boolean hypertension;
    private boolean depression;
    private boolean highCholesterol;
    private boolean gynecologicalProblems;
    private boolean osteoporosis;
    private boolean cardiovascular;
    private String others;

    public ChronicIllness(int id_Illness, boolean asthma, boolean diabetes, boolean arthritis, boolean hypertension, boolean depression, boolean highCholesterol, boolean gynecologicalProblems, boolean osteoporosis, boolean cardiovascular, String others) {
        this.id_Illness = id_Illness;
        this.asthma = asthma;
        this.diabetes = diabetes;
        this.arthritis = arthritis;
        this.hypertension = hypertension;
        this.depression = depression;
        this.highCholesterol = highCholesterol;
        this.gynecologicalProblems = gynecologicalProblems;
        this.osteoporosis = osteoporosis;
        this.cardiovascular = cardiovascular;
        this.others = others;
    }

    public int getId_Illness() {
        return id_Illness;
    }

    public void setId_Illness(int id_Illness) {
        this.id_Illness = id_Illness;
    }

    public boolean isAsthma() {
        return asthma;
    }

    public void setAsthma(boolean asthma) {
        this.asthma = asthma;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isArthritis() {
        return arthritis;
    }

    public void setArthritis(boolean arthritis) {
        this.arthritis = arthritis;
    }

    public boolean isHypertension() {
        return hypertension;
    }

    public void setHypertension(boolean hypertension) {
        this.hypertension = hypertension;
    }

    public boolean isDepression() {
        return depression;
    }

    public void setDepression(boolean depression) {
        this.depression = depression;
    }

    public boolean isHighCholesterol() {
        return highCholesterol;
    }

    public void setHighCholesterol(boolean highCholesterol) {
        this.highCholesterol = highCholesterol;
    }

    public boolean isGynecologicalProblems() {
        return gynecologicalProblems;
    }

    public void setGynecologicalProblems(boolean gynecologicalProblems) {
        this.gynecologicalProblems = gynecologicalProblems;
    }

    public boolean isOsteoporosis() {
        return osteoporosis;
    }

    public void setOsteoporosis(boolean osteoporosis) {
        this.osteoporosis = osteoporosis;
    }

    public boolean isCardiovascular() {
        return cardiovascular;
    }

    public void setCardiovascular(boolean cardiovascular) {
        this.cardiovascular = cardiovascular;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
