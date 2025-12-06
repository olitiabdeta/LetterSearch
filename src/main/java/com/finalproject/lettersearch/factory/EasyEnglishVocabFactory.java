package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("englishVocabEasyFactory")
public class EasyEnglishVocabFactory extends SearchFactory {

    @Override
    public List<Word> getWords() {
        if (words == null) {
            words = List.of(
                    new Word("ANALOGY", false),
                    new Word("CONTEXT", false),
                    new Word("PHRASE", false),
                    new Word("TOPIC", false),
                    new Word("AUTHOR", false),
                    new Word("STORY", false),
                    new Word("WORDS", false),
                    new Word("READING", false)
            );
        }
        return words;
    }
    private List<Word> words;

}
