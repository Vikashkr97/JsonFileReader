package com.project.fileReader.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class ApplicationController {
    @GetMapping("/home")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome.html");
        return modelAndView;
    }
    @GetMapping("/error")
    public String restricted(){
        return "Error Occurred !";
    }
    @Value("${file.upload-dir}")
    String FILE_DIR;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        File myfile = new File(FILE_DIR+file.getOriginalFilename());
        myfile.createNewFile();
        FileOutputStream fo= new FileOutputStream(myfile);
        fo.write(file.getBytes());
        fo.close();
        return ResponseEntity.ok("File Uploaded Successfully !");
    }
}

