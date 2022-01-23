package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.dto.BankDTO;
import br.com.amxsistemas.phoenix.services.BankService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/banks")
public class BankController {

    @Autowired
    private BankService service;

    @GetMapping
    public ResponseEntity<List<BankDTO>> findAll() {
        List<BankDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<BankDTO> insert(@RequestBody BankDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankDTO> edit(@PathVariable Long id, @RequestBody BankDTO dto) {
        service.edit(dto);
        return ResponseEntity.ok().body(dto);
    }

}
