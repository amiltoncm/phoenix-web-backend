package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {

    List<Bank> findAllByOrderByNameAsc();

}
