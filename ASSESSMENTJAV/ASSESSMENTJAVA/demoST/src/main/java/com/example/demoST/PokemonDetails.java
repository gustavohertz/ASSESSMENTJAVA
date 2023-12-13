package com.example.demoST;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDetails {
    private int id;
    private String name;
    private int height;
    private String movesUrl;
    private Map<String, Object> additionalDetails = new HashMap<>();
    private List<String> abilities;

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }
}
