package org.example.ch04.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.ch04.dto.User5DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface User5DAO {

    public void insert(User5DTO dto);
    public User5DTO select(int seq);
    public List<User5DTO> selectAll() ;
    public void update(User5DTO dto);
    public void delete(int seq);
}
