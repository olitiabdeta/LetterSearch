package com.finalproject.lettersearch.data;

import java.util.List;

public class Board {
    private final char [][] board;
    private final List<String> words;
    public Board(char [][] board, List<String> words) {
        this.board = board;
        this.words = words;
    }
    public char[][] getBoard() {
        return board;
    }
    public List<String> getWords() {
        return words;
    }

}
