package com.back;

import com.back.domain.system.controller.SystemController;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.global.AppContext;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private WiseSayingController wiseSayingController;
    private SystemController systemController = AppContext.systemController;

    public App() {
        this.sc = AppContext.sc;
        wiseSayingController= AppContext.wiseSayingController;
        systemController = AppContext.systemController;
    }

    public void run(){
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "등록" -> wiseSayingController.actionAdd();
                case "목록" -> wiseSayingController.actionList();
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }
    }
}
