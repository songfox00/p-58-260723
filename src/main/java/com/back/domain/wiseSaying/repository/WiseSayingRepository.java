package com.back.domain.wiseSaying.repository;

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

    public List<WiseSaying> findByContentContainingIdDesc(String keyword, int pageSize) {
        return wiseSayings
                .reversed()
                .stream()
                .filter(
                        w -> w.getContent().contains(keyword)
                )
                .limit(pageSize)
                .toList();
    }

    public List<WiseSaying> findByAuthorContainingIdDesc(String keyword, int pageSize) {
        return wiseSayings
                .reversed()
                .stream()
                .filter(
                        w -> w.getAuthor().contains(keyword)
                )
                .limit(pageSize)
                .toList();
    }
}