package com.finalproject.lettersearch.service;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import com.finalproject.lettersearch.factory.SearchFactory;
import com.finalproject.lettersearch.strategy.SearchTemplate;
import java.util.List;
import com.finalproject.lettersearch.service.GameStateManager;
import com.finalproject.lettersearch.observer.IObserver;
import com.finalproject.lettersearch.observer.ListObserver;
import com.finalproject.lettersearch.observer.ScoreObserver;
import com.finalproject.lettersearch.strategy.DiagonalStrategy;
import com.finalproject.lettersearch.strategy.HorizontalStrategy;
import com.finalproject.lettersearch.strategy.VerticalStrategy;
import java.util.ArrayList;

public class Game {
    protected Board board;
    private List<Word> words;
    private final SearchFactory searchFactory;
    private SearchTemplate strategy;
    private final List<SearchTemplate> strategies = new ArrayList<>();
    private final List<IObserver> observers = new ArrayList<>();
    private final ListObserver listObserver = new ListObserver();
    private final ScoreObserver scoreObserver = new ScoreObserver();

    public Game(SearchFactory searchFactory) {
        this.searchFactory = searchFactory;
        //set up strategies
        strategies.add(new HorizontalStrategy());
        strategies.add(new VerticalStrategy());
        strategies.add(new DiagonalStrategy());

        //set up observers
        observers.add(listObserver);
        observers.add(scoreObserver);
    }
    public void startGame() {
        this.board = searchFactory.createBoard();
        this.words = board.getWords();
        for (Word w : words) {
            w.setFoundState(false);
        }
    }

    public Board getBoard() {
        return board;
    }

    public List<Word> getWords() {
        return words;
    }

    public boolean wordExists (String selected)
    {
        for (Word word : this.board.getWords()) {
            if (!word.isFound() && word.getWord().equals(selected) ){
                // If a specific strategy is set, use only that one.
                if (strategy != null) {
                    if (strategy.search(board, word)) {
                        handleWordFound(word);
                        return true;
                    }
                } else {
                    // Otherwise, try all strategies (horizontal, vertical, diagonal)
                    for (SearchTemplate st : strategies) {
                        if (st.search(board, word)) {
                            handleWordFound(word);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    //Called when a word has been confirmed found in the grid.

    private void handleWordFound(Word word) {
        // mark word as found in the model
        word.setFoundState(true);

        // update global game state
        GameStateManager.getInstance().markWordFound(word);

        // notify all observers (list + score)
        notifyObservers(word);
    }

    private void notifyObservers(Word word) {
        for (IObserver observer : observers) {
            observer.update(word);
        }
    }



    public void setStrategy (SearchTemplate strategy) {
        this.strategy = strategy;
    }

    // Expose observers for controllers / state endpoint
    public ListObserver getListObserver() {
        return listObserver;
    }

    public ScoreObserver getScoreObserver() {
        return scoreObserver;
    }

}
