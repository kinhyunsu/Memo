package com.example.layered1.entity;

import com.example.layered1.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Memo {
    //id만 변경 가능
    @Setter
    private Long id;
    private String title;
    private String contents;

    public Memo(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    //dto 형태를 넣게 되면 항상 dto 형태가 들어와야 하지만 기본타입으로 만들면 재사용성 증가, 누구든지 update 메서드 사용 가능
    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

}