package com.example.demo.controller;


import com.example.demo.pojo.*;
import com.example.demo.service.ArticleService;
import com.example.demo.service.ClassifyService;
import com.example.demo.service.TagService;
import com.example.demo.service.UserService;
import com.example.demo.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@ResponseBody
@CrossOrigin
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    ClassifyService classifyService;

    @Autowired
    TagService tagService;

    //根据Id获取文章， tags是字符串
    @RequestMapping("getArticleByIdTwo")
    public ServerResponse getArticleByIdTwo(@RequestParam("id") int id){
        Article article = articleService.getArticle(id);
//        ArticleVO articleVO = articleService.transformArticleVO(article);
        return ServerResponse.createBySuccess("文章获取成功",article);
    }
    //根据月份返回文章
    @RequestMapping("getArticleByMonth")
    public ServerResponse getArticleByMonth(@RequestParam("month") String month){
//        List<Article> list = articleService.getAllArticle();
//
//        List<ArticleVO> list2 = new LinkedList<ArticleVO>();
//        for(Article article : list){
//            ArticleVO articleVO = articleService.transformArticleVO(article);
//            articleVO.setTime(articleVO.getTime().substring(0,10));
//            articleVO.setAuthor(userService.getUserById(article.getAuthor()).getUsername());
//            String s = articleVO.getTime().substring(0,10);
//            if(s.startsWith(month)){
//                list2.add(articleVO);
//            }
//        }
//        Collections.reverse(list2);
//        return ServerResponse.createBySuccess("成功获取文章",list2);

          List<ArticleNoContent> list = articleService.getAllArticle2();
          List<ArticleNoContentVO> list2 = new LinkedList<ArticleNoContentVO>();
          for(ArticleNoContent articleNoContent: list){
              ArticleNoContentVO articleNoContentVO = articleService.transformArticleNoContentVO(articleNoContent);
              articleNoContentVO.setTime(articleNoContentVO.getTime().substring(0,10));
              articleNoContentVO.setAuthor("shenmafuyun");
              String s = articleNoContentVO.getTime().substring(0,10);
              if(s.startsWith(month)){
                  list2.add(articleNoContentVO);
              }

          }
          Collections.reverse(list2);
          return ServerResponse.createBySuccess("成功获取文章",list2);
    }

    //收集月份
    @RequestMapping("getMonth")
    public ServerResponse getMonth(){
//        List<Article> list = articleService.getAllArticle();
//        List<String> list2 = new LinkedList<String>();
//        for(Article article: list){
//            ArticleVO articleVO = articleService.transformArticleVO(article);
//            String s = articleVO.getTime().substring(0,7);
//            if(list2.indexOf(s) == -1){
//                list2.add(s);
//            }
//        }
//        Collections.reverse(list2);
//        return ServerResponse.createBySuccess("成功获取月份",list2);
//

        List<ArticleNoContent> list1 = articleService.getAllArticle2();
        List<String> list2 = new LinkedList<String>();
        for(ArticleNoContent articleNoContent:  list1){
            ArticleNoContentVO articleNoContentVO = articleService.transformArticleNoContentVO(articleNoContent);
            String s = articleNoContentVO.getTime().substring(0,7);
            if(list2.indexOf(s) == -1){
                list2.add(s);
            }
        }
        Collections.reverse((list2));
        return ServerResponse.createBySuccess("成功获取月份",list2);
    }

    //根据文章题目和内容判断是否有这个字段
    @RequestMapping(value ="getArticleByContent", method = RequestMethod.POST)
    public ServerResponse getArticleByContent(@RequestBody Map<String,Object> map){
//        String s = map.get("content").toString();
//        List<Article> list = articleService.getAllArticle();
//        List<ArticleVO> list2 = new LinkedList<ArticleVO>();
//        for(Article article: list){
//            String s1 = article.getContent();
//            String s2 = article.getTitle();
//            if(s1.indexOf(s) != -1 || s2.indexOf(s) != -1){
//                ArticleVO articleVO = articleService.transformArticleVO(article);
//                articleVO.setTime(articleVO.getTime().substring(0,10));
//                articleVO.setAuthor(userService.getUserById(article.getAuthor()).getUsername());
//                list2.add(articleVO);
//            }
//        }
//        return ServerResponse.createBySuccess("成功获取数据",list2);



        String s = map.get("content").toString();
        List<ArticleNoContent> list1 = articleService.getAllArticle2();
        List<ArticleNoContentVO> list2 = new LinkedList<ArticleNoContentVO>();
        for(ArticleNoContent articleNoContent :  list1){
            String s1 = articleNoContent.getTitle();
            if(s1.indexOf(s) != -1){
                ArticleNoContentVO articleNoContentVO = articleService.transformArticleNoContentVO(articleNoContent);
                list2.add(articleNoContentVO);
            }
        }
        return ServerResponse.createBySuccess("成功获取数据",list2);
    }


    //根据Tag获取文章
    @RequestMapping(value = "getArticleByTag",method = RequestMethod.POST)
    public ServerResponse getArticleByTag(@RequestBody Map<String,Object> map){
//        String tag = map.get("tagname").toString();
//
//        List<Article> list2 = articleService.getAllArticle();
//        List<ArticleVO> list3 = new LinkedList<ArticleVO>();
//        for(Article article: list2){
//            List<String> list = Arrays.asList(article.getTag().split(","));
//            if(list.indexOf(tag) != -1){
//                ArticleVO articleVO = articleService.transformArticleVO(article);
//                articleVO.setTime(articleVO.getTime().substring(0,10));
//                articleVO.setAuthor(userService.getUserById(article.getAuthor()).getUsername());
//                list3.add(articleVO);
//            }
//        }
//        return ServerResponse.createBySuccess("成功获取数据",list3);


        String tag = map.get("tagname").toString();
        List<ArticleNoContent> list1 = articleService.getAllArticle2();
        List<ArticleNoContentVO> list2 = new LinkedList<ArticleNoContentVO>();
        for(ArticleNoContent articleNoContent : list1){
            List<String> list = Arrays.asList(articleNoContent.getTag().split(","));
            if(list.indexOf(tag) != -1){
                ArticleNoContentVO articleNoContentVO = articleService.transformArticleNoContentVO(articleNoContent);
                list2.add(articleNoContentVO);
            }
        }
        return ServerResponse.createBySuccess("成功获取数据",list2);
    }
    //根据Pagenum和pagesize选择文章
    @RequestMapping("getArticleByPageNum")
    public ServerResponse getArticleByPageNum(@RequestParam("pagenum") int pagenum, @RequestParam("pagesize") int pagesize){
        List<Article> list = articleService.getAllArticle();
        Collections.reverse(list);
        List<ArticleVO> list2 = new LinkedList<ArticleVO>();

        for(int i = (pagenum-1)*pagesize ; i < pagenum * pagesize; ++i){
            if(i >= list.size())break;
//            System.out.println(i);
            Article article = list.get(i);
            ArticleVO articleVO = articleService.transformArticleVO(article);
            articleVO.setTime(articleVO.getTime().substring(0,10));
            articleVO.setAuthor(userService.getUserById(article.getAuthor()).getUsername());
            list2.add(articleVO);
        }
        Map<String,Object>map = new HashMap<String, Object>();
        map.put("article",list2);
        map.put("total",list.size());
        return ServerResponse.createBySuccess("成功获取数据", map);
    }

    @RequestMapping("getArticleByPageNumRightContent")
    public ServerResponse getArticleByPageNumRightContent(@RequestParam("pagenum") int pagenum, @RequestParam("pagesize") int pagesize){
        List<ArticleNoContent> list = articleService.getAllArticle2();
        Collections.reverse(list);
        List<ArticleNoContentVO> list2 = new LinkedList<ArticleNoContentVO>();

        for(int i = (pagenum-1)*pagesize ; i < pagenum * pagesize; ++i){
            if(i >= list.size())break;


            ArticleNoContent articleNoContent = list.get(i);
            ArticleNoContentVO articleNoContentVO = articleService.transformArticleNoContentVO(articleNoContent);
            articleNoContentVO.setTime(articleNoContentVO.getTime().substring(0,10));
            articleNoContentVO.setAuthor("shenmafuyun");


           // articleVO.setAuthor(userService.getUserById(article.getAuthor()).getUsername());
            list2.add(articleNoContentVO);
        }
        Map<String,Object>map = new HashMap<String, Object>();
        map.put("article",list2);
        map.put("total",list.size());
        return ServerResponse.createBySuccess("成功获取数据", map);
    }
    @RequestMapping("addArticle")
    public ServerResponse addArticle(@RequestBody Map<String,Object>map){
        String title = map.get("title").toString();
        String tag = map.get("tags").toString();
        String classify = map.get("classify").toString();
        String content = map.get("content").toString();
        Classify classify1 = classifyService.haveClassify(classify);
        if(classify1 == null){
//            System.out.println("没有这个分类");
            classifyService.addClassify(classify);
        }
        List<String> list = Arrays.asList(tag.split(","));
        for(String s: list){
            //判断是否有这个标签
            Tag tag1 = tagService.haveTag(s);
            if(tag1 == null){
                tagService.addTag(s);
            }
        }
        Date date = new Date();
        int num = articleService.addArticle(title,tag, classify, content,date,0 );
        if(num > 0){
            return ServerResponse.createBySuccess("成功添加文章",null);
        }
        else return ServerResponse.createByError("添加文章失败");
    }
    @RequestMapping("updateArticle")
    public ServerResponse updateArticle(@RequestBody Map<String,Object>map){

        int id = Integer.parseInt(map.get("id").toString());
        String title = map.get("title").toString();
        String tag = map.get("tags").toString();
        String classify = map.get("classify").toString();
        String content = map.get("content").toString();
//        System.out.println("haha");
        Classify classify1 = classifyService.haveClassify(classify);
        if(classify1 == null){
//            System.out.println("没有这个分类");
            classifyService.addClassify(classify);
        }
        List<String> list = Arrays.asList(tag.split(","));
        for(String s: list){
            //判断是否有这个标签
            Tag tag1 = tagService.haveTag(s);
            if(tag1 == null){
                tagService.addTag(s);
            }
        }
        int num = articleService.updateArticle(id, title, tag, classify, content);
        if(num > 0){
            return ServerResponse.createBySuccess("成功更新",null);
        }
        else{
            return ServerResponse.createByError("更新失败");
        }
    }
    @RequestMapping("getArticleById")
    public ServerResponse getArticleById(@RequestParam("id") int id){
        Article article = articleService.getArticle(id);
        ArticleVO articleVO = articleService.transformArticleVO(article);
        return ServerResponse.createBySuccess("文章获取成功",articleVO);
    }

