package com.example.memo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String title;
    private String content;

    public Memo(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Memo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Memo() {

    }
}
