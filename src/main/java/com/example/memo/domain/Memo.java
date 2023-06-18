package com.example.memo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private LocalDateTime date;

    public Memo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Memo(String title, String content, LocalDateTime date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Memo() {

    }
}
