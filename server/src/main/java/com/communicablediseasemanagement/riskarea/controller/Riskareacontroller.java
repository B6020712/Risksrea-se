package com.communicablediseasemanagement.riskarea.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.communicablediseasemanagement.riskarea.entity.*;
import com.communicablediseasemanagement.riskarea.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Riskareacontroller {
    @Autowired
    private final Riskarearepository riskarearepository;
    @Autowired
    private Provincerepository provincerepository;
    @Autowired
    private Diseaserepository diseaserepository;
    @Autowired
    private Communicablelevelrepository communicablelevelrepository;

    Riskareacontroller(Riskarearepository riskarearepository) {
        this.riskarearepository = riskarearepository;
    }

    @GetMapping("/riskarea")
    public Collection<Riskarea> riskareas() {
        return riskarearepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/riskarea/{province_id}/{disease_id}/{communicablelevel_id}/{saveddate}")
    public Riskarea newRiskarea(Riskarea newRiskarea,
    @PathVariable long province_id,
    @PathVariable long disease_id,
    @PathVariable long communicablelevel_id,
    @PathVariable String saveddate) {

    Province province = provincerepository.findById(province_id);
    Disease disease = diseaserepository.findById(disease_id);
    Communicablelevel communicablelevel = communicablelevelrepository.findById(communicablelevel_id);
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
        Date date = formatter.parse(saveddate);
        newRiskarea.setDate(date);
    } catch (ParseException e) {
    }

    newRiskarea.setProvince(province);
    newRiskarea.setDisease(disease);
    newRiskarea.setCommunicablelevel(communicablelevel);

    return riskarearepository.save(newRiskarea); 
    
    }
}