package br.com.amxsistemas.phoenix.controllers;

import br.com.amxsistemas.phoenix.dto.BankDTO;
import br.com.amxsistemas.phoenix.services.BankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
