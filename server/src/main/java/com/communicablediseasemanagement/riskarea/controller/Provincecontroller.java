package com.communicablediseasemanagement.riskarea.controller;

import com.communicablediseasemanagement.riskarea.entity.Province;
import com.communicablediseasemanagement.riskarea.repository.Provincerepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class Provincecontroller {

    @Autowired
    private final Provincerepository provincerepository;

    public Provincecontroller(Provincerepository provincerepository) {
        this.provincerepository = provincerepository;
    }

    @GetMapping("/province")
    public Collection<Province> provinces() {
        return provincerepository.findAll().stream().collect(Collectors.toList());
    }

}