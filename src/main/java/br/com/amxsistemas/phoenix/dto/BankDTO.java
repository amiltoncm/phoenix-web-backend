package br.com.amxsistemas.phoenix.dto;

import br.com.amxsistemas.phoenix.entities.Bank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankDTO {
	
	private Long id;
	private Long code;
	private String name;
	private String status;
	
	public BankDTO() {
	}

	public BankDTO(Long id, Long code, String name, String status) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.status = status;
	}

	public BankDTO(Bank entity) {
		id = entity.getId();
		code = entity.getCode();
		name = entity.getName();
		status = entity.getStatus();
	}

}
