package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.standard.Util;

import java.util.Map;

public class WiseSayingFileRepository {

    private int lastId=0;

    public WiseSaying save(WiseSaying wiseSaying) {

        if(wiseSaying.isNew()){
            wiseSaying.setId(++lastId);
        }
        // wiseSaying -> map
        Map<String, Object> wiseSayingMap = wiseSaying.toMap();

        //map -> json
        String jsonStr = Util.json.toString(wiseSayingMap);

        //파일로 생성 / 저장
        Util.file.set("db/wiseSaying/%d.json" .formatted(wiseSaying.getId()), jsonStr);

        return wiseSaying;
    }

    public WiseSaying findByIdOrNull(int id) {

        String jsonStr = Util.file.get("db/wiseSaying/%d.json" .formatted(id), "");

        if(jsonStr.isEmpty())
            return null;

        Map<String, Object> wiseSayingMap = Util.json.toMap(jsonStr);
        WiseSaying wiseSaying = WiseSaying.fromMap(wiseSayingMap);

        return wiseSaying;
    }
}
