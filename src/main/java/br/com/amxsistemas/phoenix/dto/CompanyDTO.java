package br.com.amxsistemas.phoenix.dto;

import br.com.amxsistemas.phoenix.entities.Company;
import br.com.amxsistemas.phoenix.entities.Regime;
import br.com.amxsistemas.phoenix.enums.ActiveStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class CompanyDTO {

    private Integer id;

    private String name;

    private String alias;

    private String document;

    private String identification;

    private String subscription;

    private String address;

    private Long number;

    private String complement;

    private String district;

    private Long city_id;

    private String city;

    private String state;

    private Integer country_id;

    private String zip;

    private String phone;

    private String email;

    private String home_page;

    private ActiveStatus status;

    private Regime regime;

    public CompanyDTO() {
    }

    public CompanyDTO(Integer id, String name, String alias, String document, String identification, String subscription,
                      String address, Long number, String complement, String district, Long city_id, String city,
                      String state, Integer country_id, String zip, String phone, String email, String home_page,
                      ActiveStatus status, Regime regime) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.document = document;
        this.identification = identification;
        this.subscription = subscription;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city_id = city_id;
        this.city = city;
        this.state = state;
        this.country_id = country_id;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.home_page = home_page;
        this.status = status;
        this.regime = regime;
    }

    public CompanyDTO(Company entity) {
        id = entity.getId();
        name = entity.getName();
        alias = entity.getAlias();
        document = entity.getDocument();
        identification = entity.getIdentification();
        subscription = entity.getSubscription();
        address = entity.getAddress();
        number = entity.getNumber();
        complement = entity.getComplement();
        district = entity.getDistrict();
        city_id = entity.getCity_id();
        city = entity.getCity();
        state = entity.getState();
        country_id = entity.getCountry_id();
        zip = entity.getZip();
        phone = entity.getPhone();
        email = entity.getEmail();
        home_page = entity.getHome_page();
        status = entity.getStatus();
        regime = entity.getRegime();
    }

}
