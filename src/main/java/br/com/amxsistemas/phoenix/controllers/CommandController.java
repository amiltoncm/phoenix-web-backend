package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.dto.CommandDTO;
import br.com.amxsistemas.phoenix.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/commands")
public class CommandController {

    @Autowired
    private CommandService service;

    @GetMapping
    public ResponseEntity<List<CommandDTO>> findAll() {
        List<CommandDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<CommandDTO> insert(@RequestBody CommandDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandDTO> edit(@PathVariable Long id, @RequestBody CommandDTO dto) {
        service.edit(dto);
        return ResponseEntity.ok().body(dto);
    }

}
