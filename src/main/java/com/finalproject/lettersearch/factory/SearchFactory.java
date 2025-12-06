package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class SearchFactory {

    protected final Random random = new Random();

    protected abstract List<Word> getWords();

    protected int rows = 12;
    protected int cols = 12;

   public Board createBoard() {
       char[][] grid = new char[rows][cols];

       for (int r = 0; r < rows; r++) {
           for (int c = 0; c < cols; c++) {
               grid[r][c] = ' '; // blank for now
           }
       }

       List<Word> originalWords = getWords();

       List<Word> copyWords = new ArrayList<>();
       for (Word w : originalWords) {
           Word copy = new Word(w.getWord(), false);
           copyWords.add(copy);
       }

       for (Word word : copyWords) {
           placeWordRandomly(grid, word);
       }

       fillEmptySpaces(grid);

       return new Board(grid, copyWords);
   }


    private void placeWordRandomly(char[][] grid, Word word) {
        boolean placed = false;
        int attempts = 0;

        while (!placed && attempts < 100) {
            attempts++;
            Direction dir = Direction.randomDirection();
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if (canPlaceWord(grid, word.getWord(), row, col, dir)) {
                placeWord(grid, word.getWord(), row, col, dir, word);
                placed = true;
            }
        }

        if (!placed) {
            System.out.println("Failed to place word: " + word.getWord());
        }
    }

    private boolean canPlaceWord(char[][] grid, String word, int row, int col, Direction dir) {
        int len = word.length();

        switch (dir) {
            case HORIZONTAL:
                if (col + len > cols) return false;
                for (int i = 0; i < len; i++)
                    if (grid[row][col + i] != ' ' && grid[row][col + i] != word.charAt(i)) return false;
                break;
            case VERTICAL:
                if (row + len > rows) return false;
                for (int i = 0; i < len; i++)
                    if (grid[row + i][col] != ' ' && grid[row + i][col] != word.charAt(i)) return false;
                break;
            case DIAGONAL:
                if (row + len > rows || col + len > cols) return false;
                for (int i = 0; i < len; i++)
                    if (grid[row + i][col + i] != ' ' && grid[row + i][col + i] != word.charAt(i)) return false;
                break;
        }
        return true;
    }

    private void placeWord(char[][] grid, String word, int row, int col, Direction dir, Word obj) {
        for (int i = 0; i < word.length(); i++) {
            switch (dir) {
                case HORIZONTAL -> {
                        grid[row][col + i] = word.charAt(i);
                        obj.setPositions(row, col + i);
                }
                case VERTICAL -> {
                    grid[row + i][col] = word.charAt(i);
                    obj.setPositions(row +i, col);

                }
                case DIAGONAL ->{
                    grid[row + i][col + i] = word.charAt(i);
                    obj.setPositions(row + i, col + i);
                }
            }
        }
    }

    private void fillEmptySpaces(char[][] grid) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ' ') {
                    grid[r][c] = (char) ('A' + random.nextInt(26));
                }
            }
        }
    }

    private enum Direction {
        HORIZONTAL, VERTICAL, DIAGONAL;

        private static final Direction[] VALUES = values();
        private static final int SIZE = VALUES.length;
        private static final Random RANDOM = new Random();

        public static Direction randomDirection()  {
            return VALUES[RANDOM.nextInt(SIZE)];
        }
    }
}
