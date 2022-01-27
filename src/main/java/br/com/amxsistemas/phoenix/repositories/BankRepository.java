package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BankRepository extends JpaRepository<Bank, Long> {

    List<Bank> findAllByOrderByNameAsc();

}
