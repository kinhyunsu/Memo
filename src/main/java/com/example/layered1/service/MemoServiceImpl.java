package com.example.layered1.service;

import com.example.layered1.dto.MemoRequestDto;
import com.example.layered1.dto.MemoResponseDto;
import com.example.layered1.entity.Memo;
import com.example.layered1.repository.MemoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        return memoRepository.saveMemo(memo);
    }

    @Override
    public List<MemoResponseDto> findAllMemos() {


        return memoRepository.findAllMemos();
    }

    @Override
    public MemoResponseDto findMemoById(Long id) {

        Optional<Memo> optionalMemo = memoRepository.findMemoById(id);

        if (optionalMemo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        // Optional 객체 꺼내는 법
        return new MemoResponseDto(optionalMemo.get());
    }

    @Override
    public MemoResponseDto updateMemo(Long id, String title, String contents) {

//        Memo memo = memoRepository.findMemoById(id);
//        if (memo == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
//        }
//
//        if (title == null || contents == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
//        }
//
//        memo.update(title, contents);
//
//
//        return new MemoResponseDto(memo);
        return null;
    }

    @Override
    public MemoResponseDto updateTitle(Long id, String title, String contents) {

//        // memo 조회
//        Memo memo = memoRepository.findMemoById(id);
//        if (memo == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
//        }
//
//        if (title == null || contents != null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
//        }
//
//        memo.updateTitle(title);
//
//        return new MemoResponseDto(memo);
        return null;
    }

    @Override
    public void deleteMemo(Long id) {
//        Memo memo = memoRepository.findMemoById(id);
//        if (memo == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
//        }
//
//        memoRepository.deleteMemo(id);

    }
}
