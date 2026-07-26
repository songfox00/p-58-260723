package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.dto.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayings.reversed();
    }

    public PageDto findByContentContainingIdDesc(String keyword, int pageSize, int page) {

        // 페이징 처리 된 결과 + 페이징 메타 정보
        // 현재 페이지 번호 + 페이지 사이즈 + 전체 페이지 개수 + 시작 페이지 번호 + 마지막 페이지 번호

        // 명언 목록 + 페이지 번호 + 전체 페이지 개수\

        // 여러개의 값을 하나로 다루는 법 -> 배열, 클래스
        List<WiseSaying> result = wiseSayings
                .reversed()
                .stream()
                .filter(
                        w -> w.getContent().contains(keyword)
                )
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .toList();

        int totalItems = wiseSayings.size();

        return new PageDto(page, pageSize, totalItems, result);
    }

    public PageDto findByAuthorContainingIdDesc(String keyword, int pageSize, int page) {
        List<WiseSaying> result = wiseSayings
                .reversed()
                .stream()
                .filter(
                        w -> w.getAuthor().contains(keyword)
                )
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .toList();
        int totalItems = wiseSayings.size();

        return new PageDto(page, pageSize, totalItems, result);
    }
}