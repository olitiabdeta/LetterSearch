package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("englishVocabMediumFactory")
public class MediumEnglishVocabFactory extends SearchFactory {

    @Override
    public List<Word> getWords() {
        if (words == null) {
            words =List.of(
                    new Word("ELOQUENT", false),
                    new Word("PERSPICACIOUS", false),
                    new Word("CONSCIOUS", false),
                    new Word("LUMINOUS", false),
                    new Word("METICULOUS", false),
                    new Word("AMBIGUOUS", false)
            );
        }
        return words;
    }
    private List<Word> words;

}