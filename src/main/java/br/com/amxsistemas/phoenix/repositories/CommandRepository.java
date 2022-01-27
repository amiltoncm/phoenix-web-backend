package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommandRepository extends JpaRepository<Command, Integer> {

    List<Command> findAllByOrderByDescriptionAsc();

}
