package com.martins.ytconv.YT_Converter.controller;

import com.martins.ytconv.YT_Converter.service.VideoDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/download")
public class VideoDownloadController {

    @Autowired
    private VideoDownloadService videoDownloadService;

    @PostMapping
    public ResponseEntity<String> downloadVideo(@RequestParam String url) {
        try{
            String result = videoDownloadService.downloadVideo(url);
            return ResponseEntity.ok(result);
        } catch (IOException e){
            return ResponseEntity.status(500).body("Erro ao baixar o vídeo: " + e.getMessage());
        }
    }

}
