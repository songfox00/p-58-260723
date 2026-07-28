package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.dto.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingRepository {
    public boolean delete(int id);
    public Optional<WiseSaying> findById(int id);
    public WiseSaying save(WiseSaying wiseSaying);
    public List<WiseSaying> findListDesc();
    public PageDto findByContentContainingIdDesc(String keyword, int pageSize, int page);
    public PageDto findByAuthorContainingIdDesc(String keyword, int pageSize, int page);
}
