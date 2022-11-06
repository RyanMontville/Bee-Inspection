package com.montesown.BeeTracker.dao;

import com.montesown.BeeTracker.model.Box;
import com.montesown.BeeTracker.model.Inspection;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInspectionDao implements InspectionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInspectionDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Inspection> list() {
        List<Inspection> inspections = new ArrayList<>();
        String sql = "SELECT inspection_id, weather, bee_temperament, bee_population, drone_population, laying_pattern, hive_beetles, other_pests, date_time, notes " +
                "FROM public.inspection ORDER BY inspection_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            inspections.add(mapRowToInspection(results));
        }
        return inspections;
    }

    @Override
    public Inspection getInspection(int inspectionId) {
        Inspection inspection = null;
        String sql = "SELECT inspection_id, weather, bee_temperament, bee_population, drone_population, " +
                "laying_pattern, hive_beetles, other_pests, date_time, notes FROM public.inspection WHERE inspection_id=?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,inspectionId);
        if(results.next()){
            inspection = mapRowToInspection(results);
        }
        return inspection;
    }

    @Override
    public String getNotesByInspectionId(int inspectionId){
        String notes = "";
        String sql = "SELECT  notes FROM public.inspection WHERE inspection_id=?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,inspectionId);
        if(result.next()){
            notes = result.getString("notes");
        }
        return notes;
    }

    @Override
    public int createInspection(Inspection inspection) {
        String sql = "INSERT INTO public.inspection(weather, bee_temperament, bee_population, drone_population, laying_pattern, " +
                "hive_beetles, other_pests, date_time)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING inspection_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,inspection.getWeather(),inspection.getBeeTemperament(),
                inspection.getBeePopulation(),inspection.getDronePopulation(),inspection.getLayingPattern(),
                inspection.getHiveBeetles(),inspection.getOtherPests(),inspection.getDateTime());
        return newId;
    }

    @Override
    public void updateNotes(String notes, int inspectionId) {
        String sql = "UPDATE public.inspection SET  notes=? WHERE inspection_id=?;";
        jdbcTemplate.update(sql,notes,inspectionId);
    }

    //TODO: add get inspection by <...> to filter results

    private Inspection mapRowToInspection(SqlRowSet rowSet){
        Inspection inspection = new Inspection();
        inspection.setInspectionId(rowSet.getInt("inspection_id"));
        inspection.setWeather(rowSet.getString("weather"));
        inspection.setDateTime(rowSet.getTimestamp("date_time").toLocalDateTime());
        inspection.setBeeTemperament(rowSet.getString("bee_temperament"));
        inspection.setBeePopulation(rowSet.getString("bee_population"));
        inspection.setDronePopulation(rowSet.getString("drone_population"));
        inspection.setLayingPattern(rowSet.getString("laying_pattern"));
        inspection.setHiveBeetles(rowSet.getString("hive_beetles"));
        inspection.setOtherPests(rowSet.getString("other_pests"));
        inspection.setNotes(rowSet.getString("notes"));
    //TODO make this work
        /**for (int i=3;i>0;i--) {
            Box newBox = new Box(i);
            //newBox.setFrames(frameDao.getFrameByInspectionAndBox(inspection.getInspectionId(), newBox.getBoxNumber()));
            inspection.addBox(newBox);
        }**/
        return inspection;
    }

}