package br.com.amxsistemas.phoenix.services;

import br.com.amxsistemas.phoenix.dto.CompanyDTO;
import br.com.amxsistemas.phoenix.entities.Company;
import br.com.amxsistemas.phoenix.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Transactional(readOnly = true)
    public List<CompanyDTO> findAll() {
        List<Company> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(x -> new CompanyDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public CompanyDTO insert(CompanyDTO dto) {
        Company company = new Company(null, 
                                      dto.getName(),
                                      dto.getAlias(),
                                      dto.getDocument(),
                                      dto.getIdentification(),
                                      dto.getSubscription(),
                                      dto.getAddress(),
                                      dto.getNumber(),
                                      dto.getComplement(),
                                      dto.getDistrict(),
                                      dto.getCity_id(),
                                      dto.getCity(),
                                      dto.getState(),
                                      dto.getCountry_id(),
                                      dto.getZip(),
                                      dto.getPhone(),
                                      dto.getEmail(),
                                      dto.getHome_page(),
                                      dto.getStatus(),
                                      dto.getRegime());
        company = repository.save(company);
        return new CompanyDTO(company);
    }

    @Transactional
    public CompanyDTO edit(CompanyDTO dto) {
        Company company = repository.getOne(dto.getId());
        company.setName(dto.getName());
        company.setAlias(dto.getAlias());
        company.setDocument(dto.getDocument());
        company.setIdentification(dto.getIdentification());
        company.setSubscription(dto.getSubscription());
        company.setAddress(dto.getAddress());
        company.setNumber(dto.getNumber());
        company.setComplement(dto.getComplement());
        company.setDistrict(dto.getDistrict());
        company.setCity_id(dto.getCity_id());
        company.setCity(dto.getCity());
        company.setState(dto.getState());
        company.setCountry_id(dto.getCountry_id());
        company.setZip(dto.getZip());
        company.setPhone(dto.getPhone());
        company.setEmail(dto.getEmail());
        company.setHome_page(dto.getHome_page());
        company.setStatus(dto.getStatus());
        company.setRegime(dto.getRegime());
        company = repository.save(company);
        return new CompanyDTO(company);
    }

}
