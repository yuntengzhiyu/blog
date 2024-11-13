package com.example.demo.service;

import com.example.demo.dao.ArticleMapper;
import com.example.demo.pojo.Article;
import com.example.demo.pojo.ArticleNoContent;
import com.example.demo.pojo.ArticleNoContentVO;
import com.example.demo.pojo.ArticleVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleMapper articleMapper;


    public ArticleNoContentVO transformArticleNoContentVO(ArticleNoContent articleNoContent) {
        ArticleNoContentVO articleNoContentVO = new ArticleNoContentVO();

        articleNoContentVO.setId(articleNoContent.getId());
        articleNoContentVO.setClassify(articleNoContent.getClassify());
        articleNoContentVO.setAuthor(articleNoContent.getAuthor());
        articleNoContentVO.setTag(Arrays.asList(articleNoContent.getTag().split(",")));
        articleNoContentVO.setTitle(articleNoContent.getTitle());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(articleNoContent.getTime());
        articleNoContentVO.setTime(s);
        return articleNoContentVO;
    }

    public Article getArticle(int id) {
        return articleMapper.getArticle(id);
    }

    public ArticleVO transformArticleVO(Article article) {
        ArticleVO articleVO = new ArticleVO();
        articleVO.setId(article.getId());
        articleVO.setClassify(article.getClassify());
        articleVO.setComments(article.getComments());
        articleVO.setContent(article.getContent());
        articleVO.setLike(article.getLike());
        articleVO.setTag(Arrays.asList(article.getTag().split(",")));
        articleVO.setTitle(article.getTitle());
        articleVO.setView(article.getView());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(article.getTime());
        articleVO.setTime(s);
        return articleVO;
    }

    public List<Article> getArticleByClassify(String classify) {
        return articleMapper.getArticleByClassify(classify);
    }

    public List<ArticleNoContent> getAllArticle2() {
        return articleMapper.getAllArticle2();
    }



    public List<Article> getAllArticle() {
        return articleMapper.getAllArticle();
    }

    public int deleteArticle(int id) {
        return articleMapper.deleteArticle(id);
    }

    public int updateArticle(int id, String title, String tag, String classify, String content) {
        return articleMapper.updateArticle(id, title, tag, classify, content);
    }

    public int addArticle(String title, String tag, String classify, String content, Date time, int author) {
        return articleMapper.addArticle(title, tag, classify, content, time , author);
    }

}