//    @RequestMapping("getArticleVOById")
//    public ServerResponse getArticleVOById(@RequestParam("id") int id){
//        Article article = articleService.getArticle(id);
//        ArticleVO articleVO = articleService.transformArticleVO(article);
//        return ServerResponse.createBySuccess("文章获取成功",articleVO);
//    }
    @RequestMapping("getArticleVOById")
    public ServerResponse getArticleVOById(@RequestParam("id") int id){
        Article article = articleService.getArticle(id);
        ArticleTT articleTT = new ArticleTT();
        articleTT.setTitle(article.getTitle());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(article.getTime());
        articleTT.setTime(s);
        return ServerResponse.createBySuccess("文章获取成功",articleTT);
    }
    @RequestMapping("getAllArticle")
    public ServerResponse getAllArticle(){
        List<Article> list = articleService.getAllArticle();
        List<ArticleVO> list2 = new LinkedList<ArticleVO>();
        for(Article article: list){
            ArticleVO articleVO = articleService.transformArticleVO(article);
            articleVO.setTime(articleVO.getTime().substring(0,10));
            articleVO.setAuthor(userService.getUserById(article.getAuthor()).getUsername());
            list2.add(articleVO);
        }
//        Collections.reverse(list2);
        return ServerResponse.createBySuccess("成功获取数据", list2);
    }


    @RequestMapping("deleteArticle")
    public ServerResponse deleteArticle(@RequestParam("id") int id){

        Article article = articleService.getArticle(id);
        String name = article.getClassify();
        List<Article> list = articleService.getAllArticle();
        int flag = 0;
        for(Article article1 : list){
            if(article1.getId() == id)continue;
            if(article1.getClassify().equals(name)){
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            classifyService.deleteClassify(name);
        }


        int num = articleService.deleteArticle(id);
        if(num > 0){
            return ServerResponse.createBySuccess("成功删除",null);
        }
        else
            return ServerResponse.createByError("删除失败");

    }
//    @RequestMapping("getArticle")
//    public ServerResponse getArticle(@RequestParam("article") String article){
//        List<String> list = Arrays.asList(article.split(","));
//
//        List<ArticleVO> list2  = new LinkedList<ArticleVO>();
//        for(String s: list){
//            Article article1 = articleService.getArticle(Integer.parseInt(s));
//
//            //将文章进行转换类
//            ArticleVO articleVO = new ArticleVO();
//            articleVO = articleService.transformArticleVO(article1);
//            articleVO.setTime(articleVO.getTime().substring(0,10));
//            list2.add(articleVO);
//        }
//        System.out.println(list2.size());
//        return ServerResponse.createBySuccess("文章列表获取成功",list2);
//    }


    @RequestMapping(value="getArticleByClassify", method = RequestMethod.POST)
    public ServerResponse getArticleByClassify(@RequestBody Map<String,Object> classify){

        String s = classify.get("classify").toString();
        int pagenum = Integer.parseInt(classify.get("pagenum").toString());
        int pagesize = Integer.parseInt(classify.get("pagesize").toString());
//        System.out.println(s);
        List<Article> article = articleService.getArticleByClassify(s);
        List<ArticleVO> articleVOList = new LinkedList<ArticleVO>();
        if(article == null){
            return ServerResponse.createBySuccess("没有数据", null);
        }
        for(Article article1: article){

            ArticleVO articleVO = articleService.transformArticleVO(article1);

            articleVO.setAuthor(userService.getUserById(article1.getAuthor()).getUsername());
            articleVOList.add(articleVO);
        }
        List<ArticleVO> list3 = new LinkedList<ArticleVO>();
        for( int i = (pagenum - 1) * pagesize; i < pagenum * pagesize; ++i){
            if(i >= articleVOList.size())break;
            list3.add(articleVOList.get(i));
        }
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("article",list3);
        map.put("total",articleVOList.size());
        return ServerResponse.createBySuccess("成功获取文章",map);
    }
}
