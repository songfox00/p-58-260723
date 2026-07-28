package com.back;

import com.back.global.AppConfig;
import com.back.global.AppContext;

public class Main {
    public static void main(String[] args) {

        AppConfig.setDevMode();
        AppContext.init(true);
        App app = new App();
        app.run();
    }
}