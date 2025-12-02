package com.finalproject.lettersearch.data;

public class Word {
    private final String word;
    private boolean found;

    public Word(String word, boolean found) {
        this.word = word;
        this.found = false;
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