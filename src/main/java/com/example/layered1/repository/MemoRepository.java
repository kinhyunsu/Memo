package com.example.layered1.repository;

import com.example.layered1.dto.MemoResponseDto;
import com.example.layered1.entity.Memo;

import java.util.List;

public interface MemoRepository {

    Memo saveMemo(Memo memo);
    List<MemoResponseDto> findAllMemos();

    Memo findMemoById(Long id);

    void deleteMemo(Long id);

}
