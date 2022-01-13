package com.study.boot05webadmin.controller;

import com.study.boot05webadmin.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @author Bao
 * @time 2022/1/8 21:46
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping(value = {"/", "login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("login", user);
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    @GetMapping("/index.html")
    public String mainPage(HttpSession session, Model model) {
//        // 判断是否登录
//        User login = (User) session.getAttribute("login");
//        if (login == null) {
//            model.addAttribute("msg", "请登录后访问");
//            return "login";
//        }

        return "index";
    }

    @GetMapping("/form_layouts.html")
    public String toForm_layoutsPage() {
        return "form_layouts";
    }

    @PostMapping("/upload")
    public String toUpload(@RequestParam("email") String email,
                           @RequestParam("password") String password,
                           @RequestPart("headerImg") MultipartFile headerImg,
                           @RequestPart("photos") MultipartFile[] photos) {

        log.info("上传的信息:email={}, password={}, headerImg={}, photos={}",
                email, password, headerImg.getSize(), photos.length);
        return "index";
    }

}
