package com.montesown.services;

import com.montesown.model.Frame;
import com.montesown.model.Inspection;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class InspectionService {

    private final String BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();

    public InspectionService(String url) { this.BASE_URL = url;}

    public Inspection[] listInspections() {
        Inspection[] inspections = null;
        try {
            inspections = restTemplate.getForObject(BASE_URL + "inspections",Inspection[].class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        } catch (HttpMessageConversionException ex) {
            System.out.println(ex.getMessage());
        }
        return inspections;
    }

    public String getNotesByInspectionId(int inspectionId) {
        String notes = null;
        try {
            notes = restTemplate.getForObject(BASE_URL + "inspections/" + inspectionId + "/notes",String.class);
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        }
        return notes;
    }

    public boolean addNotes(Inspection inspection) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Inspection> entity = new HttpEntity<>(inspection,headers);

        boolean success = false;
        try {
            restTemplate.put(BASE_URL + "inspections/" + inspection.getInspectionId() + "/notes", entity);
            success = true;
        } catch (RestClientResponseException e) {
            System.out.print(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.print(e.getMessage());
        }
        return success;
    }

    public Frame[] getFramesByIdAndNum(int inspectionId, int boxNum) {
        Frame[] frames = null;
        try {
            frames = restTemplate.getForObject(BASE_URL + "inspections/" + inspectionId + "/frames/" + boxNum, Frame[].class);
        } catch (RestClientResponseException e) {
            System.out.print(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.print(e.getMessage());
        }
        return frames;
    }

    public int newInspection(Inspection newInspection) {
        try {
            Integer newId;
            HttpEntity<Inspection> entity = new HttpEntity<>(newInspection);
            newId = restTemplate.postForObject(BASE_URL + "inspections", entity, Integer.class);
            return  newId;
        } catch (RestClientResponseException e) {
            System.out.print(e.getRawStatusCode() + " : " + e.getStatusText());
            return 0;
        } catch (ResourceAccessException e) {
            System.out.print(e.getMessage());
            return 0;
        }
    }

    public boolean newFrame(Frame newFrame) {
        boolean success = false;
        try {
            HttpEntity<Frame> entity = new HttpEntity<>(newFrame);
            Frame returnedFrame = null;
            returnedFrame = restTemplate.postForObject(BASE_URL + "frames", entity, Frame.class);
            if (returnedFrame!=null) {
                success = true;
            }
        }catch (RestClientResponseException e) {
            System.out.print(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.print(e.getMessage());
        }
        return success;
    }

    public boolean addRestOfInspection(Inspection inspection) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Inspection> entity = new HttpEntity<>(inspection,headers);

        boolean success = false;
        try {
            restTemplate.put(BASE_URL + "inspections", entity);
            success = true;
        } catch (RestClientResponseException e) {
            System.out.print(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            System.out.print(e.getMessage());
        }
        return success;
    }



}
