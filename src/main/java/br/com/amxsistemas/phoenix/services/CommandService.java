package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.dto.BankDTO;
import br.com.amxsistemas.phoenix.dto.CommandDTO;
import br.com.amxsistemas.phoenix.entities.Bank;
import br.com.amxsistemas.phoenix.entities.Command;
import br.com.amxsistemas.phoenix.repositories.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandService {

    @Autowired
    private CommandRepository repository;

    @Transactional(readOnly = true)
    public List<CommandDTO> findAll() {
        List<Command> list = repository.findAllByOrderByDescriptionAsc();
        return list.stream().map(x -> new CommandDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public CommandDTO insert(CommandDTO dto) {
        Command command = new Command(null, dto.getDescription(), dto.getStatus());
        command = repository.save(command);
        return new CommandDTO(command);
    }

    @Transactional
    public CommandDTO edit(CommandDTO dto) {
        Command command = repository.getOne(dto.getId());
        command.setDescription(dto.getDescription());
        command.setStatus(dto.getStatus());
        command = repository.save(command);
        return new CommandDTO(command);
    }

}
