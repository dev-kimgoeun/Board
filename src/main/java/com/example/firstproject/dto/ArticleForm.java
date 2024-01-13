package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@ToString
public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity() {

        return new Article(null, title, content);
    }
}
