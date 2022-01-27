package br.com.amxsistemas.phoenix.dto;

import br.com.amxsistemas.phoenix.entities.Command;
import br.com.amxsistemas.phoenix.enums.ActiveStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandDTO {

    private Integer id;
    private String description;
    private ActiveStatus status;

    public CommandDTO() {
    }

    public CommandDTO(Integer id, String description, ActiveStatus status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public CommandDTO(Command entity) {
        id = entity.getId();
        description = entity.getDescription();
        status = entity.getStatus();
    }

}
