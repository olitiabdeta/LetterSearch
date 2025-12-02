package com.finalproject.lettersearch.service;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import com.finalproject.lettersearch.factory.SearchFactory;

import java.util.List;

public class Game {
    private Board board;
    private List<Word> words;
    private final SearchFactory searchFactory;
    public Game(SearchFactory searchFactory) {
        this.searchFactory = searchFactory;
    }
    public void startGame() {
        this.board = searchFactory.createBoard();
        this.words = board.getWords();
    }

    public Board getBoard() {
        return board;
    }

    public boolean wordExists (String selected)
    {
        for (Word word : this.board.getWords()) {
            if (word.getWord().equals(selected)  && !word.isFound()){
                word.setFoundState(true);
                return true;
            }
        }
        return false;
    }

}
