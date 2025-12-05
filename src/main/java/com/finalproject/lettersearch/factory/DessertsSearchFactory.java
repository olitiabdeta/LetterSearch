package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dessertsFactory")
public class DessertsSearchFactory extends SearchFactory {

    @Override
    public Board createBoard() {
        char[][] grid = new char[][]{
                {'C','A','K','E','X','X','X','X'},
                {'P','I','E','X','X','X','X','X'},
                {'B','R','O','W','N','I','E','X'},
                {'D','O','N','U','T','X','X','X'},
                {'C','O','O','K','I','E','X','X'},
                {'T','I','R','A','M','I','S','U'},
                {'X','X','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X'},
        };

        List<Word> words = List.of(
                new Word("CAKE", false),
                new Word("PIE", false),
                new Word("BROWNIE", false),
                new Word("DONUT", false),
                new Word("COOKIE", false),
                new Word("TIRAMISU", false)
        );

        return new Board(grid, words);
    }
}
