package br.com.amxsistemas.phoenix.dto;

import br.com.amxsistemas.phoenix.entities.Regime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegimeDTO {

	private Integer id;
	private String description;

	public RegimeDTO() {
	}

	public RegimeDTO(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public RegimeDTO(Regime entity) {
		id = entity.getId();
		description = entity.getDescription();
	}

}
