package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.dto.BankDTO;
import br.com.amxsistemas.phoenix.entities.Bank;
import br.com.amxsistemas.phoenix.repositories.BankRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private BankRepository repository;

    @Transactional(readOnly = true)
    public List<BankDTO> findAll() {
        List<Bank> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(x -> new BankDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public BankDTO insert(BankDTO dto) {
        Bank bank = new Bank(null, dto.getCode(), dto.getName(), dto.getStatus());
        bank = repository.save(bank);
        return new BankDTO(bank);
    }

    @Transactional
    public BankDTO edit(BankDTO dto) {
        Bank bank = repository.getOne(dto.getId());
        bank.setCode(dto.getCode());
        bank.setName(dto.getName());
        bank.setStatus(dto.getStatus());
        bank = repository.save(bank);
        return new BankDTO(bank);
    }

}
