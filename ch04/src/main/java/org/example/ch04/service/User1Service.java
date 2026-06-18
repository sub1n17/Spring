package org.example.ch04.service;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dao.User1DAO;
import org.example.ch04.dto.User1DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User1Service {

    // ⭐ 대상 속성에 final 선언해서 @RequiredArgsConstructor으로 객체 주입
    private final User1DAO dao;

    // DAO 호출 메서드
    public void register(User1DTO dto){
        dao.insert(dto);
    }
    public User1DTO getById(String userid){
        return dao.select(userid);
    }
    public List<User1DTO> getAll(){
        return dao.selectAll();
    }
    public void modify(User1DTO user1DTO){
        dao.update(user1DTO);
    }

    public void remove(String userid){
        dao.delete(userid);
    }

}
