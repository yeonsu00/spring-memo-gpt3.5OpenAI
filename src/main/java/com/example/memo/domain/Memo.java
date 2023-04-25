package com.example.memo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Memo {
    private Long id;
    private String title;
    private String content;

    public Memo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
