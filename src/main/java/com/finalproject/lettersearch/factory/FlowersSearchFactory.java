package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("flowersFactory")
public class FlowersSearchFactory extends SearchFactory {

    @Override
    public Board createBoard() {
        char[][] grid = new char[][]{
                {'R','O','S','E','X','X','X','X'},
                {'L','I','L','Y','X','X','X','X'},
                {'T','U','L','I','P','X','X','X'},
                {'D','A','I','S','Y','X','X','X'},
                {'O','R','C','H','I','D','X','X'},
                {'X','X','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X'},
                {'X','X','X','X','X','X','X','X'},
        };

        List<Word> words = List.of(
                new Word("ROSE", false),
                new Word("LILY", false),
                new Word("TULIP", false),
                new Word("DAISY", false),
                new Word("ORCHID", false)
        );

        return new Board(grid, words);
    }
}
