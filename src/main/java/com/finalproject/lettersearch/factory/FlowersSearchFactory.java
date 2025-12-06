package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("flowersFactory")
public class FlowersSearchFactory extends SearchFactory {
    @Override
    public List<Word> getWords() {

        if (words == null) {
            words = List.of(
                    new Word("ROSE", false),
                    new Word("LILY", false),
                    new Word("TULIP", false),
                    new Word("DAISY", false),
                    new Word("ORCHID", false)
            );
        }
        return words;
    }

    private List<Word> words;

}
