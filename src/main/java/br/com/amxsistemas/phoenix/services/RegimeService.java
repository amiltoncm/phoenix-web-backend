package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.dto.RegimeDTO;
import br.com.amxsistemas.phoenix.entities.Regime;
import br.com.amxsistemas.phoenix.repositories.RegimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegimeService {

    @Autowired
    private RegimeRepository repository;

    @Transactional(readOnly = true)
    public List<RegimeDTO> findAll() {
        List<Regime> list = repository.findAllByOrderByDescriptionAsc();
        return list.stream().map(x -> new RegimeDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public RegimeDTO insert(RegimeDTO dto) {
        Regime regime = new Regime(null, dto.getDescription());
        regime = repository.save(regime);
        return new RegimeDTO(regime);
    }

    @Transactional
    public RegimeDTO edit(RegimeDTO dto) {
        Regime regime = repository.getOne(dto.getId());
        regime.setDescription(dto.getDescription());
        regime = repository.save(regime);
        return new RegimeDTO(regime);
    }

}
