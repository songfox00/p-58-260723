package com.back;

import com.back.global.AppContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AppContext.init();
        App app = new App();
        app.run();
    }
}