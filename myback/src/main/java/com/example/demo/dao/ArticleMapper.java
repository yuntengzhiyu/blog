package com.example.demo.dao;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.ArticleNoContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ArticleMapper {
    //通过文章id获取文章
    Article getArticle(@Param("id") int id);

    //获取全部文章，但是不获取文章内容
    List<ArticleNoContent> getAllArticle2();

    //通过文章分类获取文章
    List<Article> getArticleByClassify(@Param("classify") String classify);

   //获取全部文章
    List<Article> getAllArticle();

    //根据id删除文章
    int deleteArticle(@Param("id") int id);


    //更新文章
    int updateArticle(@Param("id") int id, @Param("title") String title, @Param("tag") String tag , @Param("classify") String classify, @Param("content") String content);


    //添加文章
    int addArticle(@Param("title") String title, @Param("tag") String tag , @Param("classify") String classify, @Param("content") String content ,@Param("time") Date time,@Param("author") int author);




}
