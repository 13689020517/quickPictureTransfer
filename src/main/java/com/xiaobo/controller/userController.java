package com.xiaobo.controller;

import com.xiaobo.bean.User;
import com.xiaobo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class userController {
    @Autowired
    IUserService iu;

    //注册并且上传头像文件
    @PostMapping("/registe")
    public String registe(@Valid User user, BindingResult result, MultipartFile uploadFile, Model model) throws IOException {
        user.setImgPath(uploadFile.getOriginalFilename());
        iu.save(user);
        model.addAttribute("msg","恭喜您注册成功,请登录吧~");
        uploadFile.transferTo(new File("D://uploadDir/"+uploadFile.getOriginalFilename()));
        return "login";
    }

    //检验用户名是否存在
    @GetMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(String username){
        List<User> all = iu.findAll();
        for (User user : all) {
            System.out.println(user.getName());
            if(user.getName().equals(username)){
               return "该用户名存在";
            }
        }
        if(username != ""){
            return "该用户名不存在";
        }else{
            return "用户名不能为空";
        }
    }

    //登录
    @PostMapping("/toLogin")
    public String login(String name,String password,Model model){
        List<User> all = iu.findAll();
        for (User user : all) {
            if(user.getName().equals(name)&user.getPassword().equals(password)){
                model.addAttribute("msg",name);
               return "index";
            }
        }
        model.addAttribute("msg","登录失败，用户名或者密码错误");
        return "login";
    }

    @RequestMapping("/loginUI")
    public String loginUI(){
        return "login";
    }

}
