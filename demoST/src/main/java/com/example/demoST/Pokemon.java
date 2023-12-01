package com.example.demoST;

import java.util.List;

public class Pokemon {
    private String name;
    private int height;
    private List<Move> moves;

    public Pokemon() {
    }

    public Pokemon(String name, int height, List<Move> moves) {
        this.name = name;
        this.height = height;
        this.moves = moves;
    }

    // Getters e Setters
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

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static class Move {
        private String name;


        public Move() {
        }

        public Move(String name) {
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
