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
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, unique = true)
    private Long code;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false)
    private ActiveStatus status;

}
