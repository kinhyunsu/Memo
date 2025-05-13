package com.example.layered1.Controller;

import com.example.layered1.dto.MemoRequestDto;
import com.example.layered1.dto.MemoResponseDto;
import com.example.layered1.entity.Memo;
import com.example.layered1.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //@Controller + @ResponseBody
@RequestMapping("/memos") //prefix
public class MemoController {

    private final MemoService memoService;
    // 생성자 주입, 클래스가 필요로 하는 의존성을 생성자를 통해 전달하는 방식
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }


    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(@RequestBody MemoRequestDto dto) {


        // Service Layer 호출, 응답
        return new ResponseEntity<>(memoService.saveMemo(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<MemoResponseDto> findAllMemos() {

        return memoService.findAllMemos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<MemoResponseDto> findMemoById(@PathVariable Long id) {

        return new ResponseEntity<>(memoService.findMemoById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemoResponseDto> updateMemo(
        @PathVariable Long id,
        @RequestBody MemoRequestDto dto
    ) {
        return new ResponseEntity<>(memoService.updateMemo(id, dto.getTitle(), dto.getContents()),HttpStatus.OK);
    }
}
