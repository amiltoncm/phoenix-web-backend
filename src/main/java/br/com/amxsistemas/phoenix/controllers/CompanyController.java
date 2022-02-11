package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.dto.CompanyDTO;
import br.com.amxsistemas.phoenix.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAll() {
        List<CompanyDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> insert(@RequestBody CompanyDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO> edit(@PathVariable Integer id, @RequestBody CompanyDTO dto) {
        service.edit(dto);
        return ResponseEntity.ok().body(dto);
    }

}
