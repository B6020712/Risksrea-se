package com.communicablediseasemanagement.riskarea.controller;

import com.communicablediseasemanagement.riskarea.entity.Communicablelevel;
import com.communicablediseasemanagement.riskarea.repository.Communicablelevelrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Communicablelevelcontroller {

    @Autowired
    private final Communicablelevelrepository communicablelevelrepository;

    public Communicablelevelcontroller(Communicablelevelrepository communicablelevelrepository) {
        this.communicablelevelrepository = communicablelevelrepository;
    }

    @GetMapping("/communicablelevel")
    public Collection<Communicablelevel> communicablelevels() {
        return communicablelevelrepository.findAll().stream().collect(Collectors.toList());
    }

}