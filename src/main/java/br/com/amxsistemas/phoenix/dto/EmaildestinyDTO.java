package br.com.amxsistemas.phoenix.dto;

import br.com.amxsistemas.phoenix.entities.Emaildestiny;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmaildestinyDTO {

    private Long id;
    private String address;

    public EmaildestinyDTO() {
    }

    public EmaildestinyDTO(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public EmaildestinyDTO(Emaildestiny entity) {
        id = entity.getId();
        address = entity.getAddress();
    }

}
