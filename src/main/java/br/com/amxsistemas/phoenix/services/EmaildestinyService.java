package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.dto.EmaildestinyDTO;
import br.com.amxsistemas.phoenix.entities.Emaildestiny;
import br.com.amxsistemas.phoenix.repositories.EmaildestinyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmaildestinyService {

    @Autowired
    private EmaildestinyRepository repository;

    @Transactional(readOnly = true)
    public List<EmaildestinyDTO> findAll() {
        List<Emaildestiny> list = repository.findAllByOrderByAddressAsc();
        return list.stream().map(x -> new EmaildestinyDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public EmaildestinyDTO insert(EmaildestinyDTO dto) {
        Emaildestiny emaildestiny = new Emaildestiny(null, dto.getAddress());
        emaildestiny = repository.save(emaildestiny);
        return new EmaildestinyDTO(emaildestiny);
    }

    @Transactional
    public EmaildestinyDTO edit(EmaildestinyDTO dto) {
        Emaildestiny emaildestiny = repository.getOne(dto.getId());
        emaildestiny.setAddress(dto.getAddress());
        emaildestiny = repository.save(emaildestiny);
        return new EmaildestinyDTO(emaildestiny);
    }

}
