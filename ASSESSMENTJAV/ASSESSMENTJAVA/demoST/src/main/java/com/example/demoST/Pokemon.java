package com.example.demoST;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pokemon {
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private int height;
    @JsonProperty("abilities")
    private List<Ability> abilities;

    public Pokemon(Integer id, String alturaPokemon, int nomePokemon, List<String> strings) {
    }

    public Pokemon(Long id, String name, int height, List<Ability> abilities) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.abilities = abilities;
    }

    // Getters e Setters

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public static class Ability {
        private String name;

        public Ability() {
        }

        public Ability(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
