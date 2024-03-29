package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        //예상데이터
        Article a = new Article(1L, "가가가가","1111");
        Article b = new Article(2L, "나나나나","2222");
        Article c = new Article(3L, "다다다다","3333");
        List<Article> expected =new ArrayList<Article>(Arrays.asList(a,b,c));

        //실제데이터
        List<Article> articles = articleService.index();
        //예쌍데이터와 실제데이터 비교검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_success() {
        Long id = 1L;
        Article expected =new Article(id, "가가가가","1111");
        Article article = articleService.show(id);
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_FAIL() {
        Long id = -1L;
        Article expected =null;
        Article article = articleService.show(id);
        assertEquals(expected, article);
    }
    @Transactional
    @Test
    void create_success() {
        String title = "가가가가";
        String content = "1111";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(1L, title, content);

        Article article = articleService.create(dto);

        assertEquals(expected.toString(), article.toString());
    }
    @Transactional
    @Test
    void create_fail() {
        String title = "가가가가";
        String content = "1111";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = null;

        Article article = articleService.create(dto);

        assertEquals(expected, article);
    }
}