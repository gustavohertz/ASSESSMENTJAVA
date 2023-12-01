package com.example.demoST;
import lombok.Data;

import java.util.List;

@Data
public class MeuRequest {
    private String campoString;
    private int campoNumero;
    private List<Object> array;

}
