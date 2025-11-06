package com.knightsanddie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "knights")
public class Knight {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "knight_gen")
    @jakarta.persistence.TableGenerator(
        name = "knight_gen",
        table = "id_gen",
        pkColumnName = "gen_name",
        valueColumnName = "gen_value",
        pkColumnValue = "knight_id",
        allocationSize = 1
    )
    private Long id;

    private String name;

    public Knight() {
    }

    public Knight(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Knight{id=" + id + ", name='" + name + "'}";
    }
}
