package com.wordcloud.core.controller;

import com.wordcloud.core.model.Word;
import com.wordcloud.core.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

@Controller
public class DBController {

    @Autowired
    private WordRepository wordRepository;

    public ResponseEntity<HashMap<String, Integer>> getWordsByIdentifier(String identifier) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        List<Word> words = wordRepository.findByIdentifier(identifier);
        for (Word word : words) {
            hashMap.put(word.getWordName(), word.getCount());
        }
        return ResponseEntity.ok().body(hashMap);
    }
}
