package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("englishVocabHardFactory")
public class HardEnglishVocabFactory extends SearchFactory {

    @Override
    public List<Word> getWords() {
        if (words == null) {
            words = List.of(
                    new Word("INEVITABLE", false),
                    new Word("INTRICATE", false),
                    new Word("RESILIENT", false),
                    new Word("SOPHISTICATED", false),
                    new Word("CONTRADICTION", false),
                    new Word("CONSEQUENCE", false)
            );
        }
        return words;
    }
    private List<Word> words;
}
