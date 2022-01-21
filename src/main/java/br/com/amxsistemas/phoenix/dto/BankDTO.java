package br.com.amxsistemas.phoenix.dto;

import br.com.amxsistemas.phoenix.entities.Bank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDTO {
	
	private Long id;
	private String name;
	
	public BankDTO() {
	}

	public BankDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public BankDTO(Bank entity) {
		id = entity.getId();
		name = entity.getName();
	}

}
