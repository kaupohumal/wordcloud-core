package com.wordcloud.core.repository;

import com.wordcloud.core.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("SELECT w FROM Word w WHERE w.identifier = ?1")
    List<Word> findByIdentifier(String identifier);
}