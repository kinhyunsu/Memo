package com.example.layered1.repository;


import com.example.layered1.dto.MemoResponseDto;
import com.example.layered1.entity.Memo;
import org.springframework.stereotype.Repository;

import java.util.*;

// DB와 상호작용
@Repository
public class MemoRepositoryImpl implements MemoRepository {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @Override
    public Memo saveMemo(Memo memo) {

        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
        memo.setId(memoId);

        memoList.put(memoId, memo);

        return memo;
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {

        //init List
        List<MemoResponseDto> allMemos = new ArrayList<>();

        // HashMap<Memo> -> List<MemoResponseDto>
        for (Memo memo : memoList.values()) {
            MemoResponseDto responseDto = new MemoResponseDto(memo);
            allMemos.add(responseDto);
        }
        return allMemos;
    }
}
