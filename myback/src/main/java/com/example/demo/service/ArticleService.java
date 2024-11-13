package com.example.demo.service;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.ArticleNoContent;
import com.example.demo.pojo.ArticleNoContentVO;
import com.example.demo.pojo.ArticleVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ArticleService {

    ArticleNoContentVO transformArticleNoContentVO(ArticleNoContent articleNoContent);
    Article getArticle(@Param("id") int id);

    ArticleVO transformArticleVO(Article article);

    List<Article> getArticleByClassify(@Param("classify") String classify);

    List<ArticleNoContent> getAllArticle2();

    List<Article> getAllArticle();

    int deleteArticle(@Param("id") int id);

    int updateArticle(@Param("id") int id, @Param("title") String title, @Param("tag") String tag , @Param("classify") String classify, @Param("content") String content);

    int addArticle(@Param("title") String title, @Param("tag") String tag , @Param("classify") String classify, @Param("content") String content , @Param("time") Date time, @Param("author") int author);

}
