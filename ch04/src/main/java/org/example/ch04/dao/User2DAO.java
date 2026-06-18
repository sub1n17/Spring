package org.example.ch04.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.ch04.dto.User2DTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface User2DAO {

    public void insert(User2DTO dto);
    public User2DTO select(String userid);
    public List<User2DTO> selectAll() ;
    public void update(User2DTO dto);
    public void delete(String userid);
}
