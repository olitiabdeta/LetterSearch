package com.finalproject.lettersearch.controller;

import com.finalproject.lettersearch.data.Word;
import com.finalproject.lettersearch.factory.SearchFactory;
import com.finalproject.lettersearch.service.Game;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.finalproject.lettersearch.data.Difficulty;
import org.springframework.web.bind.annotation.*;
import com.finalproject.lettersearch.service.GameStateManager;
import com.finalproject.lettersearch.data.Board;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class GameController {
    private Game game;
    private final Map<String, SearchFactory> factoryMap = new HashMap<>();
    private final Map<Difficulty, SearchFactory> vocabFactoryMap = new EnumMap<>(Difficulty.class);

    @Autowired
    public GameController(
            @Qualifier("dessertsFactory") SearchFactory dessertsFactory,
            @Qualifier("flowersFactory") SearchFactory flowersFactory,
            @Qualifier("statesFactory") SearchFactory statesFactory,
            @Qualifier("englishVocabEasyFactory") SearchFactory englishVocabEasyFactory,
            @Qualifier("englishVocabMediumFactory") SearchFactory englishVocabMediumFactory,
            @Qualifier("englishVocabHardFactory") SearchFactory englishVocabHardFactory
    ) {
        // themes without difficulty
        factoryMap.put("DESSERTS", dessertsFactory);
        factoryMap.put("FLOWERS", flowersFactory);
        factoryMap.put("STATES", statesFactory);

        // vocab + difficulty
        vocabFactoryMap.put(Difficulty.EASY, englishVocabEasyFactory);
        vocabFactoryMap.put(Difficulty.MEDIUM, englishVocabMediumFactory);
        vocabFactoryMap.put(Difficulty.HARD, englishVocabHardFactory);
    }


    @GetMapping("/start")
      public GameDTO start(@RequestParam String theme,
                           @RequestParam(required = false) Difficulty difficulty
    ) {
        SearchFactory factory;
        // If theme is vocab, choose factory by difficulty
        if ("VOCAB".equalsIgnoreCase(theme)) {
            if (difficulty == null) {
                difficulty = Difficulty.EASY; // default
            }
            factory = vocabFactoryMap.get(difficulty);
            if (factory == null) {
                throw new IllegalArgumentException("No vocab factory for difficulty " + difficulty);
            }
        } else {
            // Other themes (desserts, flowers, states...)
            factory = factoryMap.get(theme.toUpperCase());
            if (factory == null) {
                throw new IllegalArgumentException("Theme " + theme + " not found");
            }
        }

        game = new Game(factory);
        game.startGame();
        var board = game.getBoard();
        char[][] boardGrid = board.getBoard();
        List<Word> words = board.getWords();

        //Update global game state
        GameStateManager gsm = GameStateManager.getInstance();
        gsm.startNewGame(board, theme);
        return new GameDTO(boardGrid, words);

    }
    // Check if a selected word exists in the current puzzle and isn't already found.

    @GetMapping("/check")
    public CheckResultDTO check(@RequestParam String selected) {
        if (game == null) {
            throw new IllegalStateException("Game has not been started yet.");
        }

        boolean correct = game.wordExists(selected.toUpperCase());
        return new CheckResultDTO(selected, correct);
    }

    @GetMapping("/state")
    public GameStateDTO state() {
        if (game == null || game.getBoard() == null) {
            throw new IllegalStateException("Game has not been started yet.");
        }

        GameStateManager gsm = GameStateManager.getInstance();

        Board currentBoard = gsm.getCurrentBoard();
        String currentTheme = gsm.getCurrentTheme();

        // From observers
        List<String> foundWords = game.getListObserver().getFoundWords();
        int score = game.getScoreObserver().getScore();

        // From GameStateManager singleton
        List<Word> remainingWords = gsm.getWordsRemaining();

        char[][] boardGrid = currentBoard != null ? currentBoard.getBoard() : null;

        return new GameStateDTO(boardGrid, foundWords, remainingWords, currentTheme, score);
    }

    public static class GameStateDTO {
        private final char[][] board;
        private final List<String> foundWords;
        private final List<Word> remainingWords;
        private final String theme;
        private final int score;

        public GameStateDTO(char[][] board,
                            List<String> foundWords,
                            List<Word> remainingWords,
                            String theme,
                            int score) {
            this.board = board;
            this.foundWords = foundWords;
            this.remainingWords = remainingWords;
            this.theme = theme;
            this.score = score;
        }

        public char[][] getBoard() {
            return board;
        }

        public List<String> getFoundWords() {
            return foundWords;
        }

        public List<Word> getRemainingWords() {
            return remainingWords;
        }

        public String getTheme() {
            return theme;
        }

        public int getScore() {
            return score;
        }
    }


    public static class GameDTO{
        private final char[][] board;
        private final List<Word> words;
        public GameDTO(char[][] board, List<Word> words) {
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

    public static class CheckResultDTO {
        private final String selected;
        private final boolean correct;

        public CheckResultDTO(String selected, boolean correct) {
            this.selected = selected;
            this.correct = correct;
        }

        public String getSelected() {
            return selected;
        }

        public boolean isCorrect() {
            return correct;
        }
    }

}
