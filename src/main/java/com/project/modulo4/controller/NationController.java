package com.project.modulo4.controller;

import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.service.NationService;
import com.project.modulo4.utils.exception.NationNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Nacionalidades")
@Slf4j
@RestController
@RequestMapping("/nations")
public class NationController {

    private final NationService nationService;

    public NationController(NationService nationService) {
        this.nationService = nationService;
    }

    @Operation(summary = "Obtiene la lista de todas las Nacionalidades")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NationDTO> getAll() {
        return nationService.getAll();
    }

    @Operation(summary = "Obtiene una Nacionalidad determinado")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NationDTO> getNationById(@PathVariable Long id) throws NationNotFoundException {
        NationDTO nation = nationService.getById(id);
        if (nation != null) {
            return ResponseEntity.ok(nation);
        } else {
            throw new NationNotFoundException(id);
        }
    }

}
