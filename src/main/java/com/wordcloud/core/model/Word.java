package com.wordcloud.core.model;

import javax.persistence.*;

@Entity
@Table(name = "words", schema = "migrations")
public class Word {

    private long id;
    private String identifier;
    private String wordName;
    private int count;

    public Word() {

    }

    public Word(String identifier, String wordName, int count) {
        this.identifier = identifier;
        this.wordName = wordName;
        this.count = count;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "identifier", nullable = false)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Column(name = "wordname", nullable = false)
    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
