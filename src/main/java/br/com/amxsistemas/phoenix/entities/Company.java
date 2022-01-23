package br.com.amxsistemas.phoenix.entities;

import br.com.amxsistemas.phoenix.enums.ActiveStatus;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String alias;

    @Column
    private String document;

    @Column
    private String identification;

    @Column
    private String subscription;

    @Column
    private String address;

    @Column
    private Long number;

    @Column
    private String complement;

    @Column
    private String district;

    @Column
    private Long city_id;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private Integer country_id;

    @Column
    private String zip;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String home_page;

    @Column
    private ActiveStatus status;

}
