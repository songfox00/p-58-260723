package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.dto.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;
import com.back.global.AppContext;

import java.util.Optional;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }

    public void modify(WiseSaying wiseSaying, String newContent, String newAuthor) {

        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public WiseSaying write(String saying, String author) {
        WiseSaying wiseSaying = new WiseSaying(saying, author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public PageDto findListDesc(String keywordType, String keyword, int pageSize, int page) {

        if (keywordType.equals("content")) {
            return wiseSayingRepository.findByContentContainingIdDesc(keyword, pageSize, page);
        } else {
            return wiseSayingRepository.findByAuthorContainingIdDesc(keyword, pageSize, page);
        }
    }
}