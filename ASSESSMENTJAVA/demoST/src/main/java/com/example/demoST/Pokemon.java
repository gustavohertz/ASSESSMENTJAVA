package com.example.demoST;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("height")
    private int height;
    @JsonProperty("abilities")
    private List abilities;

    public Pokemon(Long id, String name, int height, List<String> abilities) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.abilities = abilities;
    }

    public Pokemon(){

    }

}
