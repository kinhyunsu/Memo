package com.example.layered1.service;

import com.example.layered1.dto.MemoRequestDto;
import com.example.layered1.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {

    MemoResponseDto saveMemo(MemoRequestDto dto);
    List<MemoResponseDto> findAllMemos();

    MemoResponseDto findMemoById(Long id);
}
