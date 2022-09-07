package edu.springboot.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Yelf
 * @create 2022-09-04-16:25
 */
@Slf4j
@Controller
public class FromTestController {
    @GetMapping("/form_layouts")
    public String fromLayouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email")String email,
                         @RequestParam("username")String userName,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {
        log.info("email={},username={},headerImgSize={},photos={}",email,userName,headerImg.getSize(),photos.length);

        if (!headerImg.isEmpty()) {
            String filename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\Users\\Yefl\\Desktop\\java\\IdeaProjects\\boot-05-web-admin\\src\\main\\resources\\static\\upload\\" + filename));
        }
        if (photos.length>0){
            for (MultipartFile photo:photos){
                String photofilename = photo.getOriginalFilename();
                photo.transferTo(new File("E:\\Users\\Yefl\\Desktop\\java\\IdeaProjects\\boot-05-web-admin\\src\\main\\resources\\static\\upload\\photos\\"+photofilename));
            }
        }
        return "main";
    }
}
