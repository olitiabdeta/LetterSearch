package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("statesFactory")
public class StatesSearchFactory extends SearchFactory {

    @Override
    public List<Word> getWords() {
        if (words == null) {
            words =List.of(
                    new Word("COLORADO", false),
                    new Word("TEXAS", false),
                    new Word("FLORIDA", false),
                    new Word("NEVADA", false),
                    new Word("ARIZONA", false),
                    new Word("CALIFORNIA", false)
            );
        }
        return words;
    }
    private List<Word> words;

}

