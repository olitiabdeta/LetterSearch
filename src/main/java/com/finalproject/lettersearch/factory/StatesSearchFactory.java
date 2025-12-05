package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("statesFactory")
public class StatesSearchFactory extends SearchFactory {

    @Override
    public Board createBoard() {
        char[][] grid = new char[][]{
                {'C','O','L','O','R','A','D','O'},
                {'T','E','X','A','S','X','X','X'},
                {'F','L','O','R','I','D','A','X'},
                {'N','E','V','A','D','A','X','X'},
                {'A','R','I','Z','O','N','A','X'},
                {'C','A','L','I','F','O','R','N'},
                {'I','A','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X'},
        };

        List<Word> words = List.of(
                new Word("COLORADO", false),
                new Word("TEXAS", false),
                new Word("FLORIDA", false),
                new Word("NEVADA", false),
                new Word("ARIZONA", false),
                new Word("CALIFORNIA", false)
        );

        return new Board(grid, words);
    }
}

