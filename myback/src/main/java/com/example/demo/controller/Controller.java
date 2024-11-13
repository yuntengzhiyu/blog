package com.example.demo.controller;


//import com.alibaba.fastjson.JSONObject;
import com.example.demo.it.sauronsoftware.base64.Base64;
import com.example.demo.pojo.*;
import com.qiniu.util.Auth;
import com.example.demo.service.*;
import com.example.demo.util.ServerResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;

import java.util.*;


@org.springframework.stereotype.Controller
@ResponseBody
@CrossOrigin
public class Controller {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    ClassifyService classifyService;

    @Autowired
    TagService tagService;

    @Autowired
    FriendLinkService friendLinkService;

    @Autowired
    LiuyanService liuyanService;

    String f = "";
    String key = "";
    byte[] inputData ;



    @PostMapping("uploadResult")
    public ServerResponse upload(@RequestParam("file111") MultipartFile file) throws FileNotFoundException {
        String fileName = file.getOriginalFilename(); // 获取文件名
        String path = "d:/upload/" + fileName;
        File dest = new File("d:/upload/"+fileName);
        f = fileName;

        try{
            file.transferTo(dest);
        }catch(Exception e){
            ServerResponse.createByError("失败");
        }

        return ServerResponse.createBySuccess("成功",null);
    }

    @RequestMapping("jiami")
    public void jiami(HttpServletResponse response, HttpServletRequest request) throws Exception {


        key = AESUtils.getSecretKey();

        String sourceFilePath = "D:/upload/" + f;

        String content1 = txt.txt2String(new File(sourceFilePath));
        String content2 = txt.readTxt(sourceFilePath);
        inputData = content1.getBytes();

        inputData = AESUtils.encrypt(inputData,key);         //2进制进行加密


            String filePath = "D:/upload/encrypt.txt";
            String content = Base64Utils.encode(inputData);
            FileWriter fw = null;
            try
            {
                File file = new File(filePath);
                if (!file.exists())
                {
                    file.createNewFile();
                }
                fw = new FileWriter(filePath);
                fw.write(content);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    fw.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }


    }


    @RequestMapping("getUserByUsername")
    public ServerResponse getuserByusername(@RequestParam("username") String username){
        User user = userService.getUserByUsername(username);
        if(user == null) return ServerResponse.createBySuccess("成功",null);
        else return ServerResponse.createByError("失败");
    }

    @PostMapping("getencodefile")
    public void getCompResult(@RequestBody Map<String, String> map, HttpServletResponse response) throws Exception {
        String path = "D:/upload/encrypt.txt"; // 这里的path是文件存储的路径
        InputStream inputStream = new FileInputStream(path);
        response.reset();
        response.setContentType("application/octet-stream");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(map.get("resultfile"), "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = inputStream.read(b)) > 0){
            outputStream.write(b, 0, len);
        }
        inputStream.close();
    }

    @PostMapping("getdecodefile")
    public void getCompResult2(@RequestBody Map<String, String> map, HttpServletResponse response) throws Exception {
        String path = "D:/upload/decrypt.txt"; // 这里的path是文件存储的路径
        InputStream inputStream = new FileInputStream(path);
        response.reset();
        response.setContentType("application/octet-stream");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(map.get("resultfile"), "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while((len = inputStream.read(b)) > 0){
            outputStream.write(b, 0, len);
        }
        inputStream.close();
    }

