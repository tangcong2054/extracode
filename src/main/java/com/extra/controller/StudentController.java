package com.extra.controller;

import com.extra.utils.MyUserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.*;

import javax.swing.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public String printText() throws Exception {
        System.out.println("connecting!");
        JSch jsch = new JSch();
        //jsch.setKnownHosts("C:\\Users\\XXX\\.ssh\\known_hosts");
        String host = "222.20.73.217";
        int port = 22;
        String user = "tanon";
        Session session = jsch.getSession(user, host, 22);
        String passwd = "123456";
        session.setPassword(passwd);
        session.setUserInfo(new MyUserInfo());
        session.connect(30000);
        Channel channel = session.openChannel("shell");
        //((ChannelShell)channel).setAgentForwarding(true);
        //使用Window的问题
        InputStream in = null;
        in = channel.getInputStream();
        channel.connect();
        OutputStream os = null;
        os = channel.getOutputStream();
        os.write("ifconfig\r\n".getBytes(StandardCharsets.UTF_8));
        os.flush();
        os.write("exit\r\n".getBytes(StandardCharsets.UTF_8));
        os.flush();
        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) {
                    break;
                }
                System.out.println(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                if (in.available() > 0) {
                    continue;
                }
                int returnCode = channel.getExitStatus();
                System.out.println("exit-status: " + channel.getExitStatus());
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {

            }
        }
        System.out.println("stop");
        os.close();
        in.close();
        channel.disconnect();
        session.disconnect();
        return "connecting!";
    }
}
