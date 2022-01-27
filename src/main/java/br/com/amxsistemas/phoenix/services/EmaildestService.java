package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.dto.EmaildestDTO;
import br.com.amxsistemas.phoenix.entities.Emaildest;
import br.com.amxsistemas.phoenix.repositories.EmaildestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmaildestService {

    @Autowired
    private EmaildestRepository repository;

    @Transactional(readOnly = true)
    public List<EmaildestDTO> findAll() {
        List<Emaildest> list = repository.findAllByOrderByAddressAsc();
        return list.stream().map(x -> new EmaildestDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public EmaildestDTO insert(EmaildestDTO dto) {
        Emaildest emaildest = new Emaildest(null, dto.getAddress());
        emaildest = repository.save(emaildest);
        return new EmaildestDTO(emaildest);
    }

    @Transactional
    public EmaildestDTO edit(EmaildestDTO dto) {
        Emaildest emaildest = repository.getOne(dto.getId());
        emaildest.setAddress(dto.getAddress());
        emaildest = repository.save(emaildest);
        return new EmaildestDTO(emaildest);
    }

}
