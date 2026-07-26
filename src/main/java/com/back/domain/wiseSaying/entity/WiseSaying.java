package com.back.domain.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter // 어노테이션. 표식(자바, 프레임워크, IDE)
@NoArgsConstructor // 매개변수 없는 기본 생성자 => 외부 라이브러리
@AllArgsConstructor // 모든 인스턴스 변수에 대한 매개변수를 받는 생성자

public class WiseSaying {
    private int id;
    private String content;
    private String author;

    public WiseSaying(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public boolean isNew() {
        return id == 0;
    }
}