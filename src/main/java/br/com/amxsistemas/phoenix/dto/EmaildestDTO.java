package br.com.amxsistemas.phoenix.dto;

import br.com.amxsistemas.phoenix.entities.Emaildest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmaildestDTO {

    private Long id;
    private String address;

    public EmaildestDTO() {
    }

    public EmaildestDTO(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public EmaildestDTO(Emaildest entity) {
        id = entity.getId();
        address = entity.getAddress();
    }

}
