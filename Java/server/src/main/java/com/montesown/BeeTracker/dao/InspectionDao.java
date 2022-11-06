package com.montesown.BeeTracker.dao;

import com.montesown.BeeTracker.model.Inspection;

import java.util.List;

public interface InspectionDao {

    List<Inspection> list();

    Inspection getInspection(int inspectionId);

    String getNotesByInspectionId(int inspectionId);

    int createInspection(Inspection inspection);

    void updateNotes(String notes, int inspectionId);

}