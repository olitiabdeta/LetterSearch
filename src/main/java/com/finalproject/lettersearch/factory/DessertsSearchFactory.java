package com.finalproject.lettersearch.factory;

import com.finalproject.lettersearch.data.Board;
import com.finalproject.lettersearch.data.Word;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("dessertsFactory")
public class DessertsSearchFactory extends SearchFactory {

    @Override
    public List<Word> getWords() {
        if (words == null){
            words = List.of(
                    new Word("CAKE", false),
                    new Word("PIE", false),
                    new Word("BROWNIE", false),
                    new Word("DONUT", false),
                    new Word("COOKIE", false),
                    new Word("TIRAMISU", false)
            );


        }
        return words;
    }
    private List<Word> words;

}
