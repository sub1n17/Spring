package org.example.sub2;

import org.springframework.stereotype.Component;

// 해당 클래스 객체를 자동으로 컨테이너에 빈등록
@Component
public class RAM {
    public void show() {
        System.out.println("RAM - SAMSUNG DDR5 32GB");
    }
}
