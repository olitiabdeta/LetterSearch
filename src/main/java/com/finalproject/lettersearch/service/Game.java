package com.finalproject.lettersearch.service;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import com.finalproject.lettersearch.factory.SearchFactory;
import com.finalproject.lettersearch.strategy.SearchTemplate;
import java.util.List;
import com.finalproject.lettersearch.service.GameStateManager;

public class Game {
    protected Board board;
    private List<Word> words;
    private final SearchFactory searchFactory;
    private SearchTemplate strategy;
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
            if (!word.isFound() && word.getWord().equals(selected) ){
                if (strategy != null && strategy.search(board, word))
                {
                    word.setFoundState(true);
                    //tell the global manager
                    GameStateManager.getInstance().markWordFound(word);
                    return true;
                }

            }
        }
        return false;
    }
    public void setStrategy (SearchTemplate strategy) {
        this.strategy = strategy;
    }

}
