package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

import java.util.List;

// English vocabulary improvement theme (base class)
public abstract class VocabSearchFactory extends SearchFactory {
    @Override
    public Board createBoard() {
        char[][] grid = createGrid();
        List<Word> words = createWords();

        return new Board(grid, words);
    }

    // Each child class will implement these:
    protected abstract char[][] createGrid();

    protected abstract List<Word> createWords();
}
