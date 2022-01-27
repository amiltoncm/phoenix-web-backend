package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Emaildest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmaildestRepository extends JpaRepository<Emaildest, Long> {

    List<Emaildest> findAllByOrderByAddressAsc();

}
