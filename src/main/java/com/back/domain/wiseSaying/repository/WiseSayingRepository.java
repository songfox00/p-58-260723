package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.dto.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {
    boolean delete(int id);
    Optional<WiseSaying> findById(int id);
    WiseSaying save(WiseSaying wiseSaying);
    List<WiseSaying> findListDesc();
    PageDto findByContentContainingIdDesc(String keyword, int pageSize, int page);
    PageDto findByAuthorContainingIdDesc(String keyword, int pageSize, int page);
}
