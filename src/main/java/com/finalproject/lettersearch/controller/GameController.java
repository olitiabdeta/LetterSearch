package com.finalproject.lettersearch.controller;

import com.finalproject.lettersearch.data.Word;
import com.finalproject.lettersearch.factory.SearchFactory;
import com.finalproject.lettersearch.service.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class GameController {
    private Game game;
    private final Map<String, SearchFactory> factoryMap = new HashMap<>();

    @GetMapping("/start")
      public GameDTO start(String theme){
        SearchFactory factory = factoryMap.get(theme);
        if (factory==null){
            //error message
            throw new IllegalArgumentException("Theme " +theme+" not found");
        }
        game = new Game(factory);
        game.startGame();
        var board = game.getBoard();
        char[][] boardGrid = board.getBoard();
        List<Word> words = board.getWords();
        return new GameDTO( boardGrid,words);

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









}
