package com.example.layered1.service;

import com.example.layered1.dto.MemoRequestDto;
import com.example.layered1.dto.MemoResponseDto;
import com.example.layered1.entity.Memo;
import com.example.layered1.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoRepository memoRepository;

    public MemoServiceImpl(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Override
    public MemoResponseDto saveMemo(MemoRequestDto dto) {

        // 요청받은 데이터로 MEMO 객체 생성 ID 없음 (title과 contents를 받기 때문)
        Memo memo = new Memo(dto.getTitle(), dto.getContents());

        //  DB에 저장
        Memo savedMemo = memoRepository.saveMemo(memo);

        return new MemoResponseDto(savedMemo);
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {


        return memoRepository.findAllMemos();
    }
}
