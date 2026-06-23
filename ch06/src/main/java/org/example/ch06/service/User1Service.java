package org.example.ch06.service;

import lombok.RequiredArgsConstructor;
import org.example.ch06.dto.User1DTO;
import org.example.ch06.entity.User1;
import org.example.ch06.repository.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {

    // @RequiredArgsConstructor 어노테이션으로 생성자 주입
    private final User1Repository repository;

    // 기본 서비스 메서드
    public void register(User1DTO dto){

        // DTO를 Entity 변환
        User1 entity = dto.toEntity();

        // JPA save() 메서드 호출, Entity가 데이터베이스에 INSERT
        repository.save(entity);
    }

    public User1DTO getUser(String userid){
        // JPA 조회, Optional 타입은 엔티티를 안전하게 사용하기 위한 wrapper 클래스
        Optional<User1> optUser1 = repository.findById(userid);

        // Entity 존재 여부 확인
        if(optUser1.isPresent()) {
            // 존재한다면 Optional 타입으로 포장된 Entity 꺼내기
            User1 entity = optUser1.get();

            // DTO 반환 후 반환
            return entity.toDTO();
        }
        return null;
    }

    public List<User1DTO> getUserAll(){

        // JPA 조회 메서드 호출, SELECT * FROM User1
        List<User1> entityList = repository.findAll();

        // DTO 리스트 변환
        List<User1DTO> dtoList = entityList.stream()
                .map(entity -> entity.toDTO())
                .toList();

        return dtoList;
    }

    public void modify(User1DTO dto){
        // 엔티티 존재 여부 확인
        boolean isExist = repository.existsById(dto.getUserid());

        // 수정하려는 엔티티가 존재하면 수정
        if(isExist) {

            // DTO를 Entity 변환
            User1 entity = dto.toEntity();

            // JPA 수정 메서드, save() 메서드는 INSERT or UPDATE 수행
            repository.save(entity);
        }

    }

    public void remove(String userid){
        // JPA 삭제 메서드 호출, delete from user1 where userid='아이디' 수행
        repository.deleteById(userid);
    }


}