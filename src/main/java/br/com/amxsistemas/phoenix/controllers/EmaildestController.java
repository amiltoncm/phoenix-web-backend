package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.dto.EmaildestDTO;
import br.com.amxsistemas.phoenix.services.EmaildestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/emaildests")
public class EmaildestController {

    @Autowired
    private EmaildestService service;

    @GetMapping
    public ResponseEntity<List<EmaildestDTO>> findAll() {
        List<EmaildestDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EmaildestDTO> insert(@RequestBody EmaildestDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmaildestDTO> edit(@PathVariable Long id, @RequestBody EmaildestDTO dto) {
        service.edit(dto);
        return ResponseEntity.ok().body(dto);
    }

}
