package org.example.ch04.service;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dao.User2DAO;
import org.example.ch04.dto.User2DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2DAO dao;

    public void register(User2DTO dto) {
        dao.insert(dto);
    }
    public User2DTO findById(String userid) {
        return dao.select(userid);
    }
    public List<User2DTO> findAll() {
        return dao.selectAll();
    }
    public void modify(User2DTO dto) {
        dao.update(dto);
    }
    public void remove(String userid) {
        dao.delete(userid);
    }
}
