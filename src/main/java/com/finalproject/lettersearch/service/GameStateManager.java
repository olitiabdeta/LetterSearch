package com.finalproject.lettersearch.service;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

import java.util.ArrayList;
import java.util.List;

public class GameStateManager {

    //Singleton instance
    private static GameStateManager instance;

    //Tracked state
    private Board currentBoard;
    private String currentTheme;
    private final List<Word> wordsFound = new ArrayList<>();
    private final List<Word> wordsRemaining = new ArrayList<>();

    // private constructor so no one else can create it
    private GameStateManager() {}

    // global access point
    public static synchronized GameStateManager getInstance() {
        if (instance == null) {
            instance = new GameStateManager();
        }
        return instance;
    }

    // called when a new game starts
    public void startNewGame(Board board, String theme) {
        this.currentBoard = board;
        this.currentTheme = theme;

        wordsFound.clear();
        wordsRemaining.clear();



        if (board != null && board.getWords() != null) {
            for (Word w : board.getWords()) {
                w.setFoundState(false);
            }

            wordsRemaining.addAll(board.getWords());
        }
    }

    // called when a word is found
    public void markWordFound(Word word) {
        if (word == null) return;

        if (!wordsFound.contains(word)) {
            wordsFound.add(word);
        }
        wordsRemaining.remove(word);
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public String getCurrentTheme() {
        return currentTheme;
    }

    public List<Word> getWordsFound() {
        return new ArrayList<>(wordsFound);
    }

    public List<Word> getWordsRemaining() {
        return new ArrayList<>(wordsRemaining);
    }

    public void reset() {
        this.currentBoard = null;
        this.currentTheme = null;
        this.wordsFound.clear();
        this.wordsRemaining.clear();
    }
}
