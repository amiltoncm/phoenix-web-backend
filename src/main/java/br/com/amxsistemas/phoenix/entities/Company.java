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
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String alias;

    @Column(nullable = false, unique = true, length = 18)
    private String document;

    @Column(nullable = false, unique = true, length = 15)
    private String identification;

    @Column(nullable = false, unique = true, length = 10)
    private String subscription;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(nullable = false)
    private Long number;

    @Column(length = 20)
    private String complement;

    @Column(length = 20)
    private String district;

    @Column(nullable = false)
    private Long city_id;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false,length = 2)
    private String state;

    @Column(nullable = false)
    private Integer country_id;

    @Column(nullable = false, length = 9)
    private String zip;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(length = 50)
    private String home_page;

    @Column(nullable = false)
    private ActiveStatus status;

    @ManyToOne
    @JoinColumn(name = "regimeId", nullable = false)
    private Regime regime;

}
