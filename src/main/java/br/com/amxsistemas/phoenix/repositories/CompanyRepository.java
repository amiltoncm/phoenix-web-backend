package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findAllByOrderByNameAsc();

}
