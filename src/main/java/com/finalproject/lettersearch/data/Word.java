package com.finalproject.lettersearch.data;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final String word;
    private boolean found;
    private List<int[]> positions = new ArrayList<>();
    public Word(String word, boolean found) {
        this.word = word;
        this.found = found;
    }
   public List<int[]> getPositions() {
        return positions;
    }
    public void setPositions(int row, int col) {
        positions.add(new int[]{row, col});
    }
    public String getWord() {
        return word;
    }

    public boolean isFound() {
        return found;
    }

    public void setFoundState(boolean found) {
        this.found = found;
    }
}