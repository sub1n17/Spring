package org.example.ch04.service;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dao.User3DAO;
import org.example.ch04.dto.User3DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User3Service {

    private final User3DAO dao;

    public void register(User3DTO dto) {
        dao.insert(dto);
    }
    public User3DTO findById(String userid) {
        return dao.select(userid);
    }
    public List<User3DTO> findAll() {
        return dao.selectAll();
    }
    public void modify(User3DTO dto) {
        dao.update(dto);
    }
    public void remove(String userid) {
        dao.delete(userid);
    }
}
