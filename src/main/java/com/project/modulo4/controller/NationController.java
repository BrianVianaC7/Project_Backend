package com.project.modulo4.controller;


import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.service.NationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/nations")
public class NationController {

    @Autowired
    private NationService nationService;

    @GetMapping
    public List<NationDTO> getAll() {
        return nationService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NationDTO> getNationById(@PathVariable Long id) {
        NationDTO nation = nationService.getById(id);
        if (nation != null) {
            return ResponseEntity.ok(nation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
