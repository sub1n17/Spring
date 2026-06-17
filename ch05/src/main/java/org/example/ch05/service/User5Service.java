package org.example.ch05.service;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dao.User5DAO;
import org.example.ch05.dto.User5DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User5Service {

    private final User5DAO dao;

    public void register(User5DTO dto) {
        dao.insert(dto);
    }
    public User5DTO findById(int seq) {
        return dao.select(seq);
    }

    public List<User5DTO> findAll() {
        return dao.selectAll();
    }
    public void modify(User5DTO dto) {
        dao.update(dto);
    }
    public void remove(int seq) {
        dao.delete(seq);
    }
}
