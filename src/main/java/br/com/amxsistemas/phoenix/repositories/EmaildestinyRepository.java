package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Emaildestiny;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmaildestinyRepository extends JpaRepository<Emaildestiny, Long> {

    List<Emaildestiny> findAllByOrderByAddressAsc();

}
