package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.dto.BankDTO;
import br.com.amxsistemas.phoenix.entities.Bank;
import br.com.amxsistemas.phoenix.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankService {

    @Autowired
    private BankRepository repository;

    @Transactional(readOnly = true)
    public List<BankDTO> findAll() {
        List<Bank> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(x -> new BankDTO(x)).collect(Collectors.toList());
    }

}
