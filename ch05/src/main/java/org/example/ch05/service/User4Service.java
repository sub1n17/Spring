package org.example.ch05.service;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dao.User4DAO;
import org.example.ch05.dto.User4DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User4Service {

    private final User4DAO dao;

    public void register(User4DTO dto) {
        dao.insert(dto);
    }
    public User4DTO findById(String userid) {
        return dao.select(userid);
    }
    public List<User4DTO> findAll() {
        return dao.selectAll();
    }
    public void modify(User4DTO dto) {
        dao.update(dto);
    }
    public void remove(String userid) {
        dao.delete(userid);
    }
}
