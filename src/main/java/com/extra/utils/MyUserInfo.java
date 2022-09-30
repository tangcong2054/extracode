package com.extra.utils;

import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

import javax.swing.*;

public class MyUserInfo implements UserInfo, UIKeyboardInteractive {
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean promptYesNo(String message) {
        Object[] options = {"yes", "no"};
        int foo = 0;
        return foo == 0;
    }

    @Override
    public String getPassphrase() {
        return null;
    }

    @Override
    public boolean promptPassphrase(String message) {
        return false;
    }

    @Override
    public boolean promptPassword(String message) {
        return false;
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public String[] promptKeyboardInteractive(String destination,
                                              String name,
                                              String instruction,
                                              String[] prompt,
                                              boolean[] echo) {
        return null;
    }
}

