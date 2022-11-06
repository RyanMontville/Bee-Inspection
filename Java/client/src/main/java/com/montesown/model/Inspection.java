package com.montesown.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Inspection {
    //private List<Box> boxes;
    private int inspectionId;
    private String weather;
    private LocalDateTime dateTime;
    private String beeTemperament;
    private String beePopulation;
    private String dronePopulation;
    private String layingPattern;
    private String hiveBeetles;
    private String otherPests;
    private String notes;

    public Inspection() {
        //this.boxes = new ArrayList<>();
    }

    public int getInspectionId() { return inspectionId; }

    public void setInspectionId(int inspectionId) { this.inspectionId = inspectionId; }

    //public List<Box> getBoxes() {return boxes;}

    //public void setBoxes(List<Box> boxes) { this.boxes = boxes;}

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public LocalDateTime getDateTime() { return this.dateTime; }

    public String getDateTimeFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        String formattedDateTime = this.dateTime.format(formatter);
        return formattedDateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getBeeTemperament() {
        return beeTemperament;
    }

    public void setBeeTemperament(String beeTemperament) {
        this.beeTemperament = beeTemperament;
    }

    public String getBeePopulation() {
        return beePopulation;
    }

    public void setBeePopulation(String beePopulation) {
        this.beePopulation = beePopulation;
    }

    public String getDronePopulation() {
        return dronePopulation;
    }

    public void setDronePopulation(String dronePopulation) {
        this.dronePopulation = dronePopulation;
    }

    public String getLayingPattern() {
        return layingPattern;
    }

    public void setLayingPattern(String layingPattern) {
        this.layingPattern = layingPattern;
    }

    public String getHiveBeetles() {
        return hiveBeetles;
    }

    public void setHiveBeetles(String hiveBeetles) {
        this.hiveBeetles = hiveBeetles;
    }

    public String getOtherPests() {
        return otherPests;
    }

    public void setOtherPests(String otherPests) {
        this.otherPests = otherPests;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    //public void addBox (Box box) {boxes.add(box);}
}