    @RequestMapping("jiemi")
    public void jiemi() throws Exception {

        byte[] outputData = AESUtils.decrypt(inputData, key);

        String content = new String(outputData);
        String filePath = "D:/upload/decrypt.txt";
        String ss1 = "";

        for(int i = 2; i < content.length(); ++i){
            ss1 = ss1 + content.charAt(i);
        }
        System.out.println(ss1);
        content = ss1;
        FileWriter fw = null;
        try
        {
            File file = new File(filePath);
            if (!file.exists())
            {
                file.createNewFile();
            }
            fw = new FileWriter(filePath);
            fw.write(content);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fw.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

    }



    @RequestMapping("addUser")
    public ServerResponse addUser(@RequestParam("username") String username,@RequestParam("password") String password){
        System.out.println(username);
        int num = userService.addUser(username,password);
        if(num > 0) return ServerResponse.createBySuccess("成功",null);
        else return ServerResponse.createByError("失败");
    }
    //添加留言
    @RequestMapping(method = RequestMethod.POST ,value="addLiuyan")
    public ServerResponse addLiuyan(@RequestBody Map<String,Object> map){
        System.out.println(map.get("username").toString());
        String username = map.get("username").toString();
        String content = map.get("content").toString();
        Date date = new Date();
        int num = liuyanService.addLiuyan(username,content,date);
        if(num > 0) return ServerResponse.createBySuccess("成功",null);
        else return ServerResponse.createByError("失败");
    }


    @RequestMapping("getLiuyan")
    public ServerResponse getLiuyan(){
        List<Liuyan> list = liuyanService.getLiuyan();

        List<LiuyanVO> list2 = new LinkedList<LiuyanVO>();
        for(Liuyan liuyan: list){
            LiuyanVO liuyanVO = liuyanService.transform(liuyan);
            liuyanVO.setTime(liuyanVO.getTime().substring(0,10));
            list2.add(liuyanVO);
        }
        return ServerResponse.createBySuccess("成功获取数据",list2);

    }

    //更新用户背景
    @RequestMapping("updateUserBackground")
    public ServerResponse updateUserBackground(@RequestParam("userbackground") String userbackground, @RequestParam("id") int id){
        int num = userService.updateUserbackground(userbackground, id);
        if(num > 0){
            return ServerResponse.createBySuccess("成功更新",null);
        }
        else return ServerResponse.createByError("更新失败");

    }
    @RequestMapping("updateUserStyle")
    public ServerResponse updateUserStyle(@RequestParam("id") int id, @RequestParam("userstyle") int userstyle){
        System.out.println(id);
        System.out.println(userstyle);
        int num = userService.updateUserStyle(userstyle,id);
        if(num > 0)
            return ServerResponse.createBySuccess("成功更新",null);
        else return ServerResponse.createByError("更新失败");
    }
    //获取userinfo中的信息
    @RequestMapping("getUserInfo")
    public ServerResponse getUserInfo(@RequestParam("id") int id){
        User user = userService.getUserById(id);
        List<Article> list = articleService.getAllArticle();
//        List<Tag> list2 = tagService.getAllTags();
        List<FriendLink> list2 = friendLinkService.getFriend();
        List<Classify> list3 = classifyService.getAllClassify();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user",user);
        System.out.println(list.size());
        map.put("articlenum",list.size());
//        map.put("tagnum",list2.size());
        map.put("friendnum",list2.size());
        map.put("classifynum", list3.size());
        return ServerResponse.createBySuccess("成功获取数据",map);
    }
//    @RequestMapping("getToken")
//    public ServerResponse getTOKEN(){
//        String accessKey = "xy5k0-6PjW6ErFlU2dPzoMFibd52mSn7WLZZsOuV";
//        String secretKey = "RjDl1vCviAo1B3IWbxiy7g3xfTB4gcLdrwSQSD0x";
//        String bucket = "pycode2";
//
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//
//        return ServerResponse.createBySuccess("成功获取token",upToken);
//    }

    @RequestMapping("getTagData")
    public ServerResponse getTagData(){
        List<Tag> list = tagService.getAllTags();
        List<Article> list2 = articleService.getAllArticle();
        List<TagData> list3 = new LinkedList<TagData>();
        for(Tag tag: list){
            String name = tag.getName();
            int count = 0;
            for(Article article : list2){
                String ss = article.getTag();
                List<String> list1 = Arrays.asList(ss.split(","));
                if(list1.indexOf(name) != -1){
                    count ++;
                }
            }
            TagData tagData = new TagData();
            tagData.setCount(count);
            tagData.setName(name);
            if(count != 0)
            list3.add(tagData);
        }
        return ServerResponse.createBySuccess("成功获取数据",list3);
    }
    @RequestMapping("getData")
    public ServerResponse getData(){
        List<Article> list = articleService.getAllArticle();
        List<FriendLink> list2 = friendLinkService.getFriend();
//        List<Tag> list3 = tagService.getAllTags();
        List<Classify> list3 = classifyService.getAllClassify();
        List<Integer> list4 = new LinkedList<Integer>();



        list4.add(list.size());
        list4.add(list2.size());
        list4.add(list3.size());
        return ServerResponse.createBySuccess("获取数据成功",list4);
    }

    @RequestMapping("getUserById")
    public ServerResponse getUserById(@RequestParam("id") int id){
//        System.out.println(id);
        User user = userService.getUserById(id);
        return ServerResponse.createBySuccess("用户数据",user);
    }

    @RequestMapping("login")
    public ServerResponse login(@RequestParam("username") String username ,@RequestParam("password") String password){
        User user = userService.getUser(username, password);
        if(user == null){
            System.out.println("没有这样的用户");
            return ServerResponse.createByError("没有这样的用户");
        }
        else{
            return ServerResponse.createBySuccess("登录成功", user);
        }
    }


    @RequestMapping("getImage/{id}")
    public ServerResponse getImage(HttpServletResponse response, @PathVariable("id") int id) throws IOException {
//        System.out.println(id);
        List<String> listFile = new ArrayList<String>();
        BufferedReader bw = null;
        try{
            ClassPathResource classPathResource;
            if(id == 0) {
                classPathResource = new ClassPathResource("images.txt");
            }
            else{
                classPathResource = new ClassPathResource("images1.txt");
            }
            bw = new BufferedReader(new FileReader(classPathResource.getFile()));
            String line;
            while((line = bw.readLine()) != null){
                listFile.add(line);
            }
        }catch(IOException e){
            System.out.println(e);
        }
        int num = (int)(Math.random() * listFile.size());
//        System.out.println("num" + listFile.size());
//        System.out.println(num);
        response.sendRedirect(listFile.get(num));
        return ServerResponse.createBySuccess("成功",null);
    }

}
