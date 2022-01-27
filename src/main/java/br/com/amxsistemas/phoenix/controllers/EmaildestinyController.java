package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.dto.EmaildestinyDTO;
import br.com.amxsistemas.phoenix.services.EmaildestinyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/emaildestinations")
public class EmaildestinyController {

    @Autowired
    private EmaildestinyService service;

    @GetMapping
    public ResponseEntity<List<EmaildestinyDTO>> findAll() {
        List<EmaildestinyDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EmaildestinyDTO> insert(@RequestBody EmaildestinyDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmaildestinyDTO> edit(@PathVariable Long id, @RequestBody EmaildestinyDTO dto) {
        service.edit(dto);
        return ResponseEntity.ok().body(dto);
    }

}
