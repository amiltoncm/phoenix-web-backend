package br.com.amxsistemas.phoenix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.amxsistemas.phoenix.entities.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
