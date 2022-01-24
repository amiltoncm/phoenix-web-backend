package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.dto.RegimeDTO;
import br.com.amxsistemas.phoenix.services.RegimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/regimes")
public class RegimeController {

    @Autowired
    private RegimeService service;

    @GetMapping
    public ResponseEntity<List<RegimeDTO>> findAll() {
        List<RegimeDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<RegimeDTO> insert(@RequestBody RegimeDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegimeDTO> edit(@PathVariable Long id, @RequestBody RegimeDTO dto) {
        service.edit(dto);
        return ResponseEntity.ok().body(dto);
    }

}
