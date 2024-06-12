package com.martins.ytconv.YT_Converter.service;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class VideoDownloadService {

    private static final String DOWNLOAD_DIRECTORY = "downloads/";
    private static final String YT_DLP_EXECUTABLE = "F:\\Python\\Python3\\Scripts\\yt-dlp";

    public String downloadVideo(String videoUrl) throws IOException {
        String command = YT_DLP_EXECUTABLE + " -o " + DOWNLOAD_DIRECTORY + "%(title)s.%(ext)s " + videoUrl;

        CommandLine cmdLine = CommandLine.parse(command);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);

        int exitValue = executor.execute(cmdLine);

        if(exitValue == 0) {
            return "Download concluído com sucesso.";
        }
        else {
            throw new IOException("Falha no download do vídeo.");
        }
    }

}
