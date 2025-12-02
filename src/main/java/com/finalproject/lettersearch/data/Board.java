package com.finalproject.lettersearch.data;

import java.util.List;

public class Board {
    private final char [][] board;
    private final List<Word> words;
    public Board(char [][] board, List<Word> words) {
        this.board = board;
        this.words = words;
    }
    public char[][] getBoard() {
        return board;
    }
    public List<Word> getWords() {
        return words;
    }

}
