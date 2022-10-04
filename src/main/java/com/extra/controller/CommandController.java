package com.extra.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.*;

@RestController
@RequestMapping("/command")
public class CommandController {

    @GetMapping()
    public String printContext() throws Exception {
        return "hello jenkins!";
//        BufferedReader reader = null;
//        String line = "";
//        try{
//            Process process = Runtime.getRuntime().exec("ifconfig");
//            int exitValue = process.waitFor();
//            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            while (reader.readLine() != null){
//                line += reader.readLine();
//                line += "\r\n";
//            }
//        }catch (Throwable e){
//            e.printStackTrace();
//        }
//        return line;


//        File file = new File("img/beauty.png");
//        InputStream inputStream = new FileInputStream(file);
//        byte []bytes = new byte[inputStream.available()];
//        inputStream.read(bytes, 0, inputStream.available());
//        return bytes;
    }
}
