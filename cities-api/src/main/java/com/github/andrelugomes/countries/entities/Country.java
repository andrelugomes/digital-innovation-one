package com.github.andrelugomes.countries.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Country")
@Table(name = "pais")
public class Country {

  @Id
  private Long id;

  @Column(name = "nome")
  private String name;

  @Column(name = "nome_pt")
  private String portugueseName;

  @Column(name = "sigla")
  private String code;

  private Integer bacen;

  public Country() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPortugueseName() {
    return portugueseName;
  }

  public String getCode() {
    return code;
  }

  public Integer getBacen() {
    return bacen;
  }
}
