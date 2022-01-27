package br.com.amxsistemas.phoenix.repositories;

import br.com.amxsistemas.phoenix.entities.Regime;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegimeRepository extends JpaRepository<Regime, Integer> {

    List<Regime> findAllByOrderByDescriptionAsc();

}
