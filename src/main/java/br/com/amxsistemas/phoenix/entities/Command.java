package br.com.amxsistemas.phoenix.entities;

import br.com.amxsistemas.phoenix.enums.ActiveStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commands")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String description;

    @Column(nullable = false)
    private ActiveStatus status;

}
