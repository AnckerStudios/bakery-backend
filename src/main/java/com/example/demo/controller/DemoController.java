package com.example.demo.controller;

import com.example.demo.dto.CategoryPojo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.tools.JavaFileManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private Path path = Paths.get("uploads");
    @GetMapping()
    public int count() {
        System.out.println("saaaaaaaaaa");
        return  2;
    }

    @PostMapping
    public void createProduct(@RequestBody String file) throws IOException {
        System.out.println("file"+ file);
        //Files.copy(file.getInputStream(), this.path.resolve(file.getOriginalFilename()));
    }
}
